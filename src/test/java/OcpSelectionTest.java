import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;import org.springframework.core.env.MapPropertySource;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import java.util.*;import config.AppConfig;import metier.*;
class OcpSelectionTest {
    AnnotationConfigApplicationContext open(String profile,String target){var c=new AnnotationConfigApplicationContext();if(profile!=null)c.getEnvironment().setActiveProfiles(profile);c.getEnvironment().getPropertySources().addFirst(new MapPropertySource("test",Map.of("DAO_TARGET",target)));c.register(AppConfig.class);return c;}
    void verify(String profile,String target,double result){try(var c=open(profile,target)){c.refresh();assertEquals(result,c.getBean(IMetier.class).calcul());}}
    @Test void primary(){verify("primary","dao",200);}
    @Test void alias(){verify("alias","dao",440);}
    @Test void dynamiqueDao(){verify("dynamic","dao",200);}
    @Test void dynamiqueDao2(){verify("dynamic","dao2",300);}
    @Test void dynamiqueFichier(){verify("dynamic","daoFile",360);}
    @Test void dynamiqueApi(){verify("dynamic","daoApi",440);}
    @Test void profils(){verify("prod","dao",200);verify("dev","dao",300);}
    @Test void cibleInconnueRefusee(){try(var c=open("dynamic","inconnue")){assertThrows(Exception.class,c::refresh);}}
    @Test void ambiguiteSansStrategie(){try(var c=open(null,"dao")){Exception e=assertThrows(Exception.class,c::refresh);Throwable cause=e;while(cause.getCause()!=null)cause=cause.getCause();assertInstanceOf(NoUniqueBeanDefinitionException.class,cause);}}
    @Test void agregationSansDoublerAlias(){try(var c=open("dynamic","dao")){c.refresh();var m=c.getBean(MetierMultiple.class);assertEquals(650,m.calcul());assertEquals(4,m.getDaoMap().size());}}
}

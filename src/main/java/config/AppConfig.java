package config;
import org.springframework.context.annotation.*;
import dao.IDao;import metier.MetierMultiple;import java.util.*;
/** Les profils de stratégie sont exclusifs pour éviter plusieurs beans @Primary. */
@Configuration @ComponentScan({"dao","metier"}) @PropertySource("classpath:app.properties")
@Import({PrimaryDaoConfig.class,DaoAliasConfig.class,DynamicDaoConfig.class,ProfileDaoConfig.class})
public class AppConfig {
    @Bean public MetierMultiple metierMultiple(List<IDao> allDaos, Map<String,IDao> daos) {
        // Les alias de sélection ne doivent pas compter deux fois dans l'agrégation.
        Map<String,IDao> sources=new LinkedHashMap<>();
        for(String name:List.of("dao","dao2","daoFile","daoApi"))sources.put(name,daos.get(name));
        List<IDao> selected = allDaos.stream().filter(sources::containsValue).distinct().toList();
        return new MetierMultiple(selected,sources);
    }
}

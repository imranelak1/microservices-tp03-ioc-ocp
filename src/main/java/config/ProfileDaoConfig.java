package config;
import dao.*;import org.springframework.context.annotation.*;
/** Choix par environnement, activé avant le rafraîchissement du contexte. */
@Configuration
public class ProfileDaoConfig {
    @Bean @Primary @Profile("prod") public IDao daoProd(){return new DaoImpl();}
    @Bean @Primary @Profile("dev") public IDao daoDev(){return new DaoImpl2();}
}

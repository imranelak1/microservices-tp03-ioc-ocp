package config;

import dao.*;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/** Stratégie C : sélection externe sans changement du métier. */
@Configuration
@Profile("dynamic")
public class DynamicDaoConfig {
  @Bean
  @Primary
  public IDao dynamicDao(Environment env) {
    String target = env.getProperty("DAO_TARGET", env.getProperty("dao.target", "dao2"));
    return switch (target) {
      case "dao" -> new DaoImpl();
      case "dao2" -> new DaoImpl2();
      case "daoFile" -> new DaoFile();
      case "daoApi" -> new DaoApi();
      default -> throw new IllegalArgumentException("Cible DAO inconnue : " + target);
    };
  }
}

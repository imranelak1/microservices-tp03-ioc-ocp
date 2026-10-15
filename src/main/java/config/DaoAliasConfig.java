package config;

import dao.*;
import org.springframework.context.annotation.*;

/** Stratégie B : un bean de configuration pointe vers l'API. */
@Configuration
@Profile("alias")
public class DaoAliasConfig {
  @Bean
  @Primary
  public IDao daoAlias() {
    return new DaoApi();
  }
}

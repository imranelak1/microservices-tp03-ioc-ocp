package config;

import dao.*;
import org.springframework.context.annotation.*;

/** Stratégie A : défaut statique choisi par @Primary. */
@Configuration
@Profile("primary")
public class PrimaryDaoConfig {
  @Bean
  @Primary
  public IDao defaultDao() {
    return new DaoImpl();
  }
}

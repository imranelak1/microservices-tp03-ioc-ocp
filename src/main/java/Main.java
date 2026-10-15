import config.AppConfig;
import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/** Arguments : stratégie primary, alias, dynamic, prod ou dev. */
public class Main {
  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext()) {
      String strategy = args.length == 0 ? "dynamic" : args[0];
      context.getEnvironment().setActiveProfiles(strategy);
      context.register(AppConfig.class);
      context.refresh();
      System.out.println(
          "Stratégie "
              + strategy
              + " — Résultat final : "
              + context.getBean(IMetier.class).calcul());
    }
  }
}

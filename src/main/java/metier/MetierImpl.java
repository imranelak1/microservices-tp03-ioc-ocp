package metier;
import dao.IDao;import org.springframework.stereotype.Service;import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Primary;
/** Métier inchangé pour toutes les stratégies de sélection. */
@Service @Primary
public class MetierImpl implements IMetier {
    private final IDao dao;
    public MetierImpl(IDao source) { this.dao=java.util.Objects.requireNonNull(source); }
    @PostConstruct public void init() { System.out.println("[TRACE] Implémentation DAO injectée : "+dao.getClass().getSimpleName()); }
    public double calcul() { return dao.getValue()*2; }
}

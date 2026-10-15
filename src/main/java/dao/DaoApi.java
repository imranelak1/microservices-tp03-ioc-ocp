package dao;
import org.springframework.stereotype.Component;
/** Source daoApi simulée comme dans le TP. */
@Component("daoApi")
public class DaoApi implements IDao { public double getValue() {System.out.println("[DAO] DaoApi : 220.0");return 220.0;} }

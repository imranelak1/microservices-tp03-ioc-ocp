package dao;

import org.springframework.stereotype.Component;

/** Source daoFile simulée comme dans le TP. */
@Component("daoFile")
public class DaoFile implements IDao {
  public double getValue() {
    System.out.println("[DAO] DaoFile : 180.0");
    return 180.0;
  }
}

package dao;

import org.springframework.stereotype.Component;

/** Source dao simulée comme dans le TP. */
@Component("dao")
public class DaoImpl implements IDao {
  public double getValue() {
    System.out.println("[DAO] DaoImpl : 100.0");
    return 100.0;
  }
}

package dao;

import org.springframework.stereotype.Component;

/** Source dao2 simulée comme dans le TP. */
@Component("dao2")
public class DaoImpl2 implements IDao {
  public double getValue() {
    System.out.println("[DAO] DaoImpl2 : 150.0");
    return 150.0;
  }
}

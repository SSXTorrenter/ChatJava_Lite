/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package base.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Outils {

  /** Retourne une connexion avec une base de données MySQL. */
  public static Connection connect (String nomBase, String address, int port) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    Properties props = new Properties();
    props.put("user", "chat"); props.put("password", "chat1801"); props.put("charSet", "UTF-8");
    return DriverManager.getConnection("jdbc:mysql://" + address + ":" + port + "/" + nomBase, props);
  } // connect

} // Outils

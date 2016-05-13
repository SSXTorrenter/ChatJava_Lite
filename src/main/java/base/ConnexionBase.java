/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package base;

import base.mysql.Outils;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnexionBase {

  private static Connection con = null; /* La connexion avec la base */

  /* Établit la connexion et affecte con. */
  public static void connect () {
    try {
        con = Outils.connect("Chat","192.168.1.205",3306);
    }
    catch (SQLException e){
        System.out.println("ConnexionBase: " + e.getMessage()); e.printStackTrace();
        throw new RuntimeException(e);
    }
    catch (ClassNotFoundException e) {
        System.out.println("ConnexionBase: " + e.getMessage()); e.printStackTrace();
        throw new RuntimeException(e);
    }
  } // Constructeur

  /** Retourne la connexion */
  public static Connection get () {
    if (con == null) {connect();}
    return con;
  } // get

  /** Ferme la connexion */
  public static void close () {
    if (con == null) {return;}
    try {con.close(); con = null;}
    catch (SQLException e) {System.out.println("ConnexionBase: " + e.getMessage()); e.printStackTrace();}
  } // close

} // ConnexionBase

/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package base;

import base.mysql.Outils;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class ConnexionBase {

    private ConnexionBase() {
    }

    private static Connection con = null;
    private static final String ADDRESS = "ssxtorrenter.ddns.net";
    private static final int PORT = 3306;

    /* La connexion avec la base */
    private static Logger log = Logger.getLogger(ConnexionBase.class.getName());

    /* Établit la connexion et affecte con. */
    public static void connect() {
        try {
            con = Outils.connect("Chat", ADDRESS, PORT);
        } catch (SQLException | ClassNotFoundException e) {
            log.info(e);
        }
    } // Constructeur

    /**
     * Retourne la connexion
     */
    public static Connection get() throws SQLException {
        if (con == null || con.isClosed()) {
            connect();
        }
        return con;
    }//get

    /**
     * Ferme la connexion
     */
    public static void close() {
        if (con == null) {
            return;
        }
        try {
            con.close();
            con = null;
        } catch (SQLException e) {
            log.info(e);
        }
    } // close

} // ConnexionBase

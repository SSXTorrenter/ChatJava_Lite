/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package base;

import domaine.Message;
import domaine.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author thomas
 */
public class MessageDao {

    private MessageDao() {
    }

    private static Logger log = Logger.getLogger(MessageDao.class.getName());

    public static List<Message> getListeMessage(int idO, int idF) throws SQLException {
        List<Message> al = new ArrayList();

        try {
            try (Connection con = ConnexionBase.get();
                    PreparedStatement preparedStmt = con.prepareStatement("SELECT  Users.idUser,Users.login,text FROM Messages\n"
                            + "JOIN Users ON Users.idUser = Messages.idUserFrom\n"
                            + "WHERE idUserFrom = ? AND idUserTo = ?\n"
                            + "OR idUserFrom = ? AND idUserTo = ?\n"
                            + "ORDER BY dateTime");) {
                preparedStmt.setInt(1, idO);
                preparedStmt.setInt(2, idF);
                preparedStmt.setInt(3, idO);
                preparedStmt.setInt(4, idF);
                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    al.add(new Message(new User(rs.getInt("idUser"), rs.getString("login")), rs.getString("text")));
                }
            }
        } catch (Exception e) {
            log.info(e);
        }
        return al;
    }

    public static void sendMessage(int idO, int idF, String text) throws SQLException {
        try {
            try (Connection con = ConnexionBase.get();
                    PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Messages (idUserFrom, idUserTo, text) VALUES (?,?,?)");) {
                preparedStmt.setInt(1, idO);
                preparedStmt.setInt(2, idF);
                preparedStmt.setString(3, text);
                preparedStmt.execute();
            }
        } catch (Exception e) {
            log.info(e);
        }
    }
}

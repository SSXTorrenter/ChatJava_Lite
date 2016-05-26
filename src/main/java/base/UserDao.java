/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import domaine.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.*;

/**
 *
 * @author thomas
 */
public class UserDao {

    private UserDao() {
    }

    private static Logger log = Logger.getLogger(MessageDao.class.getName());

    public static User logUser(String login, String password) throws SQLException {
        try {

            try (Connection con = ConnexionBase.get();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT idUser,login,password,lastSeen FROM Users WHERE login=\"" + login + "\"");) {
                rs.next();
                if (rs.getString("password").equals(DigestUtils.sha1Hex(password))) {
                    return new User(rs.getInt("idUser"), rs.getString("login"));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public static List<User> getListeUser(int id) throws SQLException {
        List al = new ArrayList();
        try {
            try (Connection con = ConnexionBase.get();
                    PreparedStatement preparedStmt = con.prepareStatement("SELECT idUser,login,lastSeen FROM Users\n"
                            + "JOIN Friendship ON (Friendship.idUser1 = Users.idUser) OR \n"
                            + "(Friendship.idUser2 = Users.idUser)\n"
                            + "WHERE Users.idUser!=? AND Friendship.idUser1=? OR Friendship.idUser2=?");) {
                preparedStmt.setInt(1, id);
                preparedStmt.setInt(2, id);
                preparedStmt.setInt(3, id);

                ResultSet rs = preparedStmt.executeQuery();
                while (rs.next()) {
                    al.add(new User(rs.getInt("idUser"), rs.getString("login")));
                }
            }
        } catch (Exception e) {
            log.error(e);
        }
        return al;
    }

    public static void deleteFriend(int idO, int idF) throws SQLException {
        try {
            try (Connection con = ConnexionBase.get();
                    PreparedStatement preparedStmt = con.prepareStatement("DELETE FROM Friendship WHERE \n"
                            + "idUser1 = ? AND idUser2 = ?\n"
                            + "OR idUser1 = ? AND idUser2 = ?");) {
                preparedStmt.setInt(1, idO);
                preparedStmt.setInt(2, idF);
                preparedStmt.setInt(3, idF);
                preparedStmt.setInt(4, idO);
                preparedStmt.execute();
                preparedStmt.close();
            }
        } catch (Exception e) {
            log.error(e);
        }
    }
}

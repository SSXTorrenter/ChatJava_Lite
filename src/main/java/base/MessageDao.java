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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author thomas
 */
public class MessageDao {
    public static ArrayList getListeMessage (int idO, int idF) {
        ArrayList al = new ArrayList();
        try {
          Connection con = ConnexionBase.get();
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT  Users.idUser,Users.login,text FROM Messages\n" +
                                            "JOIN Users ON Users.idUser = Messages.idUserFrom\n" +
                                            "WHERE idUserFrom = " + idO + " AND idUserTo = " + idF + "\n" +
                                            "OR idUserFrom = " + idF + " AND idUserTo = " + idO + "\n" +
                                            "ORDER BY dateTime");
          while (rs.next()) {
            al.add(new Message(new User(rs.getInt("idUser"), rs.getString("login")),rs.getString("text")));
          }
        } catch (Exception e) {
            System.err.println("Erreur getListeMessage in MessageDao : " + e.getMessage());
            throw new RuntimeException(e);
        }
        return al;
  }
    public static void sendMessage(int idO, int idF, String text){
        try{
          Connection con = ConnexionBase.get();
          PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Messages (idUserFrom, idUserTo, text) VALUES (?,?,?)");
          preparedStmt.setInt(1, idO);preparedStmt.setInt(2, idF);preparedStmt.setString(3, text);
          preparedStmt.execute();
      } catch (Exception e) {
          System.err.println("Erreur sendMessage in MessageDao : " + e.getMessage());
          throw new RuntimeException(e);
      }
    }
}

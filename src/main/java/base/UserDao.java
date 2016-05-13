/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import domaine.User;
import java.sql.PreparedStatement;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author thomas
 */
public class UserDao {
    public static User logUser(String login,String password){
        try {
          Connection con = ConnexionBase.get();
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("SELECT idUser,login,password,lastSeen FROM Users WHERE login=\"" + login + "\"");
            if (rs.next()) {
                if (rs.getString("password").equals(DigestUtils.sha1Hex(password))) {
                    return new User(rs.getInt("idUser"),rs.getString("login"));
                }else{
                    return null;
                }
            }else{
                return null;
            }
        } catch (Exception e) {
          System.err.println("Erreur logUser in UserDao : " + e.getMessage());
          throw new RuntimeException(e);
        }
    }
    
    public static void invitUser(String userLogin, int idO){
        try {
          Connection con = ConnexionBase.get();
          PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO Friendship(idUser1, idUser2) VALUES (?,(SELECT idUser FROM Users WHERE UPPER(login)=UPPER(\"?\")))");
          preparedStmt.setInt(1, idO);preparedStmt.setString(2, userLogin);
          preparedStmt.execute();
          preparedStmt.close();
        } catch (Exception e) {
          System.err.println("Erreur invitUser in UserDao : " + e.getMessage());
          throw new RuntimeException(e);
        } 
    }
    
    public static ArrayList getListeUser (int id) {
        ArrayList al = new ArrayList();
        try {
          Connection con = ConnexionBase.get();
          Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery( "SELECT idUser,login,lastSeen FROM Users\n" +
                                            "JOIN Friendship ON (Friendship.idUser1 = Users.idUser) OR \n" +
                                            "(Friendship.idUser2 = Users.idUser)\n" +
                                            "WHERE Users.idUser!=" + id + " AND Friendship.idUser1=" + id + " OR Friendship.idUser2=" + id);
          while (rs.next()) {
            al.add(new User(rs.getInt("idUser"), rs.getString("login")));
          }
        } catch (Exception e) {
          System.err.println("Erreur getListeUser in UserDao : " + e.getMessage());
          throw new RuntimeException(e);
        }
        return al;
  }
    
  public static void deleteFriend(int idO, int idF){
      try{
          Connection con = ConnexionBase.get();
          PreparedStatement preparedStmt = con.prepareStatement("DELETE FROM Friendship WHERE \n" +
                                                                "idUser1 = ? AND idUser2 = ?\n" +
                                                                "OR idUser1 = ? AND idUser2 = ?");
          preparedStmt.setInt(1, idO);preparedStmt.setInt(2, idF);
          preparedStmt.setInt(3, idF);preparedStmt.setInt(4, idO);
          preparedStmt.execute();
          preparedStmt.close();
      } catch (Exception e) {
          System.err.println("Erreur deleteFriend in UserDao : " + e.getMessage());
          throw new RuntimeException(e);
      }
  }
}

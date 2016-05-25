/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package metier;
import domaine.User;
import base.UserDao;
import java.sql.SQLException;

public class ListeUserFriends extends ListeObjects<User>{
    public ListeUserFriends (int id) throws SQLException {super(UserDao.getListeUser(id));}
}

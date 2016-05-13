/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package metier;
import domaine.User;
import base.UserDao;

public class ListeUserFriends extends ListeObjects<User>{
    public ListeUserFriends (int id) {super(UserDao.getListeUser(id));}
}

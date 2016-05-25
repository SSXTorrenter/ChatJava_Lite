/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package metier;

import domaine.Message;
import base.MessageDao;
import java.sql.SQLException;


public class ListeMessage extends ListeObjects<Message>{
  public ListeMessage (int idO, int idF) throws SQLException {super (MessageDao.getListeMessage(idO,idF));}
}

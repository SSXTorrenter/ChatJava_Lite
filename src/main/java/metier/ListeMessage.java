/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package metier;

import domaine.Message;
import base.MessageDao;


public class ListeMessage extends ListeObjects<Message>{
  public ListeMessage (int idO, int idF) {super (MessageDao.getListeMessage(idO,idF));}
}

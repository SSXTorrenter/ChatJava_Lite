/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package domaine;

import java.util.*;

public class User {

    private int id;
    private String login;

    /**
     * Constructeur
     */
    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    // Constructeur
    /**
     * Accesseurs
     */
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
}

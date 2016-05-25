/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package domaine;

public class Message {

    private User autor;
    /* Identifiant */
    private String text;

    /* Nom */

    /**
     * Constructeur
     */
    public Message(User autor, String text) {
        this.autor = autor;
        this.text = text;
    } // Constructeur

    /**
     * Accesseurs
     */
    public User getAuthor() {
        return autor;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return autor.getLogin() + " : " + text;
    }
}

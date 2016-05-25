/**
 *
 * @author Rodriguez Thomas
 * @version 1.2
 */
package outils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import org.apache.log4j.Logger;

public class Validation {
    
    private Validation(){
    }
    
    private static Logger log = Logger.getLogger(Validation.class.getName());

    public static boolean pingHost(String host, int port) {
        try {
            Socket socket = new Socket();
            SocketAddress socketAddress = new InetSocketAddress(host, port);
            socket.connect(socketAddress, 1000);
            socket.close();
            return true;
        } catch (IOException e) {
            log.info(e);
        }
        return false;
    }

} // Validation

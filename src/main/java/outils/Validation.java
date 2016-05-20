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
import java.net.UnknownHostException;

public class Validation {
  
  public static boolean pingHost(String host, int port) {
    try {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(host, port);
        socket.connect(socketAddress, 1000);
        socket.close();
        return true;
    } catch (IOException e) {
        return false;
    }
  }

} // Validation
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.mysql;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.sql.SQLException;
import org.apache.log4j.Logger;
/**
 *
 * @author thomas
 */
public class OutilsTest {
    private static Logger log = Logger.getLogger(OutilsTest.class.getName());
    
    @Test
    public void test_connect1() throws ClassNotFoundException{
        Exception ex = null;
        try {
            Outils.connect("Chat", "ssxtorrenter.ddns.net", 3306);
        } catch (SQLException e) {
            ex = e;
        }
        assertEquals(ex, null);
    }
    
    @Test
    public void test_connect2() throws ClassNotFoundException{
        Exception ex = null;
        try {
            Outils.connect("Chat", "192.168.1.33", 3306);
        } catch (SQLException e) {
            ex = e;
        }
        assertNotEquals(ex, null);
    }
    
    @Test
    public void test_connect3() throws ClassNotFoundException{
        Exception ex = null;
        try {
            Outils.connect("chat", "ssxtorrenter.ddns.net", 3306);
        } catch (SQLException e) {
            ex = e;
        }
        assertNotEquals(ex, null);
    }
    
    @Test
    public void test_connect4() throws ClassNotFoundException{
        Exception ex = null;
        try {
            Outils.connect("Chat", "ssxtorrenter.ddns.net", 336);
        } catch (SQLException e) {
            ex = e;
        }
        assertNotEquals(ex, null);
    }
    
    
}

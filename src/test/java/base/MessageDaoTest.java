/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.apache.log4j.*;



/**
 *
 * @author thomas
 */
public class MessageDaoTest {
    private static Logger log = Logger.getLogger(MessageDao.class.getName());
    
    @Test
    public void test_getListeMessage(){
        try {
            List lstM = MessageDao.getListeMessage(1, 3);
            assertTrue(lstM.size()>0);
        } catch (SQLException e) {
            log.error(e);
        }
    }
    
    @Test
    public void test_getListeMessage_false(){
        try {
            List lstM = MessageDao.getListeMessage(122, 122);
            assertTrue(lstM.isEmpty());
        } catch (SQLException e) {
            log.error(e);
        }
    }
    
    @Test
    public void test_sendMessage(){
        Exception ex = null;
        try {
            MessageDao.sendMessage(3, 1, "test_sendMessage");
        } catch (Exception e) {
            ex = e;
        }
        assertEquals(ex, null);
    }
    
    @Test(enabled=false)//need to add trigger to database server
    public void test_sendMessage_throw_exception(){
        Exception ex = null;
        try {
            MessageDao.sendMessage(3, 19, "test_sendMessage");
        } catch (Exception e) {
            ex = e;
        }
        assertNotEquals(ex, null);
    }
}
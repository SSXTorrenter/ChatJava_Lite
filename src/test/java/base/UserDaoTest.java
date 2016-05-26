/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;


/**
 *
 * @author thomas
 */
public class UserDaoTest {
    private static Logger log = Logger.getLogger(UserDaoTest.class.getName());
    
    @Test
    public void test_logUser() throws SQLException{
        assertNotEquals(UserDao.logUser("thomas", "hello"),null);
    }
    
    @Test
    public void test_logUser_flase() throws SQLException{
        assertEquals(UserDao.logUser("wwrbe", "evev"),null);
    }
    
    @Test
    public void test_getListeUser(){
        try {
            List lstM = UserDao.getListeUser(1);
            assertNotEquals(lstM.size(),0);
        } catch (SQLException e) {
            log.error(e);
        }
    }
    
    @Test
    public void test_getListeUser_false(){
        try {
            List lstM = UserDao.getListeUser(100);
            assertEquals(lstM.size(),0);
        } catch (SQLException e) {
            log.error(e);
        }
    }
    
    @Test
    public void test_deleteFriend(){
        Exception ex = null;
        try {
            UserDao.deleteFriend(1, 11);
        } catch (Exception e) {
            ex = e;
        }
        assertEquals(ex, null);
    }
    
    @Test(enabled=false)
    public void test_deleteFriend_False(){
        Exception ex = null;
        try {
            UserDao.deleteFriend(1, 111);
        } catch (Exception e) {
            ex = e;
        }
        assertNotEquals(ex, null);
    }
}

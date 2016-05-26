/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domaine;

import org.testng.annotations.*;
import static org.testng.Assert.*;


/**
 *
 * @author thomas
 */
public class UserTest {
    User user = new User(100,"userTest");
    
    @Test
    public void test_getId(){
        assertEquals(user.getId(), 100);
    }
    
    @Test
    public void test_getLogin(){
        assertEquals(user.getLogin(), "userTest");
    }
}

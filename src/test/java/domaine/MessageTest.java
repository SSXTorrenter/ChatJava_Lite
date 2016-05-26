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
public class MessageTest {
    
    User user = new User(100,"userTest");
    Message message = new Message(user,"hello");
    
    @Test
    public void test_getAuthor(){
        assertEquals(message.getAuthor(),user);
    }
    
    @Test
    public void test_getTest(){
        assertEquals(message.getText(),"hello");
    }
    
    @Test
    public void test_toString(){
        assertEquals(message.toString(),"userTest : hello");
    }
}

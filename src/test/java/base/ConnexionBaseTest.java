/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;
import java.sql.Connection;
import java.sql.SQLException;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 *
 * @author thomas
 */
public class ConnexionBaseTest {
    Connection con = null;
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ConnexionBase.class.getName());
    
    
    @BeforeTest
    public void setup(){
        try {
            con = ConnexionBase.get();
        } catch (SQLException e) {
            log.error(e);
        }
    }
    
    @Test
    public void test_get(){
        assertNotNull(con);  
    }
    

}

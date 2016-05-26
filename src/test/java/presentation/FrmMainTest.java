/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domaine.User;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 *
 * @author thomas
 */
public class FrmMainTest {
    private FrmMain frmMain = new FrmMain();
    
    @Test
    public void test_actualiserListeAmis(){
        Exception ex = null;
        try {
            frmMain.actualiserListeAmis();
        } catch (Exception e) {
            ex = e;
        }
        assertNotEquals(ex, null);
    }
    
    @Test
    public void test_setOwner(){
        Exception ex = null;
        try {
            frmMain.setOwner(new User(1,"test"));
        } catch (Exception e) {
            ex = e;
        }
        assertEquals(ex, null);
    }
    
    @Test
    public void test_getOwner(){
        assertNotEquals(null, frmMain.getOwner());
    }
    
    @Test
    public void test_ownerExist(){
        assertTrue(frmMain.ownerExist());
    }
    
    
    @Test
    public void test_setOwner2(){
        Exception ex = null;
        try {
            frmMain.setOwner(null);
        } catch (Exception e) {
            ex = e;
        }
        assertEquals(ex, null);
    }
    
    @Test
    public void test_getOwner2(){
        assertEquals(null, frmMain.getOwner());
    }
    
    @Test
    public void test_ownerExist2(){
        assertFalse(frmMain.ownerExist());
    }
}

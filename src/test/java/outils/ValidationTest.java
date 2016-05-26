/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outils;

import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 *
 * @author thomas
 */
public class ValidationTest {
    
    @Test
    public void test_pingHost(){
        assertTrue(Validation.pingHost("www.google.ch",80));
    }
    
    @Test
    public void test_pingHost2(){
        assertTrue(Validation.pingHost("216.58.213.35",80));//Address of www.google.ch
    }
    
    @Test
    public void test_pingHost_false(){
        assertFalse(Validation.pingHost("worigjworigj",3333));
    }
    
    @Test
    public void test_pingHost_false2(){
        assertFalse(Validation.pingHost("10.10.10.10",3333));
    }
}

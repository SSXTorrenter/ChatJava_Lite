/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;


/**
 *
 * @author thomas
 */
public class ListeObjectsTest {
    private List liste = new ArrayList();
    private ListeObjects listeObjects;
    
    @BeforeMethod
    public void testSetUp(){
        for (int i = 0; i < 20; i++) {
            liste.add(i);
        }
        listeObjects = new ListeObjects(liste);
    }
    
    @Test
    public void del_should_delete(){
        int listeObjectSize = listeObjects.size();
        listeObjects.del(5);
        assertEquals(listeObjects.size(), listeObjectSize - 1);
    }
    
    @Test
    public void del_should_not_delete_when_k_not_correctly_defined(){
        int listeObjectSize = listeObjects.size();
        listeObjects.del(-1);
        assertEquals(listeObjects.size(), listeObjectSize);
    }
    
    @Test
    public void del_should_set_NO_POS_when_k_equals_pos(){
        listeObjects.setPos(10);
        listeObjects.del(10);
        assertNull(listeObjects.getCourant());
    }
    
    @Test
    public void del_should_change_pos_as_specified_in_comment(){
        int pos = 10;
        listeObjects.setPos(pos);
        listeObjects.del(pos + 1);
        listeObjects.del(pos - 1);
        assertEquals(pos - 1, listeObjects.getPos());
    }
    
    @Test
    public void delCourant_should_delete_at_pos(){
        listeObjects.setPos(10);
        Object obj = listeObjects.getCourant();
        listeObjects.delCourant();
        assertNotEquals(obj, listeObjects.getCourant());
    }
    
    @Test
    public void delCourant_should_delete_set_pos_at_NO_POS(){
        listeObjects.setPos(10);
        listeObjects.delCourant();
        assertEquals(listeObjects.getPos(), -1);
    }
    
    @Test
    public void delCourant_should_not_delete_when_pos_not_correctly_defined(){
        int listeObjectSize = listeObjects.size();
        listeObjects.setPos(listeObjects.size());
        listeObjects.delCourant();
        listeObjects.setPos(-1);
        listeObjects.delCourant();
        assertEquals(listeObjects.size(), listeObjectSize);
    }
    
    @Test
    public void add_should_add_at_k(){
        int i = 10;
        int k = 3;
        listeObjects.add(i, k);
        assertEquals(listeObjects.get(k), i);
    }
    
    @Test
    public void add_should_not_add_when_k_not_correctly_defined(){
        int i = 10;
        int k = -1;
        int size = listeObjects.size();
        listeObjects.add(i, k);
        assertEquals(size, listeObjects.size());
    }
    
    @Test
    public void add_should_change_pos_as_specified_in_comment(){
        int pos = 10;
        listeObjects.setPos(pos);
        listeObjects.add(10, pos);
        assertEquals(pos + 1, listeObjects.getPos());
    }
    
    @Test
    public void get_should_return_null_when_k_not_correctly_defined(){
        Object obj = listeObjects.get(-1);
        assertNull(obj);
    }
}

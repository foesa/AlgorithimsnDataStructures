import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
   
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    @Test
    public void get() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	for(int count =0;count<6;count++) {
    		testDLL.enqueue(count);
    	}
    	int ans = testDLL.get(0);
    	assertEquals("Checking insertBefore to a list containing 3 elements at position 0", 0, ans);
    	ans = testDLL.get(5);
    	assertEquals("Checking insertBefore to a list containing 3 elements at position 0", 5, ans);
    	ans = testDLL.get(3);
    	assertEquals("Checking insertBefore to a list containing 3 elements at position 0", 3, ans);
    }
    @Test
    public void enqueueAnddequeue() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertEquals("testing for empty",null,testDLL.dequeue());
    	for(int count =0;count<6;count++) {
    		testDLL.enqueue(count);
    	}
    	assertEquals("checking enqueue","0,1,2,3,4,5",testDLL.toString());
    	int[] popArr = new int[6];
		 for(int count =0; count<6;count++) {
			int num = testDLL.dequeue();
			popArr[count]= num;
		}
		 int[] anser = {0,1,2,3,4,5} ;
		 assertEquals("Checking deque",Arrays.toString(anser),Arrays.toString(popArr));
    }
    @Test    
    public void pushandpop() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertEquals("testing for empty",null,testDLL.pop());
    	for(int count =0;count<6;count++) {
    		testDLL.push(count);
    	}
    	assertEquals("checking push","5,4,3,2,1,0",testDLL.toString());
    	int[] popArr = new int[6];
		 for(int count =0; count<6;count++) {
			int num = testDLL.pop();
			popArr[count]= num;
		}
		 int[] anser = {5,4,3,2,1,0} ;
		 assertEquals("Checking pop",Arrays.toString(anser),Arrays.toString(popArr));
    }
    @Test
    public void deleteAt() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	for(int count =0;count<6;count++) {
    		testDLL.push(count);
    	}
    	testDLL.deleteAt(5);
    	assertEquals("delete end","5,4,3,2,1",testDLL.toString());
    	testDLL.deleteAt(0);
    	assertEquals("delete start","4,3,2,1",testDLL.toString());
    	testDLL.deleteAt(2);
    	assertEquals("delete middle","4,3,1",testDLL.toString());
    }
    @Test
    public void reverseEven() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	for(int count =0; count<6;count++) {
			testDLL.push(count);
    	}
		testDLL.reverse();
		assertEquals("Testing reverse","0,1,2,3,4,5",testDLL.toString());
		
    }
    @Test
    public void reverseOdd() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
		for(int count =0; count<5;count++) {
			testDLL.push(count);
    	}
		testDLL.reverse();
		assertEquals("Testing reverse","0,1,2,3,4",testDLL.toString());
    }
    
    @Test
    public void isEmpty() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	boolean empty = testDLL.isEmpty();
    	assertEquals("Testing reverse",true,empty);
    }
    
    @Test
    public void testMakeUnique() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.makeUnique();
    	assertEquals("", testDLL.toString());
    	testDLL.push(1);
    	testDLL.push(2);
    	testDLL.push(3);
    	testDLL.push(4);
    	testDLL.push(5);
    	testDLL.push(5);
    	testDLL.push(5);
    	testDLL.makeUnique();
    	assertEquals("5,4,3,2,1", testDLL.toString());
    }

}

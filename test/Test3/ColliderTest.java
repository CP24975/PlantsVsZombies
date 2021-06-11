package Test3;

import Game.Collider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColliderTest {

    private Collider testItem;

    @Before
    public void setUp() throws Exception {
        testItem = new Collider();
    }

    @After
    public void tearDown() throws Exception {
        testItem = null;
    }

    /**
     * Purpose: test isInsideCollider function
     * Input: left 3-value boundary of x : 99, 100, 101 (x == 100)
     * Expected:
     *      testItem.isInsideCollider(99) == False
     *      testItem.isInsideCollider(100) == False
     *      testItem.isInsideCollider(101) == True
     */
    @Test
    public void testIsInsideColliderLeft() {
        testItem.setLocation(100, 100);

        assertFalse(testItem.isInsideCollider(99));
        assertFalse(testItem.isInsideCollider(100));
        assertTrue(testItem.isInsideCollider(101));
    }

    /**
     * Purpose: test isInsideCollider function
     * Input: right 3-value boundary of x : 199, 200, 201 (x == 100)
     * Expected:
     *      testItem.isInsideCollider(199) == True
     *      testItem.isInsideCollider(200) == False
     *      testItem.isInsideCollider(201) == False
     */
    @Test
    public void testIsInsideColliderRight() {
        testItem.setLocation(100, 100);

        assertTrue(testItem.isInsideCollider(199));
        assertFalse(testItem.isInsideCollider(200));
        assertFalse(testItem.isInsideCollider(201));
    }
}
package test4;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import Game.view.GamePanel;
import zombie.model.*;
import plant.model.*;

public class ZombieTest {
	private Zombie testItem;
	private GamePanel gamePanel;

	@Before
	public void setUp() throws Exception { gamePanel = GamePanel.getInstance(); }
	@After
	public void tearDown() throws Exception { 
		testItem = null;
		gamePanel = null; 
	}
	
	
    /**
     * Purpose: create Zombie by Factory method
     * Input: getZombie ("zombie.model.NormalZombie", 0) , getZombie ("Zombie.model.NormalZombie,4),
     * 		 getZombie ("zombie.model.ConeHeadZombie", 0) , getZombie ("Zombie.model.ConeHeadZombie,4),
     * Expected:
     *      return SUCCESS
     *      
     */
	@Test
	public void TestZombieFactory() {
		testItem = Zombie.getZombie("Null Expected", 0);
		assertNull(testItem);
		
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertNotNull(testItem);
		assertEquals(NormalZombie.class.getName(), testItem.getClass().getName());
		assertEquals(0, testItem.getMyLane());
		
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 4);
		assertNotNull(testItem);
		assertEquals(NormalZombie.class.getName(), testItem.getClass().getName());
		assertEquals(4, testItem.getMyLane());
		
		testItem = Zombie.getZombie("zombie.model.ConeHeadZombie", 0);
		assertNotNull(testItem);
		assertEquals(ConeHeadZombie.class.getName(), testItem.getClass().getName());
		assertEquals(0, testItem.getMyLane());
		
		testItem = Zombie.getZombie("zombie.model.ConeHeadZombie", 4);
		assertNotNull(testItem);
		assertEquals(ConeHeadZombie.class.getName(), testItem.getClass().getName());
		assertEquals(4, testItem.getMyLane());
		
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 5);
		assertNull(testItem);
		
		testItem = Zombie.getZombie("zombie.model.NormalZombie", -1);
		assertNull(testItem);

		testItem = Zombie.getZombie("zombie.model.ConeHeadZombie", 5);
		assertNull(testItem);
		
		testItem = Zombie.getZombie("zombie.model.ConeHeadZombie", -1);
		assertNull(testItem);
	}
	

    /**
     * Purpose: test Zombie.getHealth() function
     * Input: getHealth();
     * Expected:
     *      return SUCCESS
     *      getHealth() == 1000;
     */
	@Test
	public void TestZombieGetHealth() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(1000 ,testItem.getHealth());
	}
	
    /**
     * Purpose: test Zombie.setHealth() function
     * Input: setHealth(500), (0), (-100)
     * Expected:
     *      return SUCCESS
     *      (500) = 500, (0) = 0,
     *      (-100) = -100
     *     
     */
	@Test
	public void TestZombieSetHealth() {
		testItem = Zombie.getZombie("zombie.model.ConeHeadZombie", 0);
		testItem.setHealth(500);
		assertEquals(500, testItem.getHealth());
		
		testItem.setHealth(0);
		assertEquals(0, testItem.getHealth());
		
		testItem.setHealth(-100);
		assertEquals(-100, testItem.getHealth());
	}
	
    /**
     * Purpose: test Zombie.getSpeed() function
     * Input: getSpeed();
     * Expected:
     *      return SUCCESS
     *      getHealth() == 1;
     */
	@Test
	public void TestZombieGetSpeed() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(1, testItem.getSpeed());
	}
    /**
     * Purpose: test Zombie.setSpeed() function
     * Input: setSpeed(2);
     * Expected:
     *      return SUCCESS
     *      (2) = 2
     */
	@Test
	public void TestZombieSetSpeed() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setSpeed(2);
		assertEquals(2, testItem.getSpeed());
	}
	
    /**
     * Purpose: test Zombie.GetXposition() function
     * Input: setSGetXpositionpeed();
     * Expected:
     *      return SUCCESS
     *      () = 1000
     */
	@Test
	public void TestZombieGetXposition() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(1000, testItem.getXPosition());
	}
    /**
     * Purpose: test Zombie.setXposition() function
     * Input: setXposition(0);
     * Expected:
     *      return SUCCESS
     *      (0) = 0
     */
	@Test
	public void TestZombieSetXposition() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setXPosition(0);
		assertEquals(0, testItem.getXPosition());
	}
	
    /**
     * Purpose: test Zombie.GetMyLane() function
     * Input: GetMyLane();
     * Expected:
     *      return SUCCESS
     *      () = 0
     */
	@Test
	public void TestZombieGetMyLane() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(0, testItem.getMyLane());
	}
	
    /**
     * Purpose: test Zombie.setMyLane() function
     * Input: setMyLane(4);
     * Expected:
     *      return SUCCESS
     *      (4) = 4
     */
	@Test
	public void TestZombieSetMyLane() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setMyLane(4);
		assertEquals(4, testItem.getMyLane());
	}
	
    /**
     * Purpose: test Zombie.getAlive() function
     * Input: getAlive();
     * Expected:
     *      return SUCCESS
     *      () = true
     */	
	
	@Test
	public void TestZombieGetAlive() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(true, testItem.getAlive());
	}
	
	
    /**
     * Purpose: test Zombie.SetMoving() function
     * Input: SetMoving(false);
     * Expected:
     *      return SUCCESS
     *      (false) = false
     */
	@Test
	public void TestZombieSetMoving() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setMoving(false);
		assertEquals(false, testItem.getAlive());
	}
	
    /**
     * Purpose: test Zombie.getSlowInt() function
     * Input: getSlowInt();
     * Expected:
     *      return SUCCESS
     *      () = 0 
     */
	@Test
	public void TestZombieGetSlowInt() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(0, testItem.getSlowInt());
	}
    /**
     * Purpose: test Zombie.setSlowInt() function
     * Input: setSlowInt(1000);
     * Expected:
     *      return SUCCESS
     *      (1000) = 1000
     */
	
	@Test
	public void TestZombieSetSlowInt() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setSlowInt(1000);
		assertEquals(1000, testItem.getSlowInt());
	}
	
    /**
     * Purpose: test Zombie.getYposition() function
     * Input: getYposition();
     * Expected:
     *      return SUCCESS
     *      () = 109
     */
	@Test
	public void TestZombieGetYposition() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		int expectedValue = testItem.getMyLane() * 120 + 109;
		assertEquals(expectedValue, testItem.getYPosition());
	}
	
    /**
     * Purpose: test Zombie.setYPosition() function
     * Input: setYPosition(229);
     * Expected:
     *      return SUCCESS
     *      (229) = 229
     */
	
	@Test
	public void TestZombieSetYposition() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		int expectedValue = 1 * 120 + 109;
		testItem.setYPosition(expectedValue);
		assertEquals(expectedValue, testItem.getYPosition());
	}

    /**
     * Purpose: test Zombie.Slow() function
     * Input: advance   (Xposition = 1000, SlowInt = 1000) (Xposition = 999, SlowInt = 999) (Xposition = 0, SlowInt = 0)
     * Expected:
     * 		(Xposition = 1000, SlowInt = 1000) => Xposition = 999, SlowInt = 998
     * 		(Xposition = 999, SlowInt = 999) => Xposition = 999, SlowINt = 998
     *      (Xposition = 0, SlowInt = 0) => Xposition = 0, SlowINt = 0
     * 
     */
	@Test
	public void TestZombieGetImage() {
		Image NormalZombieImage = NormalZombie.getImage();
		assertNotNull(NormalZombieImage);
	}

	
	@Test
	public void TestZombieAdvance() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		int X = testItem.getXPosition();
		int Y = testItem.getYPosition();
		Plant testPlant = new Peashooter(X, Y);
		
		gamePanel.getColliders()[8].setPlant(testPlant);
		
		for(int i=0; i<1000; i++) {
			testItem.advance();
		}
		assertTrue(0>testPlant.getHealth());
		
		
		testItem.setXPosition(500);
		testPlant = new Peashooter(X, Y);
		gamePanel.getColliders()[8].setPlant(testPlant);
		for(int i=0; i<1000; i++) {
			testItem.advance();
		}
		assertEquals(200, testPlant.getHealth());
		assertFalse(testItem.getAlive());
		assertEquals(0, testItem.getXPosition());	
	}
	
    /**
     * Purpose: test Zombie.Slow() function
     * Input: advance   (Xposition = 1000, SlowInt = 1000) (Xposition = 999, SlowInt = 999) (Xposition = 0, SlowInt = 0)
     * Expected:
     * 		(Xposition = 1000, SlowInt = 1000) => Xposition = 999, SlowInt = 998
     * 		(Xposition = 999, SlowInt = 999) => Xposition = 999, SlowINt = 998
     *      (Xposition = 0, SlowInt = 0) => Xposition = 0, SlowINt = 0
     * 
     */
	
	@Test
	public void TestZombieSlow() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.slow();
		
		int expectedXposition = 999;
		int expectedSlowInt = 999;
		testItem.advance();
		assertEquals(expectedXposition, testItem.getXPosition());
		assertEquals(expectedSlowInt, testItem.getSlowInt());
		
		
		expectedXposition = 999;
		expectedSlowInt = 998;
		testItem.advance();
		assertEquals(expectedXposition, testItem.getXPosition());
		assertEquals(expectedSlowInt, testItem.getSlowInt());
		
		testItem.setXPosition(0);
		testItem.setSlowInt(1);
		expectedXposition = 0;
		expectedSlowInt = 0;
		testItem.advance();
		assertEquals(expectedSlowInt, testItem.getSlowInt());
		assertEquals(expectedXposition, testItem.getXPosition());
		
		testItem.setXPosition(0);
		testItem.setSlowInt(2);
		expectedXposition = 0;
		expectedSlowInt = 1;
		testItem.advance();
		assertEquals(expectedSlowInt, testItem.getSlowInt());
		assertEquals(expectedXposition, testItem.getXPosition());
	}


	
}
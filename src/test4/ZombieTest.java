package test4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	
	@Test
	public void TestZombieFactory() {
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
	}
	/*
	@Test
	public void TestZombieAttackPlant() {
		Plant testPlant;
		testPlant = new Sunflower();
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		
		testPlant = new Peashooter();
		
		
		testPlant = new FreezePeashooter();
		
		
	}
	*/
	
	@Test
	public void TestZombieGetHealth() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(1000 ,testItem.getHealth());
	}
	
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
	
	@Test
	public void TestZombieGetSpeed() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(1, testItem.getSpeed());
	}
	
	@Test
	public void TestZombieSetSpeed() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setSpeed(2);
		assertEquals(2, testItem.getSpeed());
	}
	
	@Test
	public void TestZombieGetXposition() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(1000, testItem.getXPosition());
	}
	
	@Test
	public void TestZombieSetXposition() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setXPosition(0);
		assertEquals(0, testItem.getXPosition());
	}
	
	@Test
	public void TestZombieGetMyLane() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(0, testItem.getMyLane());
	}
	
	@Test
	public void TestZombieSetMyLane() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setMyLane(4);
		assertEquals(4, testItem.getMyLane());
	}
	
	@Test
	public void TestZombieGetAlive() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(true, testItem.getAlive());
	}
	
	@Test
	public void TestZombieSetMoving() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setMoving(false);
		assertEquals(false, testItem.getAlive());
	}
	
	@Test
	public void TestZombieGetSlowInt() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		assertEquals(0, testItem.getSlowInt());
	}
	
	@Test
	public void TestZombieSetSlowInt() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		testItem.setSlowInt(1000);
		assertEquals(1000, testItem.getSlowInt());
	}
	
	@Test
	public void TestZombieGetYposition() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		int expectedValue = testItem.getMyLane() * 120 + 109;
		assertEquals(expectedValue, testItem.getYPosition());
	}
	
	@Test
	public void TestZombieSetYposition() {
		testItem = Zombie.getZombie("zombie.model.NormalZombie", 0);
		int expectedValue = 1 * 120 + 109;
		testItem.setYPosition(expectedValue);
		assertEquals(expectedValue, testItem.getYPosition());
	}

}
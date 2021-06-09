package Test2;

import Game.view.GamePanel;
import static org.junit.Assert.*;

import Lane.model.Lane;
import org.junit.*;
import plant.model.FreezePeashooter;
import plant.model.Peashooter;
import plant.model.Plant;
import plant.model.Sunflower;
import plant.strategy.PlantShootingStrategy;
import plant.strategy.ShootFreezePea;
import plant.strategy.ShootNormalPea;
import sun.producer.SunFlowerSunProducer;
import zombie.model.NormalZombie;
import zombie.model.Zombie;

public class PlantTest {
    private static Plant plantTestComponent;
    private static GamePanel gamePanelTestComponent;
    private static Lane laneTestComponent;
    private static final int PlantHealth = 200;
    private static final int Peashooter_Price = 100;
    private static final int FreezePeashooter_Price = 175;
    private static PlantShootingStrategy plantShootingStrategyTestComponent;

    @BeforeClass
    public static void setUpBeforeClass() {
        gamePanelTestComponent = GamePanel.getInstance();
        laneTestComponent = Lane.getInstance();
    }

    @Before
    public void setUpBefore() {

    }

    @After
    public void tearDown() {
        gamePanelTestComponent = null;
        plantTestComponent = null;
        laneTestComponent = null;
        plantShootingStrategyTestComponent = null;
    }

    @AfterClass
    public static void tearDownAfterClass() {
        gamePanelTestComponent = null;
        plantTestComponent = null;
        laneTestComponent = null;
        plantShootingStrategyTestComponent = null;
    }

    /**
     * Purpose: test sunflower constructor
     * Input: execute sun(int x, int y):
     *        X = 100 , Y = 10
     * Expected:
     *      return SUCCESS
     *      (plantTestComponent.getX() == X && plantTestComponent.getY() == Y) == True
     */

    @Test
    public void propertiesAreSetOnSunflowerConstructor() {
        int X = 100;
        int Y = 10;
        plantTestComponent = new Sunflower(X, Y);
        assertEquals(plantTestComponent.getX(),X);
        assertEquals(plantTestComponent.getY(),Y);
    }

    /**
     * Purpose: test whether sun constructor create sun at given position or not
     * Input: execute sun(int x, int y):
     *        X = 100 , Y = 10
     * Expected:
     *      return SUCCESS
     *      (sunProducer.getX() == X && sunProducer.getY() == Y) == True
     */
    @Test
    public void createSunFromSunflowerTest() {
        int X = 100;
        int Y = 10;
        plantTestComponent = new Sunflower(X, Y);
        SunFlowerSunProducer p = (SunFlowerSunProducer) new Sunflower(X, Y).getSunProducer();
        assertEquals(plantTestComponent.getX(),p.getXPosition());
        assertEquals(plantTestComponent.getY(),p.getYPosition());
    }


    /**
     * Purpose: test Peashooter constructor -> check right properties in Peashooter class
     * Input: execute Peashooter(int x, int y):
     *        X = 100 , Y = 10
     * Expected:
     *      return SUCCESS
     *      assertEquals(X, plantTestComponent.getX());
     *      assertEquals(Y, plantTestComponent.getY());
     *      assertEquals(PlantHealth, plantTestComponent.getHealth());
     *      assertEquals(Peashooter_Price, plantTestComponent.getPeashooter_Price());
     *      assertSame(plantTestComponent.getLane(), laneTestComponent);
     *      -> Lane is singleton so that laneTestComponents and plantTestComponent.getLane() must be the same
     *      -> if it is not, singleton failed
     */
    @Test
    public void propertiesAreSetOnPeaShooterConstructor() {
        int X = 100;
        int Y = 10;

        plantTestComponent = new Peashooter(X, Y);
        assertEquals(X, plantTestComponent.getX());
        assertEquals(Y, plantTestComponent.getY());
        assertEquals(PlantHealth, plantTestComponent.getHealth());
        assertEquals(Peashooter_Price, plantTestComponent.getPrice());
        assertSame(plantTestComponent.getLane(), laneTestComponent);
    }

    /**
     * Purpose: test FreezePeashooter constructor -> check right properties in Peashooter class
     * Input: execute FreezePeashooter(int x, int y):
     *        X = 100 , Y = 10
     * Expected:
     *      return SUCCESS
     *      assertEquals(X, plantTestComponent.getX());
     *      assertEquals(Y, plantTestComponent.getY());
     *      assertEquals(PlantHealth, plantTestComponent.getHealth());
     *      assertEquals(FreezePeashooter_Price, plantTestComponent.getPeashooter_Price());
     *      assertSame(plantTestComponent.getLane(), laneTestComponent);
     *      -> Lane is singleton so that laneTestComponents and plantTestComponent.getLane() must be the same
     *      -> if it is not, singleton failed
     */
    @Test
    public void propertiesAreSetOnFreezePeaShooterConstructor() {
        int X = 100;
        int Y = 10;

        plantTestComponent = new FreezePeashooter(X, Y);
        assertEquals(X, plantTestComponent.getX());
        assertEquals(Y, plantTestComponent.getY());
        assertEquals(PlantHealth, plantTestComponent.getHealth());
        assertEquals(FreezePeashooter_Price, plantTestComponent.getPrice());
        assertSame(plantTestComponent.getLane(), laneTestComponent);
    }


    /**
     * Purpose: test Peashooter strategy pattern -> check right method in Peashooter class
     * Input: execute Peashooter(int x, int y):
     *        X = 100 , Y = 10
     * Expected:
     *      return SUCCESS
     *      assertEquals(plantTestComponent.getPlantShootingStrategy().getClass().getName(), new ShootNormalPea().getClass().getName());
     *      assertNotEquals(plantTestComponent.getPlantShootingStrategy().getClass().getName(), new ShootFreezePea().getClass().getName());
     *      Part of Peashooter
     *      -> this.setPlantShootingStrategy(new ShootNormalPea());
     *      check if strategy pattern which is ShootNormalPea() apply on peashooter class
     */
    @Test
    public void checkIfStrategyPatternApplyOnPeashooterClass() {
        int X = 100;
        int Y = 10;
        plantTestComponent = new Peashooter(X, Y);
        assertEquals(plantTestComponent.getPlantShootingStrategy().getClass().getName(), new ShootNormalPea().getClass().getName());
        assertNotEquals(plantTestComponent.getPlantShootingStrategy().getClass().getName(), new ShootFreezePea().getClass().getName());
    }


    /**
     * Purpose: test FreezePeashooter strategy pattern -> check right method in FreezePeashooter class
     * Input: execute FreezePeashooter(int x, int y):
     *        X = 100 , Y = 4, laneTestComponent
     * Expected:
     *      return SUCCESS
     *      assertNotEquals(plantTestComponent.getPlantShootingStrategy().getClass().getName(), new ShootNormalPea().getClass().getName());
     *      assertEquals(plantTestComponent.getPlantShootingStrategy().getClass().getName(), new ShootFreezePea().getClass().getName());
     *      Part of FreezePeashooter
     *      -> this.setPlantShootingStrategy(new ShootFreezePea());
     *      check if strategy pattern which is ShootFreezePea() apply on freezePeashooter class
     */
    @Test
    public void checkIfStrategyPatternApplyOnFreezePeashooterClass() {
        int X = 100;
        int Y = 10;
        plantTestComponent = new FreezePeashooter(X, Y);
        assertNotEquals(plantTestComponent.getPlantShootingStrategy().getClass().getName(), new ShootNormalPea().getClass().getName());
        assertEquals(plantTestComponent.getPlantShootingStrategy().getClass().getName(), new ShootFreezePea().getClass().getName());
    }

    @Test
    public void shootNormalPeaTest() {
        int X = 1;
        int Y = 0;
        Zombie zombie = new NormalZombie(0);
        laneTestComponent.getLaneZombies().get(0).add(zombie);
        for (int i = 0; i< 100; i++) {
            gamePanelTestComponent.advance();
        }

        plantTestComponent = new Peashooter(X, Y);
        plantTestComponent.shoot();
        plantShootingStrategyTestComponent = new ShootNormalPea();
        plantShootingStrategyTestComponent.shoot(X, Y, laneTestComponent);
        laneTestComponent.getLaneZombies().get(0).add(zombie);
        for (int i = 0; i< 100; i++) {
            gamePanelTestComponent.advance();
        }
        //assertTrue(gamePanelTestComponent.getLaneZombies().get(0).isEmpty());
    }

}

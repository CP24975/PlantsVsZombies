package test1;

import Game.view.GameWindow;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import plant.creator.PlantFactory;
import plant.model.FreezePeashooter;
import plant.model.Peashooter;
import plant.model.Plant;
import plant.model.Sunflower;

public class PlantFactoryTest {
    PlantFactory plantFactory;
    @Before
    public void setUp(){
        plantFactory = PlantFactory.getInstance();
    }
    @After
    public void tearDown(){
        plantFactory = null;
    }

    /**
     * Purpose : Test PlantFactory Create right plant By plant Type
     * Input : getPlant(plantType) , return right Plant type Instance
     * Expected :
     *  sunflower instance of Sunflower : true
     *  peashooter instance of Peashooter : true
     *  freezePeashooter instance of FreezePeashooter : true
     */
    @Test
    public void getPlantTest(){
        Plant sunflower = plantFactory.getPlant(GameWindow.PlantType.Sunflower,0,0);
        Plant peashooter = plantFactory.getPlant(GameWindow.PlantType.Peashooter,0,0);
        Plant freezePeashooter = plantFactory.getPlant(GameWindow.PlantType.FreezePeashooter,0,0);

        Assert.assertTrue(sunflower instanceof Sunflower);
        Assert.assertTrue(peashooter instanceof Peashooter);
        Assert.assertTrue(freezePeashooter instanceof FreezePeashooter);
    }

    /**
     * Purpose : Test PlantFactory Create plant in right Position
     * Input : getPlant(plantType) , return Plant in right Position
     * Expected :
     *  plant.getX() : 0
     *  plant.getY() : 0
     */
    @Test
    public void getPlantPositionTest(){
        Plant plant = plantFactory.getPlant(GameWindow.PlantType.Sunflower,0,0);

        Assert.assertEquals(plant.getX(), 0);
        Assert.assertEquals(plant.getY(), 0);
    }
}

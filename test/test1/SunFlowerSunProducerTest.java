package test1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.producer.SunFlowerSunProducer;
import sun.producer.SunProducer;
import sun.view.SunView;

public class SunFlowerSunProducerTest {
    SunProducer sunProducer;
    @Before
    public void setUP(){sunProducer = new SunFlowerSunProducer(0,0);}
    @After
    public void tearDown(){sunProducer = null;}

    /**
     * Purpose : Test SunFlowerSunProducer Produce SunView in Right Position
     * Input : createSunView(), SunView in xPosition 60, yPosition [110, 130]
     * Expected :
     *  sunView.getYPosition() in range [110,130]
     *  60 = sunView.getXPosition
     */
    @Test
    public void SunFlowerSunProducerCreateSunViewTest(){
        SunView sunView = sunProducer.createSunView();
        Assert.assertTrue(sunView.getY() >= 110 && sunView.getY() <= 130);
        Assert.assertEquals(60, sunView.getX());
    }
}

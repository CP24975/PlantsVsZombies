package test1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.model.Sun;

public class SunTest {
    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){}

    /**
     * Purpose : Create Sun
     * Input : Sun(), Create Sun(10,10,10)
     * Expected :
     *  10 = sun.getXPosition()
     *  10 = sun.getYPosition()
     *  10 = sun.getEndYPosition()
     */
    @Test
    public void SunCreateTest(){
        Sun sun = new Sun(10,10,10);
        Assert.assertEquals(10,sun.getXPosition());
        Assert.assertEquals(10,sun.getYPosition());
        Assert.assertEquals(10,sun.getEndYPosition());
    }

    /**
     * Purpose : Move Sun
     * Input : Sun.move(), sun's yPosition + 4
     * Expected :
     *  14 = sun.getYPosition()
     */
    @Test
    public void SunMoveTest(){
        Sun sun = new Sun(10,10,20);
        sun.move();
        Assert.assertEquals(14, sun.getYPosition());
    }

    /**
     * Purpose : Reduce Sun Destruct Time
     * Input : Sun.reduceDestructTime(), sun's destructTime - 1
     * Expected :
     *  199 = sun.getDestructTime()
     */
    @Test
    public void SunReduceDestructTimeTest(){
        Sun sun = new Sun(10,10,10);
        sun.reduceDestructTime();
        Assert.assertEquals(199,sun.getDestructTime());
    }

    /**
     * Purpose :  Sun Action Test When yPosition < endYPosition
     * Input : Sun(10,10,20), move sun yPosition
     * Expected :
     *  14 = sun.getYPosition()
     */
    @Test
    public void SunActionMoveTest(){
        Sun sun = new Sun(10,10,20);
        sun.action();
        Assert.assertEquals(14,sun.getYPosition());
    }

    /**
     * Purpose :  Sun Action Test When yPosition >= endYPosition
     * Input : Sun(10,10,10), reduce sun destruct time
     * Expected :
     *  10 = sun.getYPosition()
     *  199 = sun.getDestructTime()
     */
    @Test
    public void SunActionReduceDestructTimeTest(){
        Sun sun = new Sun(10,10,10);
        sun.action();
        Assert.assertEquals(10,sun.getYPosition());
        Assert.assertEquals(199, sun.getDestructTime());
    }
}

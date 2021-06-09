package Test5;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.model.Sun;


public class SunTest {
  private Sun testItem;
  
  @Before
  public void setUp() throws Exception {
  }
  
  @After
  public void tearDown() throws Exception{
    testItem = null;
  }
  
  /**
   * Purpose: test sun.Move() function
   * Input: execute sun.Move():
   *        X = 100 , Y = 0 , endY = 200;
   * Expected:
   *      return SUCCESS
   *      (getXPosition() == X) == True
   *      (getYPosition() == Y+4) == True
   */
  
  @Test
  public void testSunMoveOne() {
    int startX = 100;
    int startY = 0;
    int endY = 200;
    
    testItem = new Sun(startX, startY, endY);
    testItem.move();
    
    assertEquals(testItem.getXPosition(),startX);
    assertEquals(testItem.getYPosition(), startY+4);
  }
  /**
   * Purpose: test sun.Move() function
   * Input: execute sun.reduceDestructTime():
   *        X = 100 , Y = 200 , endY = 0;
   * Expected:
   *      return SUCCESS
   *      (getXPosition() == X) == True
   *      (beforeDestructTime == AfterDestructTime + 1) == Ture
   */
  @Test
  public void testSunMoveTwo() {
    int startX = 100;
    int startY = 200;
    int endY = 0;
    testItem = new Sun(startX, startY, endY);
    int beforeDestructTime = testItem.getDestructTime();
    
    testItem.reduceDestructTime();
    int AfterDestructTime = testItem.getDestructTime();
    assertEquals(beforeDestructTime, AfterDestructTime + 1);
  }
}

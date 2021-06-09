package Test5;

import static org.junit.Assert.*;
import java.util.Random;
import javax.swing.Timer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Game.view.GamePanel;
import sun.model.Sun;
import sun.presenter.SunPresenter;
import sun.view.SunView;

public class SunPresenterTest {
  private Sun sun;
  private Random rnd;
  private SunView sunView;
  private SunPresenter testItem;
  private GamePanel gamepanel;
  @Before
  public void setUp() throws Exception {
    gamepanel = GamePanel.getInstance();
    rnd = new Random();
    sun = new Sun(rnd.nextInt(800) + 100, 0, rnd.nextInt(300) + 200);
    sunView = new SunView(sun.getXPosition(), sun.getYPosition());
  }

  @After
  public void tearDown() throws Exception {
    sun = null;
    rnd = null;
  }

  /**
   * Purpose: test mouseRelasedTest() function
   * Input: execute SunPresenter.mouseRelased() 
   * Expected:
   *      return -1 (Index == 0 is removed Entity
   *      (afterIndex, -1) == True
   *      (beforeIndex, -1) == True
   */
  
  @Test
  public void mouseRelasedTestOne() {
    testItem = new SunPresenter(sunView, sun);
    sunView.init(testItem);
    int beforeIndex = gamepanel.getIndexOf(sunView);
    testItem.mouseReleased();
    int afterIndex = gamepanel.getIndexOf(sunView);
    
    //System.out.println(beforeIndex);
    //System.out.println(afterIndex);
    assertEquals(afterIndex, -1);
    assertEquals(beforeIndex, 2);
  }
 
  /**
   * Purpose: test sunPresenter.start() function
   * Input: execute SunPresenter.start() 
   * Expected:
   *      return True     
   */
  
  @Test
  public void startTest() {
    testItem = new SunPresenter(sunView, sun);
    Timer timer = testItem.getTimer();
    boolean beforeRunning= timer.isRunning();  
    testItem.start();
    boolean afterRunning= timer.isRunning();
    
    assertFalse(beforeRunning);
    assertTrue(afterRunning);
  }
  
  /**
   * Purpose: test sunPresenter.move() function
   * Input: execute SunPresenter.move() 
   * Expected:
   *      return True
   *      (Y coordinate of moved sun instance -4 == Y coordinate of not moved sun) == True     
   */
  
  @Test
  public void moveTestOne() {
    int Xposition = sun.getXPosition();
    int Yposition = sun.getYPosition();
    testItem = new SunPresenter(sunView, sun);
    Timer timer = testItem.getTimer();
    timer.stop();
    testItem.move();
    assertEquals(sun.getYPosition()-4, Yposition);
  }
  
  /**
   * Purpose: test sunPresenter.move() function
   * Input: execute SunPresenter.move()
   *        sun.DestructTime = 1
   *        sun.endYPostion = -200
   *        sun.YPostion = 0
   *         
   * Expected:
   *      return True
   *      
   *      After the destruction time, the sun instance should be deleted on Game Window.
   *      
   *      After first move(),(testItem.getSun().getDestructTime() == 0)  is True
   *      After first move(),(gamepanel.getIndexOf(sunView) == -1)  is True
   *      
   *      After second move(),(testItem.getSun().getDestructTime() == -1)  is True
   *      
   */
  
  @Test
  public void moveTestTwo() {
    sun = new Sun(0,0,-200);
    sun.setDestructTime(1);
    
    testItem = new SunPresenter(sunView, sun);
    Timer timer = testItem.getTimer();
    testItem.move();
    int index = gamepanel.getIndexOf(sunView);
    
    assertEquals(testItem.getSun().getDestructTime(),0);
    
    testItem.move();
    
    assertEquals(testItem.getSun().getDestructTime(),-1);
    assertEquals(index , -1);
    }
}

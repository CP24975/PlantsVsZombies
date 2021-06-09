package test.Test5;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Game.view.GamePanel;
import Game.view.GameWindow;
import Game.view.GameWindow.PlantType;
import Game.view.MenuFrame;

public class GameWindowTest {
  private GameWindow gameWindow;
  private GamePanel gamePanel;
  @Before
  public void setUp() throws Exception {
    gamePanel = GamePanel.getInstance();
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void AttachCardTestOne() {
    gameWindow = new GameWindow();
    gameWindow.getLayeredPane().removeAll();
    int numOfCard = gameWindow.getLayeredPane().getComponentCount();
    
    assertEquals(numOfCard,0);
    
    gameWindow.AttachCard(gamePanel, 110, "../../images/cards/card_sunflower.png", PlantType.Sunflower);
    numOfCard = gameWindow.getLayeredPane().getComponentCount();
    assertEquals(numOfCard,1);
    
  }

  @Test(expected = NullPointerException.class)
  public void AttachCardTestTwo() {
    gameWindow = new GameWindow();
    gameWindow.getLayeredPane().removeAll();
    int numOfCard = gameWindow.getLayeredPane().getComponentCount();
    
    assertEquals(numOfCard,0);
    
    gameWindow.AttachCard(gamePanel, 110, "asdasdsad", PlantType.Sunflower);
  }
  
  @Test
  public void AttachCardTestThree() {
    gameWindow = new GameWindow();
    gameWindow.getLayeredPane().removeAll();
    int numOfCard = gameWindow.getLayeredPane().getComponentCount();
    
    assertEquals(numOfCard,0);
    gameWindow.AttachCard(gamePanel, 110, "../../images/cards/card_sunflower.png", PlantType.None);
    numOfCard = gameWindow.getLayeredPane().getComponentCount();
    
    assertEquals(numOfCard,1);
    
  }
  
  @Test
  public void AttachCardTestfour() {
    gameWindow = new GameWindow();
    gameWindow.getLayeredPane().removeAll();
    int numOfCard = gameWindow.getLayeredPane().getComponentCount();
    
    assertEquals(numOfCard,0);
    
    gameWindow.AttachCard(gamePanel, 110000, "../../images/cards/card_sunflower.png", PlantType.Sunflower);
    numOfCard = gameWindow.getLayeredPane().getComponentCount();
    
    assertEquals(numOfCard,1);
    
  }
  @Test(expected=NullPointerException.class)
  public void startTestOne() {
    gameWindow = new GameWindow();
    gameWindow.gameStart();
  }
  @Test
  public void startTestTwo() {
    gameWindow = new GameWindow();
    gameWindow.setMenuFrame(new MenuFrame());
    gameWindow.gameStart();
    assertFalse(gameWindow.getMenuFrame().isActive());
  }
}

package Game.view;

import plantCard.model.PlantCard;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Armin on 6/25/2016.
 */
public class GameWindow extends JFrame {
  public enum PlantType {
    None, Sunflower, Peashooter, FreezePeashooter
  }
  
  private GamePanel gamePanel;
  static public GameWindow gameWindow;
  private static MenuFrame menuFrame;
  PlantType activePlantingBrush = PlantType.None;

  public MenuFrame getMenuFrame() {
    return menuFrame;
  }
  
  public static void setMenuFrame(MenuFrame MENUFRAME) {
    menuFrame = MENUFRAME;
  }
  
  public GameWindow() {
    setSize(1012, 785);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(null);
    setResizable(false);
    setVisible(true);
    initPlantCard();
  }


  public void AttachCard(GamePanel gamepanel, int xCoordinate, String imagePath, PlantType plantType) {

    PlantCard newCard =
        new PlantCard(new ImageIcon(this.getClass().getResource(imagePath)).getImage());
    newCard.setLocation(xCoordinate, 8);
    newCard.setAction((ActionEvent e) -> {
      gamepanel.setActivePlantingBrush(plantType);
    });
    getLayeredPane().add(newCard, new Integer(3));
    
  }

  
  private void initPlantCard() {
    gamePanel = GamePanel.getInstance();
    gamePanel.setLocation(0, 0);
    getLayeredPane().add(gamePanel, new Integer(0));
    AttachCard(gamePanel, 110, "../../images/cards/card_sunflower.png", PlantType.Sunflower);
    AttachCard(gamePanel, 175, "../../images/cards/card_peashooter.png", PlantType.Peashooter);
    AttachCard(gamePanel, 240, "../../images/cards/card_freezepeashooter.png", PlantType.FreezePeashooter);
  }


  
  public static void gameStart() {
    menuFrame.disposeMenuFrame();
    gameWindow = new GameWindow();
    
}

public static void main(String[] args) {
  setMenuFrame(new MenuFrame());
  }

  
}


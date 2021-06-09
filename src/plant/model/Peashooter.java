package plant.model;

import Lane.model.Lane;
import plant.strategy.ShootNormalPea;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Armin on 6/25/2016.
 */
public class Peashooter extends Plant {

    private static final int Peashooter_Price = 100;
    public Image peashooterImage;
    public Timer shootTimer;
    private Lane lanes;
    

    @Override
    protected void setImage() {
      plantImage = new ImageIcon(this.getClass().getResource("../../images/plants/peashooter.gif")).getImage();
    }
    
    /**
     * gamepanel占쎈퓠占쎄퐣 lane占쎌뱽 �겫�뜄�쑎占쎌궎占쎈뮉 野껉퍔�뵠 占쎈툡占쎈빒,
     * lane class占쎈퓠占쎄퐣 占쎈뼓疫뀐옙占쎈꽑占쎌몵嚥∽옙 getInstance�몴占� 占쎈립占쎈뼄.
     */
    public Peashooter(int x, int y) {
        super(x, y);
        peashooterImage = new ImageIcon(this.getClass().getResource("../../images/plants/peashooter.gif")).getImage();
        lanes = lanes.getInstance();
        this.setPlantShootingStrategy(new ShootNormalPea());
        shoot();
    }
    

    @Override
    public int getPrice() {
        return Peashooter_Price;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(peashooterImage, 60 + getX() * 100,129 + 120 * getY(),null);
    }

    @Override
    public void stop() {
        shootTimer.stop();
    }

    @Override
    public void shoot() {
        super.shoot();
    }
}

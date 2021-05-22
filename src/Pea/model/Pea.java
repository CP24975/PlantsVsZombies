package Pea.model;

import lane.model.Lane;
import window.GamePanel;
import zombie.model.Zombie;

import java.awt.*;

/**
 * Created by Armin on 6/25/2016.
 */
public class Pea {

    private int posX;
    protected GamePanel gp;
    private Lane lanes;
    private int myLane;

    public Pea(int lane, int startX) {
        myLane = lane;
        posX = startX;
        lanes = lanes.getInstance();
    }

    public void advance() {
        Rectangle pRect = new Rectangle(posX, 130 + myLane * 120, 28, 28);
        for (int i = 0; i < lanes.getLaneZombies().get(myLane).size(); i++) {
            Zombie z = lanes.getLaneZombies().get(myLane).get(i);
            Rectangle zRect = new Rectangle(z.getPosX(), 109 + myLane * 120, 400, 120);
            if (pRect.intersects(zRect)) {
                z.setHealth(z.getHealth() - 300);
                boolean exit = false;
                if (z.getHealth() < 0) {
                    System.out.println("ZOMBIE DIED");

                    lanes.getLaneZombies().get(myLane).remove(i);
                    GamePanel.setProgress(10);
                    exit = true;
                }
                lanes.getLaneZombies().get(myLane).remove(this);
                if (exit) break;
            }
        }
        /*if(posX > 2000){
            gp.lanePeas.get(myLane).remove(this);
        }*/
        posX += 15;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getMyLane() {
        return myLane;
    }

    public void setMyLane(int myLane) {
        this.myLane = myLane;
    }
}

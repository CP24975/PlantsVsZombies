package plant.strategy;

import Lane.model.Lane;
import Pea.model.FreezePea;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShootFreezePea implements PlantShootingStrategy {
    private Timer shootTimer;
    public static final int SHOOTING_DELAY = 2000;
    public static final int START_BASE_POSITION = 103;
    public static final int START_XPOSITION = 103;

    @Override
    public void shoot(int x, int y, Lane lanes) {
        shootFreezePea(x, y, lanes);
    }

    private void shootFreezePea(int xPosition, int yPosition, Lane lanes) {
        lanes = lanes.getInstance();
        Lane finalLanes = lanes;
        shootTimer = new Timer(SHOOTING_DELAY, (ActionEvent e) -> {
            //System.out.println("SHOOT");
            boolean isZombieOnIt = finalLanes.getLaneZombies().get(yPosition).size() > 0;
            if (isZombieOnIt) {
                finalLanes.getLanePeas().get(yPosition).add(new FreezePea(yPosition, START_BASE_POSITION + xPosition * START_XPOSITION));
            }
        });
        shootTimer.start();
    }

}

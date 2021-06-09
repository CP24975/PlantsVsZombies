package plant.strategy;

import Lane.model.Lane;
import Pea.model.NormalPea;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShootNormalPea implements PlantShootingStrategy {
    private Timer shootTimer;
    public static final int SHOOTING_DELAY = 2000;
    public static final int START_BASE_POSITION = 103;
    public static final int START_XPOSITION = 103;


    @Override
    public void shoot(int x, int y, Lane lanes) {
        shootNormalPea(x, y, lanes);
    }

    private void shootNormalPea(int xPosition, int yPosition, Lane lanes) {
        lanes = lanes.getInstance();
        Lane finalLanes = lanes;
        shootTimer = new Timer(SHOOTING_DELAY, (ActionEvent e) -> {


            boolean isZombieOnIt = finalLanes.getLaneZombies().get(yPosition).size() > 0;
            if (isZombieOnIt) {
                System.out.println("SHOOT");
                finalLanes.getLanePeas().get(yPosition).add(new NormalPea(yPosition, START_BASE_POSITION + xPosition * START_XPOSITION));
            }
        });
        shootTimer.start();
    }
}

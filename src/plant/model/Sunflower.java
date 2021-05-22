package plant.model;

import sun.model.Sun;
import window.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Armin on 6/28/2016.
 */
public class Sunflower extends Plant {

    private Timer sunProduceTimer;

    public Sunflower(int x, int y) {
        super(x, y);
        sunProduceTimer = new Timer(15000, (ActionEvent e) -> {
            Sun sta = new Sun(60 + x * 100, 110 + y * 120, 130 + y * 120);
            getGp().getActiveSuns().add(sta);
            getGp().add(sta, new Integer(1));
        });
        sunProduceTimer.start();
    }

}

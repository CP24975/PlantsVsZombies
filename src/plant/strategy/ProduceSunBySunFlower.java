package plant.strategy;

import sun.producer.SunFlowerSunProducer;
import sun.producer.SunProducer;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class ProduceSunBySunFlower {
    private SunProducer sunProducer;
    private Timer sunProducerTimer;
    public static final int PRODUCE_DELAY = 15000;

    private void ProduceSunBySunFlower(int x, int y) {
        sunProducer = new SunFlowerSunProducer(x,y);
        sunProducerTimer = new Timer(PRODUCE_DELAY,(ActionEvent e)->{sunProducer.createSunView();});
        sunProducerTimer.start();
    }

    public void produceSun(int x, int y) {
        ProduceSunBySunFlower(x,y);
    }
}

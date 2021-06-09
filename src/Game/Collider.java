package Game;

import plant.model.Plant;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Armin on 6/25/2016.
 */
public class Collider extends JPanel implements MouseListener {
    //rename actionListner variable
    //private ActionListener al;
    private ActionListener actionListener;
    public Collider() {
        //setBorder(new LineBorder(Color.RED));
        setOpaque(false);
        addMouseListener(this);
        //setBackground(Color.green);
        setSize(100, 120);
    }

    private Plant assignedPlant;
    public Plant getPlant() {
        return assignedPlant;
    }
    /**
     * 占쎌뜚占쎌삋 �굜遺얜굡
     * public Plant assignedPlant;
     *
     * 獄쏅뗀占쏙옙 �굜遺얜굡
     * private Plant assignedPlant;
     *
     * private 占쎌몵嚥∽옙 �⑥쥙�뒄�⑨옙 getter setter 筌띾슢諭억옙堉� 餓μ꼷鍮� 占쎈립占쎈뼄.
     * �눧紐꾩젫占쎌젎 : collider.assignedPlant�몴占� 占쎈쾺占쎈뮉 占쎄깻占쎌삋占쎈뮞(GamePanel.java, Zombie.java)占쎈퓠占쎄퐣 getter嚥∽옙 獄쏅떽�벊 餓μ꼷鍮� 占쎈립占쎈뼄.
     */
    //turn public into private and make getter and setter

    public void setPlant(Plant p) {
        assignedPlant = p;
    }

    public void removePlant() {
        assignedPlant.stop();
        assignedPlant = null;
    }

    public boolean isInsideCollider(int x) {
        boolean moreThanMin = x > getLocation().x;
        boolean lessThanMax = x < getLocation().x + 100;
        return moreThanMin && lessThanMax;
    }

    public void setAction(ActionListener actionListener) {
        this.actionListener = actionListener;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (actionListener != null) {
            actionListener.actionPerformed(new ActionEvent(this, ActionEvent.RESERVED_ID_MAX + 1, ""));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

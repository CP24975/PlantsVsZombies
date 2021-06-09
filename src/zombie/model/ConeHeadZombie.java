package zombie.model;

import javax.swing.ImageIcon;


/**
 * Created by Armin on 6/29/2016.
 */
public class ConeHeadZombie extends MeleeZombie {

    public ConeHeadZombie(int lane) {
        super(lane);
        setImage(new ImageIcon(this.getClass().getResource("../../images/zombies/zombie2.png")).getImage());
        setHealth(1800);
    }

}

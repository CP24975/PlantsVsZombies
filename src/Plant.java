/**
 * Created by Armin on 6/25/2016.
 */
public abstract class Plant {

    private int health = 200;

    /**
     * 변수 이름 구체적으로
     * x -> xPosition, y-> yPosition
     * gp -> gamePanel
     */
    private int xPosition;
    private int yPosition;

    private GamePanel gp;


    public Plant(GamePanel parent, int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        gp = parent;
    }

    public void stop() {
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public GamePanel getGp() {
        return gp;
    }

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }
}

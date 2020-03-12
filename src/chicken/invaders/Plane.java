
package chicken.invaders;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Plane extends Item {
    private int score;
    private GamePane pane;
    private boolean winner;
    private boolean alive;

    public Plane(double x, double y, GamePane pane) {
        super("file:images/plane.png", x, y);
        this.score = 0;
        this.pane = pane;
        winner = false;
        alive = true;
    }
    
    public void moveLeft() {
       setX(getX() - 10);
    }
    
    public void moveRight() {
        setX(getX() + 10);
    }
    
    public void moveUp() {
        setY(getY() - 10);
    }
    
    public void moveDown() {
        setY(getY() + 10);
    }
    
    public int getScore() {
        return this.score;
    }
    
    public void shot() {
        new Shot(this.getX()+25, this.getY()-25, this.pane);
    }
    
    public void updateScore() {
        score++;
    }
    
    public void die() {
        if (alive && !winner) {
            shape.setVisible(false);
            alive = false;
            ImageView img = new ImageView("file:images/game-over.png");
            pane.getChildren().add(img);
         }
    }
    
    public void win() {
         winner = true;
         ImageView img = new ImageView("file:images/win.png");
         pane.getChildren().add(img);
     }
    
}

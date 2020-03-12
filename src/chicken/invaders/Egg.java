
package chicken.invaders;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Egg extends Item {
    
    public Egg(double x, double y, Pane pane, Plane plane) {
        super("file:images/egg.png", x, y);
        shape.setX(x);
        shape.setY(y);
        pane.getChildren().add(1,this.shape);
        // start move
        Timeline animation = new Timeline();
        KeyFrame frame = new KeyFrame(Duration.millis(80), e -> {
           this.shape.setY(this.shape.getY() + 10);
           if (this.shape.getY() > pane.getHeight())
               animation.stop();
           if (this.shape.getY() >= plane.getShape().getY() - 15 &&
                   this.shape.getY() <= plane.getShape().getY() + 80 &&
                   this.shape.getX() >= plane.getShape().getX() &&
                   this.shape.getX() <= plane.getShape().getX() + 75) {
               animation.stop();
               plane.die();
               this.shape.setVisible(false);
           }
        });
        animation.getKeyFrames().add(frame);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    
}

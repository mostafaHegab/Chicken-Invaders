
package chicken.invaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Shot extends Item {
    
    Chicken currentChicken;
    public Shot(double x, double y, GamePane pane) {
        super("file:images/shot.png", x, y);
        pane.getChildren().add(1,this.getShape());
        
        int currentColumn = pane.getColumn(x);
        
        // start move
        Timeline animation = new Timeline();
        KeyFrame frame = new KeyFrame(Duration.millis(30), e -> {
            if (currentColumn != -1) {
                Chicken temp = pane.getLastChicken(currentColumn);
                currentChicken = temp;
            }
           this.getShape().setY(this.getShape().getY() - 10);
           if (currentChicken != null) {
               if (this.getShape().getY() <= currentChicken.getShape().getY()) {
                    currentChicken.die();
                    this.getShape().setVisible(false);
                    animation.stop();
                    pane.updateScore();
                }
           }
        });
        animation.getKeyFrames().add(frame);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
}

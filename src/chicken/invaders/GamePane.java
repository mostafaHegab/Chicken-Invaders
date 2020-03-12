
package chicken.invaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GamePane extends Pane {
    
    Chicken[][] chickens;
    Plane plane;
    
    GamePane() {
        // show plane
        this.plane = new Plane(505,550,this);
        this.getChildren().add(this.plane.getShape());
        
        //show chickens
        chickens = new Chicken[10][4];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                int x = 1200/10*i+80;
                int y = j*85+20;
                chickens[i][j] = new Chicken(x,y,this,plane);
                this.getChildren().add(chickens[i][j].getShape());
            }
        }
        
        // start egg
        Timeline animation = new Timeline();
        KeyFrame frame = new KeyFrame(Duration.millis(500), e2 -> {
            int c1i = (int)Math.round(Math.random()*8);
            int c1j = (int)Math.round(Math.random()*2);
            if (chickens[c1i][c1j].isAlive())
                chickens[c1i][c1j].egg();
        });
        animation.getKeyFrames().addAll(frame);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
    }
    
    public Plane getPlane() {
        return this.plane;
    }
    
    public int getColumn(double x) {
       for (int i = 0; i < chickens.length; i++) {
           double cx = chickens[i][0].getShape().getX();
           if ( x == cx-10
                || x == cx
                || (x > cx
                    && x < cx + 100)) {
               return i;
           }
       }
       return -1;
    }
    
    public Chicken getLastChicken(int c) {
        for (int i = chickens[c].length-1; i > -1; i--) {
            if (this.chickens[c][i].isAlive()){
                return this.chickens[c][i];
            }
        }
        return null;
    }
    
    public void updateScore() {
        this.plane.updateScore();
    }
    
    public void gameOver() {
        System.out.println("Game Over");
    }
}


package chicken.invaders;

import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_CASPIAN;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ChickenInvaders extends Application {
    
    public void start(Stage stage) {
        
        
        // intro
        Pane introPane = new Pane();
        Scene scene = new Scene(introPane);
        ImageView bg = new ImageView("file:images/space.png");
        // title
        ImageView title = new ImageView("file:images/title.png");
        title.setX(308);
        title.setY(50);
        // exit button
        ImageView exit = new ImageView("file:images/exit.png");
        exit.setX(50);
        exit.setY(630);
        exit.setCursor(Cursor.HAND);
        // start button
        ImageView start = new ImageView("file:images/start.png");
        start.setX(1010);
        start.setY(630);
        start.setCursor(Cursor.HAND);
        introPane.getChildren().addAll(bg,title,exit,start);
        
        // start game
        start.setOnMouseReleased(ie -> {
            GamePane view = new GamePane();
            view.getChildren().add(0,bg);
            // event
            scene.setOnKeyPressed(e -> {
                switch(e.getCode()) {
                    case LEFT: {
                        if (view.getPlane().getX() > 0)
                            view.getPlane().moveLeft();
                        break;
                    }
                    case RIGHT: {
                        if (view.getPlane().getX() < view.getWidth() - 100)
                            view.getPlane().moveRight();
                        break;
                    }
                    case UP: {
                        if (view.getPlane().getY() > 450) {
                            view.getPlane().moveUp();
                        }
                        break;
                    }
                    case DOWN: {
                        if (view.getPlane().getY() < view.getHeight()-110) {
                            view.getPlane().moveDown();
                        }
                        break;
                    }
                    case SPACE: {
                        view.getPlane().shot();
                        break;
                    }
                }
            });
            
            scene.setRoot(view);
        });
        
        // exit game
        exit.setOnMouseReleased(e -> {
            stage.close();
        });
        
        stage.setScene(scene);
        stage.setTitle("Chicken Invaders");
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
    
}

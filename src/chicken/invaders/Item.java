
package chicken.invaders;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Item {
    protected ImageView shape;

    public Item(String path, double x, double y) {
        this.shape = new ImageView(path);
        this.shape.setX(x);
        this.shape.setY(y);
    }

    public ImageView getShape() {
        return shape;
    }

    public void setShape(ImageView shape) {
        this.shape = shape;
    }
    
    public double getX() {
        return shape.getX();
    }

    public double getY() {
        return shape.getY();
    }
    
    public void setX(double x) {
        shape.setX(x);
    }
    
    public void setY(double y) {
        shape.setY(y);
    }
    
}

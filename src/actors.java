import bagel.util.Point;
import bagel.*;

/* class actors have two subclasses: tree and gatherer */
public abstract class actors {
    private final String actorType;
    protected Point point;
    protected Image image;

    public actors(String actorType, Point point, Image image){
        this.actorType = actorType;
        this.point = point;
        this.image = image;
    }

    public abstract void update();
}

import bagel.util.Point;
import bagel.*;
public class tree extends actors {

    public tree(String actorType, Point point, Image image){
        super(actorType, point, image);
    }

    @Override
    public void update(){
        image.draw(point.x,point.y);
    }

}

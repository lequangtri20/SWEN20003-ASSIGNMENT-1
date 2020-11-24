import bagel.Image;
import bagel.util.Point;
import java.util.Random;

public class gatherer extends actors{

    private double x;   /* to store point.x and update it, since point.x is private*/
    private double y;   /* to store point.y and update it, since point.y is private*/
    private int totalTick = 0;  /* count number of ticks to reset gatherer with new random direction */
    private double speed = 64;
    private int direction; /* toggle allowing x to be changed based on new random direction */
    static final int cycle = 5;     /* number of ticks before reset to new direction */

    public gatherer(String actorType, Point point, Image image) {
        super(actorType, point, image);
        this.x = point.x;
        this.y = point.y;
        image.draw(x,y);
        this.resetGatherer();
    }

    @Override
    public void update(){
        if ((ShadowLife.diff >= 500) && (ShadowLife.diff < 550)){
            totalTick += 1;
            if ((direction == 0) || (direction == 2))
                x += speed;

            else
                y += speed;
        }
        if (totalTick == cycle){
            /*  reset speed and direction */
            this.resetGatherer();
            totalTick = 0;
        }
        image.draw(x,y);
    }

    public void resetGatherer(){
        Random random = new Random();
        direction = random.nextInt(4); /* 4 direction represented by 0 - 3: 0-North; 1-East; 2-South; 3-West */

        if ((direction == 0) ||(direction == 1)) {
            speed = 64;
        }

        else{
            speed = -64;
        }
    }


}

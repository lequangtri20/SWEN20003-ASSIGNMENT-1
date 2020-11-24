import bagel.*;

public class ShadowLife extends AbstractGame{

    private final Image backgroundImg;
    private static final String  filePath = "res/worlds/test.csv";
    private static final CSV csv = new CSV(filePath);  /* Read the csv file and return a list of actors */
    private final actors[] allActors = csv.readCSV();  /* Store all actors read from test.csv in this list */

    private static long start; /* Served as the starting point to count the time */
    private static long end; /* Served as the end point of every tick, got updated in high frequency in update method */
    public static long diff; /* Store the difference between "start" and "end", used in gatherer class to reset ticks */


    public ShadowLife(){
        super(1024, 768, "ShadowLife");
        backgroundImg = new Image("res/images/background.png");
        start = System.currentTimeMillis(); /* Time starts to count when background image is drawn */

    }

    @Override
    public void update(Input input){
        backgroundImg.drawFromTopLeft(0,0);
        if (input.wasPressed(Keys.ESCAPE)) {
            Window.close();
        }

        end = System.currentTimeMillis();   /* end milestone is checked every time update is called */
        diff = end - start;

        if ((diff >= 500) && (diff < 550)){  /* when a tick is achieved, assign start = end to evaluate new tick */
            start = end;
        }
        for (actors act: allActors){
            act.update();
        }
    }

    public static void main(String[] args){
        ShadowLife test = new ShadowLife();
        test.run();
    }
}

import bagel.util.Point;
import bagel.*;
import java.io.FileReader;
import java.io.BufferedReader;


public class CSV {
    private final String filePath;
    private String oneLineInput = ""; /* store all lines from test.csv to this variable, each line separated by "-" */
    private int numActor = 0;   /* store number of actors from test.csv */

    public CSV(String filePath) {
        this.filePath = filePath;
    }

    public actors[] readCSV() {
        /* Read test.csv and load content to oneLineInput, each line separated by "-" */
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String text;
            while ((text = br.readLine()) != null) {
                oneLineInput += text;
                oneLineInput += "-";    /* adding separator "-" to split each line later */
                numActor += 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* store all actors read from test.csv */
        actors[] allActors = new actors[numActor];

        /* Split each line in oneLineInput by delimiter "-" to linesArray */
        /* store discrete lines of actors */
        String[] linesArray = oneLineInput.split("-");

        /* For each element in linesArray, identify its actor type and coordinates */
        for (int i = 0; i < numActor; i++) {
            /* store each field for each line */
            String[] columns = linesArray[i].split(",");
            String actorType = columns[0];
            Point point = new Point(Double.parseDouble(columns[1]), Double.parseDouble(columns[2]));
            if (actorType.equals("Tree")){
                allActors[i] = new tree(actorType, point, new Image("res/images/tree.png"));
            }
            else{
                allActors[i] = new gatherer(actorType, point, new Image("res/images/gatherer.png"));
            }
        }
        return allActors;
    }

}
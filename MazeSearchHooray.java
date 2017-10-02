import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Marie Curie on 02/10/2017.
 */
public class MazeSearchHooray {
    public static void main(String[] args){

        final String FILENAME = null;
        loadFile(FILENAME);
    }
    public static ArrayList<String> loadFile(String FILENAME) {
        ArrayList<String> mazeLine = new ArrayList<String>();
        BufferedReader br = null;
        FileReader fr = null;

        try {

            try {
                br = new BufferedReader(new FileReader(FILENAME));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String sCurrentLine;

            try {
                for (int i = 0; (sCurrentLine = br.readLine()) != null; i++) {
                    mazeLine.add(i, sCurrentLine);
                }


            } catch (IOException e1) {
                e1.printStackTrace();
            }

        } finally {
            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
        return mazeLine;
    }



}

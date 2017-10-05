package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Marie Curie, Michael Ervin, Brandon Jay on 02/10/2017.
 */
public class MazeSearchHooray {
    public static void main(String[] args){

        final String FILENAME = "in/tinyMaze.lay.txt";
        Maze maze = new Maze();

        //loads maze.txt into object maze
        maze.setMaze(loadFile(FILENAME));
        //maze.print();
        //maze.getStartEndPoints();
    }

    //loads maze.txt
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

    //Object maze
    private static class Maze{
        private ArrayList<String> maze;
        private int sx,sy, ex,ey; // starting point and end point coordinates
        private ClosedList cList;//closed list
        private OpenList oList; // open list
        private ParentList pList; // parentlist

        //initialization
        private Maze(){
            maze = new ArrayList<String>();
            cList = new ClosedList();
            oList = new OpenList();
            pList = new ParentList();
            sx = sy = ex = ey = 0;
        }

        private void setMaze(ArrayList<String> maze){
            this.maze = maze;
        }

        //fill in the x,y values of starting point and end point
        private void getStartEndPoints(){
            //TODO Change code when there are multiple end points
            for(int i = 0 ; i < maze.size(); i++){
                if(maze.get(i).contains("P")){
                    sx = i;
                    sy = maze.get(i).indexOf("P");
                }else if(maze.get(i).contains(".")){
                    ex = i;
                    ey = maze.get(i).indexOf(".");
                }
            }
            System.out.println("starting: "+sx+" "+sy);
            System.out.println("starting: "+ex+" "+ey);
        }

        private void solve(){
            /*
                FLOW
                1 Start from starting point
                2 Add to Openlist all surrounding points (check if valid point, check if repeated point)
                3 Add parent to parent list for new point(check if repeated point)
                3 Generate G, H and F for all
                4 Find smallest F add to Closed list
                5 check if end point, if not kay back to 2
             */
            getStartEndPoints();

        }

        //prints maze
        private void print(){
            for(int i = 0 ; i < maze.size(); i++){
                System.out.println(maze.get(i));
            }
        }

        private int getHeuristic() {
            return 1;
        }
        private int getFn() {
            return 1;
        }
        private int getG(){
            return 1;
        }

        private boolean checker(){
            return true;
        }
    }

    private static class OpenList{
        /* Array Row:
        0- Square x
        1- Square y
        2- G
        3- Heuristic (H)
        4- F(n)
         */
        ArrayList<ArrayList<Integer>> oList;

        //constructor
        private OpenList() {
            oList = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < 5;i++ )
                oList.add(new ArrayList<Integer>());
        }
    }

    private static class ClosedList {
        /* Parent Row:
            0- Current x
            1- Current y
        */
        ArrayList<ArrayList<Integer>> pList;

        private ClosedList() {
            pList = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < 2; i++)//G, H, and F(N)
                pList.add(new ArrayList<Integer>());
        }
    }

    private static class ParentList {
        /* Parent Row:
            0- Daughter x
            1- Daughter y
            2- Parent x
            3- Parent y
        */
        ArrayList<ArrayList<Integer>> pList;

        private ParentList() {
            pList = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < 4; i++)//G, H, and F(N)
                pList.add(new ArrayList<Integer>());
        }
    }
}

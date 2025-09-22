package Practice.e_MaizeProblems;

import java.util.ArrayList;

public class c_MazeWithObstacles {

    public static int countOfPathsWithObstacles(boolean[][] matrixx, int row, int column){
        int rows = matrixx.length-1;
        int columns = matrixx[0].length-1;

        if(row==rows & column==columns){
            return 1;
        }
        int count=0;
        if(row<rows && matrixx[row][column]){
            count = count + countOfPathsWithObstacles(matrixx, row+1, column);
        }
        if(column<columns && matrixx[row][column]){
            count = count + countOfPathsWithObstacles(matrixx, row, column+1);
        }

        if((row<rows && column<columns) && matrixx[row][column]){
            count = count + countOfPathsWithObstacles(matrixx, row+1, column+1);
        }

        return count;

    }

    public static ArrayList<String> pathsWithObstacles(boolean[][] matrixx, String processed, int row, int column){
        int rows = matrixx.length-1;
        int columns = matrixx[0].length-1;

        if(row==rows & column==columns){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            System.out.println(list);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        if(row<rows && matrixx[row][column]){
            list.addAll(pathsWithObstacles(matrixx, processed+"B", row+1, column));
        }

        if(column<columns && matrixx[row][column]){
            list.addAll(pathsWithObstacles(matrixx,processed+"R", row, column+1));
        }

        if((row<rows && column<columns) && matrixx[row][column]){
            list.addAll(pathsWithObstacles(matrixx, processed+"D", row+1, column+1));
        }
        return list;

    }

    public static void main(String[] args) {
        boolean[][] booleanMatrix = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        System.out.println(countOfPathsWithObstacles(booleanMatrix,0,0));
        System.out.println(pathsWithObstacles(booleanMatrix,"",0,0));
    }
}

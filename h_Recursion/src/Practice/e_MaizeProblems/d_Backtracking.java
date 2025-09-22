package Practice.e_MaizeProblems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class d_Backtracking {

    public static void backtrackingPaths(boolean[][] matrixx, String processed, int row, int col, int[][] path, int step){
        //Base condition
        if(row==matrixx.length-1 && col==matrixx[0].length-1){
            path[row][col] = step;
            for(int[] p: path){
                System.out.println(Arrays.toString(p));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }

        if(!matrixx[row][col]){
            return;
        }
        matrixx[row][col] = false;
        path[row][col] = step;
        // Bottom
        if(row<matrixx.length-1){
            backtrackingPaths(matrixx,processed+"D",row+1,col,path,step+1);
        }
        //Up
        if(row>0){
            backtrackingPaths(matrixx,processed+"U", row-1, col,path,step+1);
        }
        //Right
        if(col<matrixx[0].length-1){
            backtrackingPaths(matrixx,processed+"R",row,col+1,path,step+1);
        }
        //Left
        if(col>0){
            backtrackingPaths(matrixx,processed+"L", row, col-1,path,step+1);
        }

        matrixx[row][col]=true;
        path[row][col] = 0;


    }

    public static ArrayList<String> backtracking(boolean[][] matrixx, String processed, int row, int col){
        if(row == matrixx.length-1 && col==matrixx.length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();

        // If the input Matrix has any obstacle
        if(!matrixx[row][col]){
            //return empty list
            return list;
        }
        matrixx[row][col]=false;

        //Down movement
        if(row<matrixx.length-1){
            list.addAll(backtracking(matrixx,processed+"D", row+1, col));
        }
        // Right movement
        if(col<matrixx[0].length-1){
            list.addAll(backtracking(matrixx,processed+"R", row, col+1));
        }
        //Up movement
        if(row>0){
            list.addAll(backtracking(matrixx,processed+"U",row-1,col));
        }
        //Left movement
        if(col>0){
            list.addAll(backtracking(matrixx,processed+"L",row,col-1));
        }

        matrixx[row][col]=true;
        return list;
    }

    public static void main(String[] args) {
        boolean[][] matrixx = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        //System.out.println(backtracking(matrixx, "", 0,0));

        int[][] path = new int[matrixx.length][matrixx[0].length];
        backtrackingPaths(matrixx,"",0,0,path,1);
    }
}

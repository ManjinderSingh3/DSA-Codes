package Practice.e_MaizeProblems;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class a_NumberOfPaths {

    public static int numberOfPaths(String processed, int row, int column){
        if(row==1 && column==1){
            return 1;
        }
        int count = 0;

        if(row>0){
            count = count+numberOfPaths("D", row-1, column);
        }
        if(column>0){
            count = count + numberOfPaths("R", row, column-1);
        }
        return count;
    }

    public static ArrayList<String> printPaths(String processed, int row, int column){
        if(row==1 && column==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            System.out.println(processed);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(row>0){
            list.addAll(printPaths(processed+"D", row-1, column));
        }
        if(column>0){
            list.addAll(printPaths(processed+"R", row, column-1));
        }
        return list;

    }

    public static void main(String[] args) {
        //System.out.println(a_NumberOfPaths.numberOfPaths("",3,3));
        System.out.println(printPaths("",3,3));
    }
}

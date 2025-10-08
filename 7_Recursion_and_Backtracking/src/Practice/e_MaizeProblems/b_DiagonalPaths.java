package Practice.e_MaizeProblems;

import java.util.ArrayList;

public class b_DiagonalPaths {

    public static int diagonalPathsCount(int row, int column){
        if(row==1 || column==1){
            return  1;
        }
        int bottom = diagonalPathsCount(row-1,column);
        int right = diagonalPathsCount(row, column-1);
        int diagonal = diagonalPathsCount(row-1, column-1);
        return bottom+right+diagonal;
    }

    public static ArrayList<String> diagonalPaths(String processed, int row, int column){
        if(row==1 && column==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            System.out.println(list);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(row>1){
            list.addAll(diagonalPaths(processed+"B",row-1,column));
        }
        if(column>1){
            list.addAll(diagonalPaths(processed+"R",row,column-1));
        }
        if(row>1 && column>1){
            list.addAll(diagonalPaths(processed+"D",row-1,column-1));
        }
        System.out.println(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(diagonalPathsCount(3,3));
        System.out.println(diagonalPaths("",3,3));
    }
}

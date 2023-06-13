package main.java.IList.CArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiDimensionalArrayList {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        //Multidimensional Arraylist
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        // Originally => [null, null, null]
        //Initialize the array List .
        for(int i=0;i<3;i++){
            list.add(new ArrayList<>());
        }
        // After Initialization => [ [list1], [list2], [list3] ]


        //Adding Elements
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                list.get(i).add(in.nextInt());
            }
        }
        System.out.println(list);

    }
}

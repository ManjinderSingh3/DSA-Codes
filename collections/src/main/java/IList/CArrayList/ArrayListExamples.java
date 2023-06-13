package main.java.IList.CArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExamples {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(21);
//        list.add(311);
//        list.add(4111);
//        list.add(51111);
//
//        System.out.println(list);
//        list.set(0,11);
//        System.out.println(list);
//
//        list.remove(4);
//        System.out.println(list);

        //Take Input
        for (int i=0;i<5;i++){
            list.add(in.nextInt());
        }
        System.out.println(list);
    }
}

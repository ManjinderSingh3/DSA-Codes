package main.java.IList.CLinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertBeginning(1);
        ll.insertBeginning(0);
        ll.insertBeginning(1);
        ll.insertBeginning(1);
        //ll.insertBeginning(1);
        //ll.insertBeginning(1);

        //System.out.println(ll.getDecimalValue());

//        ll.insertBeginning(3);
//        ll.insertBeginning(7);
//        ll.insertBeginning(45);
//        ll.insertBeginning(79);
//        System.out.println("**** a. Front Insertion ****");
//        ll.displayList();
//        System.out.println("**** b. Back Insertion ****");
//        ll.insertBack(26);
//        ll.displayList();
        System.out.println("**** c. Insert anywhere ****");
        ll.insertAnywhere(700,2);
        ll.displayList();
//        System.out.println("**** d. Delete beginning ****");
//        System.out.println("Deleted element: "+ll.deleteBeginning());
//        ll.displayList();
//        System.out.println("**** e. Delete Last ****");
//        System.out.println("Deleted element: "+ll.deleteLast());
//        ll.displayList();
//        System.out.println("**** f. Delete Anywhere ****");
//        System.out.println("Deleted element: "+ll.deleteAnywhere(2));
//        ll.displayList();
    }


}

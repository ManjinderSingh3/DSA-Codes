package main.java.IList.CLinkedList;

public class DoublyLLMain {
    public static void main(String[] args) {
        DoublyLinkedList dLL = new DoublyLinkedList();
        //dLL.insertBeginning(12);
        //dLL.insertBeginning(27);
        dLL.insertBeginning(3);
        //dLL.insertBeginning(102);
        dLL.displayList();
        dLL.reverseList();
        System.out.println("-----Inserting from back-------");
        //dLL.insertLast(500);
        dLL.displayList();
        dLL.reverseList();
        System.out.println("------Inserting anywhere-----");
        dLL.insertAnywhere(55,3);
        dLL.displayList();
    }
}

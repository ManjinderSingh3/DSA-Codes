package main.java.IList.CLinkedList;

public class CircularLLMain {
    public static void main(String[] args) {
        CircularLinkedList cLL = new CircularLinkedList();
        cLL.insertBeginning(4);
        cLL.insertBeginning(35);
        cLL.insertBeginning(79);
        cLL.insertBeginning(21);
        cLL.display();
        cLL.deleteBeginning();
        cLL.display();
        cLL.deleteAnywhere(79);
        cLL.display();
    }
}

package main.java.IList.CLinkedList;

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void insertBeginning(int val){
        Node node = new Node(val);
        if(head==null){
            head=node;
            tail=node;
            return;
        }
        node.next=head;
        tail.next=node;
        tail=node;
    }

    public void display(){
        Node temp = head;
        if(head!=null){
            if(head.next==null) {
                System.out.print(temp.val + "->");
            }
            else{
                do {
                    System.out.print(temp.val + "->");
                    temp = temp.next;
                } while (temp != head);
            }
        }
        System.out.println("HEAD");
    }

    public void deleteBeginning(){
        if(head!=null && tail!=head){
            head = head.next;
            tail.next = head;
        }
        else if(tail == head){
            head=null;
            tail=null;
        }
        else {
            System.out.println("No node to delete");
        }
    }

    public void deleteAnywhere(int val){
        Node node = head;
        do{
            if(node.next.val==val){
                node.next = node.next.next;
            }
            node=node.next;
        }while(node!=head);
    }

    private class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }

    }

}

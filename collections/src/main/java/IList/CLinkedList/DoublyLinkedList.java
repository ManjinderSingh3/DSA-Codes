package main.java.IList.CLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public void insertBeginning(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head!=null){
            head.prev=node;
        }
        head = node;
        if(tail == null){
            tail = head;
        }
    }

    public void reverseList(){
        while(tail!=null){
            System.out.print(tail.val+"->");
            tail = tail.prev;
        }
        System.out.println("START");
    }

    public void insertLast(int val){
        Node node = new Node(val);
        node.next = null;
        Node last = head;
        while(last.next!=null){
            last=last.next;
        }
        if(last==null){
            node.prev = null;
            head = node;
        }
        last.next = node;
        node.prev = last;
        last = node;
        tail=last;
    }



    public void insertAnywhere(int val, int afterThisNode){
        Node newNode = new Node(val);
        Node prevNode = findNode(afterThisNode);
        if(prevNode==null){
            System.out.println("Does not exist");
            return ;
        }
//        newNode.next=prevNode.next;
//        prevNode.next = newNode;
//        newNode.prev = prevNode;
//        if(newNode.next!=null){
//            newNode.next.prev=newNode;
//        }
        if(prevNode.next != null){
            newNode.next = prevNode.next;
            prevNode.next.prev = newNode;
        }
        newNode.prev = prevNode;
        prevNode.next = newNode;
    }

    public void displayList(){
        Node temp = head;
        Node last = null;
        while(temp != null){
            System.out.print(temp.val+"->");
            last=temp;
            temp = temp.next;
        }
        System.out.println("END");
    }

    private Node findNode(int val){
        Node temp = head;
        while(temp!=null){
            if(temp.val==val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    private class Node{
        private int val;
        private Node next;
        private Node prev;
        public Node(int  val){
            this.val=val;
        }
        public Node(int val, Node next){
            this.val=val;
            this.next=next;
        }
    }

}

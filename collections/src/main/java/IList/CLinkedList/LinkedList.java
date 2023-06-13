package main.java.IList.CLinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    public LinkedList(){
        this.size=0;
    }

    public int getDecimalValue(){
        Node temp = head;
        StringBuilder sb =new StringBuilder();
        while(temp!=null){
            sb.append(temp.val);
            temp = temp.next;
        }
        String input = sb.toString();
        System.out.println("Test1:"+input.charAt(2));
        //System.out.println("Test:"+  Integer.parseInt(sb.toString()));
        //System.out.println("String builder: "+ sb.toString());
        //return Integer.parseInt(sb.toString(),2);

        return Character.getNumericValue(input.charAt(2));
    }

    // Time Complexity = O(1) or constant
    public void insertBeginning(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }

    // Time Complexity = O(1) or constant
    public void insertAnywhere(int val, int index){
        if(index==0){
            insertBeginning(val);
            return;
        }
        if(index==size){
            insertBack(val);
            return;
        }
        Node temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next=node;
        size+=1;
    }

    // Time Complexity = O(1) or constant
    public void insertBack(int val){
        if(tail==null){
            insertBeginning(val);
            return ;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size+=1;
    }

    // Time Complexity = O(1) or constant
    public int deleteBeginning(){
        int value = head.val;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size-=1;
        return value;
    }

    // Time Complexity = O(n)
    public int deleteLast(){
        int value = tail.val;
        Node temp=head;
        for (int i=1;i<size-1;i++){
            temp = temp.next;
        }
        temp.next=null;
        size-=1;
        return value;
    }

    // Time Complexity = O(n)
    public int deleteAnywhere(int index){
        Node temp = head;
        for(int i=1;i<index;i++){
            temp = temp.next;
        }
        int val = temp.next.val;
        temp.next= temp.next.next;
        size-=1;
        return val;
    }

    public void displayList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val + "->");
            temp=temp.next;
        }
        System.out.println("END");
    }

    private class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val=val;
        }
        public Node(int val, Node next){
            this.val=val;
            this.next=next;
        }
    }
}

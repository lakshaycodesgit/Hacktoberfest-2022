public class LL {

    private Node head;
    private Node tail;
    private int size;
    public int count;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
        }
        Node node = new Node(val);
        tail.next = node;
        tail=node;
        size++;
    }
    public void insertrecvoid(int index , int value){
        insertrecvoid(index,value,head);
    }
    private void insertrecvoid(int index , int value , Node current){
        if(index == 1){
            Node temp = new Node(value);
            temp.next = current.next;
            current.next = temp;
            size++;
            return;
        }
        insertrecvoid(--index,value,current.next);
    }
    public void insertrec(int index , int value){
        head = insertrec(index, value,head);
    }
    private Node insertrec(int index, int value, Node node){
        if(index == 0){
            Node temp = new Node(value,node);
            size++;
            return temp;
        }
        node.next = insertrec(--index,value,node.next);
        return node;
    }

    public void insert(int val , int index){
        if(index==0) {
            insertFirst(val);
            return;
        }
        if(index==size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for(int i = 1 ; i < index ; i++){
            temp=temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;

        size++;
    }
    public int deleteFirst(){
        int val = head.value;
        head=head.next;
        if(head==null){
            tail = null;
        }
        size--;
        return val;
    }
    public int deleteLast(){
        if(size <=1){
            return deleteFirst();
        }
        Node temp = get(size-2);
        int val = tail.value;
        tail=temp;
        temp.next=null;

        return val;
    }
    public int delete(int index){
        if(index==0){
            deleteFirst();
        }
        if(index == size-1) {
            return deleteLast();
        }
        Node prev = get(index-1);
        int del = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return del;
    }

    public Node find(int value){
        count = 0;
        Node temp = head;
        while(temp!=null){
            if(temp.value==value){
                return temp;
            }
            temp=temp.next;
            count++;
        }
        return null;
    }
    public Node get(int index){
        Node node = head;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }
    public void display(){
         Node temp = head;
         while(temp!=null) {
             System.out.print(temp.value + " -> ");
             temp = temp.next;
         }
        System.out.println("End");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}

public class LinkedList {
    private Node head;
    private Node tail;
    private int length = 0;

    class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length ++;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        length ++;
    }

    public int removeLast(){
        if(length == 0) return 0;
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length --;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp.value;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("Complete list printed");
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        newNode.next = head;
        head = newNode;
        length ++;
    }

    public Node removeFirst() {
        if(length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length --;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;

        Node temp = head;
        for(int i=0; i<index; i++){
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value){
        if(index < 0 || index > length) return false;

        Node temp = get(index);
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;
        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length ++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= length) return null;

        if(index == 0){
            removeFirst();
        }

        if(index == length -1){
            removeLast();
        }

        Node temp = get(index-1);
        Node temp1 = temp.next;
        temp.next = temp1.next;
        temp1.next = null;
        length --;
        if(length == 0){
            tail = null;
        }
        return temp1;
    }

    public void reverse(){
        Node temp = head;
        Node before = null;
        Node after = head.next;

        head = tail;
        tail = temp;

        while(temp != head){
            temp.next = before;
            before = temp;
            temp = after;
            after = after.next;
        }
    }
}

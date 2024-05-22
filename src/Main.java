public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList(4);

        myList.append(6);
        myList.append(10);
        myList.printList();

        myList.prepend(2);
        myList.printList();
        myList.removeFirst();
        System.out.println(myList.get(2).value);
    }
}
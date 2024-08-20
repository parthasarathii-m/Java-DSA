public class SinglyLinkedList {
    private ListNode head; // Holds the SinglyLinked List for us

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Display all the existing nodes in the SinglyLinkedList
    public void display() {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
        System.out.println();
    }

    // Returns the length of the singlyLinkedList
    public int length() {
        int length = 0;
        ListNode currNode = head;
        while (currNode != null) {
            currNode = currNode.next;
            length++;
        }
        return length;
    }

    // Inserts a node at the start. i.e. Before head
    public void InsertHead(ListNode node) {
        node.next = head;
        head = node;
    }

    // Inserts a node at the end
    public void Insert(ListNode node) {
        ListNode currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = node;
    }

    // Inserts at a certain position
    public void InsertAt(ListNode node, int position) {
        int count = 1; //Assuming the first position as 1 not 0 like in arrays 
        ListNode currNode = head;
        while (count < position - 1) {
            count++;
            currNode = currNode.next;
        }
        ListNode temp = currNode.next;
        currNode.next = node;
        node.next = temp;
    }

    //Deletes a node at the start
    public void DeleteHead(){
        ListNode temp = head.next;
        head.next = null;
        head = temp;
    }

    //Deletes a node at the end
    public void DeleteEnd(){
        ListNode currNode = head;
        while(currNode.next.next!=null){
            currNode = currNode.next;
        }
        currNode.next = null;
    }

    //Deleting a node at a certain positionx
    public void DeleteAt(int position){
        ListNode currNode = head;
        int count = 1;
        while(count<position-1){
            currNode = currNode.next;
        }
        ListNode temp = currNode.next;
        currNode.next = temp.next;
        temp.next = null;
    }


    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(10);
        singlyLinkedList.Insert(new ListNode(30));
        
        singlyLinkedList.Insert(new ListNode(40));
        singlyLinkedList.InsertAt(new ListNode(20),2);

        singlyLinkedList.display();
        //singlyLinkedList.DeleteHead();
       // singlyLinkedList.DeleteEnd();
        singlyLinkedList.DeleteAt(2);
        singlyLinkedList.display();
        System.out.println(singlyLinkedList.length());
    }
}

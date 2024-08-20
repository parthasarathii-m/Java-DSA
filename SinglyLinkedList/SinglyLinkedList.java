import java.util.List;

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
    public void InsertStart(ListNode node) {
        node.next = head;
        head = node;
    }

    // Inserts a node at the end
    public void InsertLast(ListNode node) {
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

    

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new ListNode(10);
        singlyLinkedList.InsertLast(new ListNode(30));
        singlyLinkedList.InsertAt(new ListNode(20),2);
        singlyLinkedList.display();
        System.out.println(singlyLinkedList.length());
    }
}

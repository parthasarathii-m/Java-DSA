package SinglyLinkedList;

public class SinglyLinkedList {
    private ListNode head; // Holds the SinglyLinked List for us
    private int size = 0;

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
    public int Length() {
        return size;
    }

    // Inserts a node at the start. i.e. Before head
    public void InsertHead(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;

    }

    // Inserts a node at the end
    public void Insert(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = node;
        }
        size++;

    }

    // Inserts at a certain position
    public void InsertAt(ListNode node, int position) {
        if (position <= 0 || node == null) {
            return;
        }
        if (position == 1) {
            InsertHead(node);
            size++;
            return;
        }
        int count = 1; // Assuming the first position as 1 not 0 like in arrays
        ListNode currNode = head;
        while (count < position - 1) {
            count++;
            currNode = currNode.next;
        }
        ListNode temp = currNode.next;
        currNode.next = node;
        node.next = temp;
        size++;
    }

    // Deletes a node at the start
    public void DeleteHead() {
        if (head != null) {
            ListNode temp = head.next;
            head.next = null;
            head = temp;
            size--;
        }
    }

    // Deletes a node at the end
    public void DeleteEnd() {
        if (head != null) {
            ListNode currNode = head;
            while (currNode.next.next != null) {
                currNode = currNode.next;
            }
            currNode.next = null;
            size--;
        }

    }

    // Deleting a node at a certain position
    public void DeleteAt(int position) {

        if (head == null || position <= 0) {
            return;
        }
        if (position == 1) {
            DeleteHead();
            return;
        }
        ListNode currNode = head;
        int count = 1;
        while (count < position - 1) {
            currNode = currNode.next;
        }
        ListNode temp = currNode.next;
        currNode.next = temp.next;
        temp.next = null;
        size--;
    }

    public boolean Search(int searchKey) {
        ListNode currNode = head;
        while (currNode != null) {
            if (currNode.data == searchKey) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    public void Reverse() {
        ListNode currNode = head;
        ListNode prev = null;
        ListNode next = null;
        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        head = prev;
    }

    public int nthNodeFromEnd(int n) {
        int count = 0;
        ListNode mainPtr = head;
        ListNode refPtr = head;

        while (count < n) {
            count++;
            refPtr = refPtr.next;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr.data;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.InsertHead(new ListNode(10));
        singlyLinkedList.Insert(new ListNode(30));
        singlyLinkedList.InsertHead(new ListNode(0));
        singlyLinkedList.Insert(new ListNode(40));
        singlyLinkedList.InsertAt(new ListNode(20), 3);

        singlyLinkedList.display();
        // singlyLinkedList.DeleteHead();
        // singlyLinkedList.DeleteEnd();
        singlyLinkedList.DeleteAt(2);
        singlyLinkedList.display();
        System.out.println(singlyLinkedList.Length());
        System.out.println(singlyLinkedList.Search(20));

        singlyLinkedList.Reverse();
        singlyLinkedList.display();

        System.out.println(singlyLinkedList.nthNodeFromEnd(4));
    }
}

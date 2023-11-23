class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class QuickSortLinkedList {
    private Node head;
    private Node tail;

    public QuickSortLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void sort() {
        if (head != null) {
            head = quickSort(head);
        }
    }

    private Node quickSort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node pivot = node;
        Node smallerHead = null, smallerTail = null;
        Node largerHead = null, largerTail = null;
        Node current = node.next;

        while (current != null) {
            Node next = current.next;
            if (current.value <= pivot.value) {
                if (smallerHead == null) {
                    smallerHead = current;
                    smallerTail = current;
                } else {
                    smallerTail.next = current;
                    smallerTail = current;
                }
            } else {
                if (largerHead == null) {
                    largerHead = current;
                    largerTail = current;
                } else {
                    largerTail.next = current;
                    largerTail = current;
                }
            }
            current.next = null;
            current = next;
        }

        if (smallerTail != null) {
            smallerTail.next = null;
        }
        if (largerTail != null) {
            largerTail.next = null;
        }

        Node sortedSmaller = quickSort(smallerHead);
        Node sortedLarger = quickSort(largerHead);

        if (sortedSmaller == null) {
            pivot.next = sortedLarger;
            return pivot;
        }

        Node sortedSmallerTail = getTail(sortedSmaller);
        sortedSmallerTail.next = pivot;
        pivot.next = sortedLarger;

        return sortedSmaller;
    }

    private Node getTail(Node node) {
        if (node == null) {
            return null;
        }

        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSortLinkedList list = new QuickSortLinkedList();
        list.append(5);
        list.append(3);
        list.append(1);
        list.append(6);
        list.append(8);
        list.append(4);

        System.out.println("Original Linked List:");
        list.display();

        list.sort();

        System.out.println("Sorted Linked List:");
        list.display();
    }
}

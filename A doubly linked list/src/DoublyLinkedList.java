public class DoublyLinkedList {

    public Cell first;
    public Cell last;

    public class Cell {
        int head;        // Data
        Cell next;       // Next cell in the list
        Cell prev;       // Previous cell in the list

        Cell(int val, Cell nxt, Cell prv) {
            head = val;
            next = nxt;
            prev = prv;
        }
    }

    // Constructor to initialize an empty doubly linked list
    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    // Method to add an item as the first cell in the sequence
    public void add(int item) {
        Cell newCell = new Cell(item, first, null);
        if (first == null) {
            last = newCell; // If the list was empty, update last to the new cell
        } else {
            first.prev = newCell; // Update the previous reference of the current first cell
        }
        first = newCell;
    }

    // Method to return the length of the sequence
    public int length() {
        int count = 0;
        Cell current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Method to find if an item exists in the sequence
    public boolean find(int item) {
        Cell current = first;
        while (current != null) {
            if (current.head == item) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to remove an item if it exists in the sequence
    public void remove(int item) {
        Cell current = first;
        while (current != null) {
            if (current.head == item) {
                if (current.prev != null) {
                    current.prev.next = current.next; // Update the next reference of the previous cell
                } else {
                    first = current.next; // Update the first reference if we're removing the first cell
                }
                if (current.next != null) {
                    current.next.prev = current.prev; // Update the previous reference of the next cell
                } else {
                    last = current.prev; // Update the last reference if we're removing the last cell
                }
                return;
            }
            current = current.next;
        }
    }

    // Method to unlink a specific cell from the doubly linked list
    public void unlinkD(Cell cell) {
        if (cell == null) {
            return; // Nothing to unlink
        }
        if (cell.prev != null) {
            cell.prev.next = cell.next; // Update the next reference of the previous cell
        } else {
            first = cell.next; // Update the first reference if we're unlinking the first cell
        }
        if (cell.next != null) {
            cell.next.prev = cell.prev; // Update the previous reference of the next cell
        } else {
            last = cell.prev; // Update the last reference if we're unlinking the last cell
        }
    }

    // Method to insert a cell as the first cell in the list
    public void insertAsFirst(Cell cell) {
        if (cell == null) {
            return; // Nothing to insert
        }
        cell.next = first;
        cell.prev = null;
        if (first != null) {
            first.prev = cell;
        } else {
            last = cell; // Update the last reference if we're inserting into an empty list
        }
        first = cell;
    }

    // Method to display the elements of the doubly linked list
    public void display() {
        Cell current = first;
        while (current != null) {
            System.out.print(current.head + " <-> "); // Printing both next and previous references
            current = current.next;
        }
        System.out.println("null");
    }
}

/*     public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.display(); // Output: 4 <-> 3 <-> 2 <-> 1 <-> null

        list.remove(3);
        list.display(); // Output: 4 <-> 2 <-> 1 <-> null

        list.unlink(list.first.next);
        list.display(); // Output: 4 <-> 1 <-> null

        DoublyLinkedList anotherList = new DoublyLinkedList();
        anotherList.add(5);
        anotherList.add(6);

        list.insertAsFirst(anotherList.first);
        list.display(); // Output: 6 <-> 4 <-> 1 <-> null
    }
}*/

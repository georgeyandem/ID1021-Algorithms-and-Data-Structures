public class LinkedList {

    private Cell first;

    private class Cell {    //box
        int head;           // data
        Cell tail;          // next - tail

        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }

    // Constructor to initialize an empty linked list
    public LinkedList() {
        first = null;
    }

    // Method to add an item as the first cell in the sequence
    public void add(int item) {
        Cell newCell = new Cell(item, first);
        first = newCell;
    }

    // Method to return the length of the sequence
    public int length() {
        int count = 0;
        Cell current = first;
        while (current != null)
        {
            count++;
            current = current.tail;
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
            current = current.tail;
        }
        return false;
    }

    // Method to remove an item if it exists in the sequence
    public void remove(int item) {
        if (first == null) {
            return; // Empty list, nothing to remove
        }

        if (first.head == item) {
            first = first.tail; // Remove the first cell
            return;
        }

        Cell current = first;
        while (current.tail != null) {
            if (current.tail.head == item) {
                current.tail = current.tail.tail; // Remove the matching cell
                return;
            }
            current = current.tail;
        }
    }

    public void append(LinkedList b) {
        Cell nxt = this.first;
        Cell prev = null;
        
        // Move to the last cell of the current list
        while (nxt.tail != null) {
            prev = nxt;
            nxt = nxt.tail;
        }
        
        // Set the last cell of the current list to point to the first cell of the second list
        nxt.tail = b.first;
        
        // Clear the first cell of the second list (set it to null)
        b.first = null;
    }
    
    
    // Method to display the elements of the linked list
    public void display() {
        Cell current = first;
        while (current != null) {
            System.out.print(current.head + " -> ");
            current = current.tail;
        }
        System.out.println("null");
    }
    
    public LinkedList(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {
        last = new Cell(i, last);
        }
        first = last;
        }
}   
    /*public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(3);
        list.add(2);
        list.add(1);

       LinkedList anotherList = new LinkedList();
        anotherList.add(5);
        anotherList.add(4);

        list.append(anotherList);

        System.out.println("Length: " + list.length()); // Output: 5
        System.out.println("Contains 3: " + list.find(3)); // Output: true
        System.out.println("Contains 6: " + list.find(6)); // Output: false

        list.remove(1);
        System.out.println("Length after removing 2: " + list.length()); // Output: 4

        list.display();
    }*/
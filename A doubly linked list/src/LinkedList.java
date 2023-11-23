public class LinkedList {

    public Cell first;

    public class Cell {    //box
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
    
    public void unlinkS(Cell cell) {

    if (cell == null || first == null) {
        return; // Nothing to unlink or the list is empty
    }

    if (first == cell) {
        first = first.tail; // If the first cell is the one to unlink, update the first reference
        return;
    }

    Cell current = first;
    while (current != null && current.tail != cell) {
        current = current.tail;
    }

    if (current != null) {
        current.tail = cell.tail; // Update the previous cell's reference to skip the cell to be unlinked
    }
}

}   
    
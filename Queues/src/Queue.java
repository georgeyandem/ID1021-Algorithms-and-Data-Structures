public class Queue 
{
     Node head;
     Node tail;

     private class Node{
        Integer item;
        Node next;

        private Node(Integer item, Node list){
            this.item = item;
            this.next = list;
        }
     }
     public Queue(){
        head = null;
        tail = null;
     }
     public void add(Integer item){
        Node newNode = new Node(item, null);
        if(tail == null){
            head = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
     }
     public Integer remove(){
        if (head == null){
            throw new IllegalStateException("Queue is empty");
        }
        Integer removedItem = head.item;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return removedItem;
     }
    public static void main(String[] args) throws Exception {
        
        Queue myQueue = new Queue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.remove();

        while(myQueue.head != null){
            System.out.println(myQueue.remove()); 
        }
    }
}

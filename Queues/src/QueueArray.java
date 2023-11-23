public class QueueArray {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public QueueArray(int capacity){
        this.capacity = capacity;
        this.array = new int [capacity];
        this.front = 0;
        this.rear = -1; // Initial rear is -1 since we haven't added any elements yet
        this.size = 0;  // Initial size is 0 since the queue is empty
    }
    public void add(int item){
        if (size == capacity){
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear +1) % capacity;
        array[rear] = item;
        size++;
    }
    public int remove(){
        if (size == 0){
            throw new IllegalStateException("Queue is empty");
        }
        int removedItem = array[front];
        front = (front +1) % capacity;
        size--;
        return removedItem;
    }
    public static void main(String[] args){
        int capacity = 6;
        QueueArray queue = new QueueArray(capacity);
        
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.remove();
        queue.add(7);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.add(8);
        queue.add(9);

        for (int i = 0; i < capacity ; i++) {
            System.out.println(queue.remove());
        }
    }

}

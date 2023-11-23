public class DynamicQueue {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public DynamicQueue(int DynamicCapacity){
        this.capacity = DynamicCapacity;
        this.array = new int[DynamicCapacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    public void DynamicAdd(int item){
        if (size == capacity){
            resize(2 * capacity);
        }
        rear = (rear +1) % capacity;
        array[rear] = item;
        size++;
    }
    public int remove(){
        if(size == 0){
            throw new IllegalStateException("Queue in Empty");
        }
        int removedItem = array[front];
        front = (front +1) % capacity;
        size--;
        
        if (size <= capacity/4 && capacity > 2){
            resize(capacity / 2);
        }
        return removedItem;
    }
    public void resize(int newCapacity){
        int[] newArray = new int[newCapacity];

        for(int i = 0; i < size; i++){
            newArray[i] = array[(front + i) % capacity]; 
        }
        array =  newArray;
        front = 0;
        rear = size -1;
        capacity = newCapacity;
    }
}

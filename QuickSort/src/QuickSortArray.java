import java.util.Arrays;

public class QuickSortArray {

    public static void sort(int[] array){
        quickSort(array, 0, array.length -1);
    }
    private static void quickSort(int[] array, int min, int max){
        if (min < max){
            int pivotIndex = divide(array, min, max);
            quickSort(array, min, pivotIndex -1);
            quickSort(array, pivotIndex +1, max);
        }
    }
    private static int divide(int[] array, int min, int max){
        int pivot = array[min]; // Choose the first element as the pivot
        int i = min;
        int j = max; 

        while(i <j){
            // Move the left pointer (i) to the right until arr[i] >= pivot
            while(i <= max && array[i] <= pivot){
                i++;
            }
            // Move the right pointer (j) to the left until arr[j] <= pivot
            while(array[j] > pivot){
                j--;
            }
            // Swap arr[i] and arr[j] if i is still less than j
            if(i < j){
                swap(array, i, j);
            }
        }
        // Swap the pivot element with arr[j] (which is now in its correct position)
        swap(array, min, j);
        // Return the index where the pivot element is now located
        return j;
    }
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) throws Exception {
        int[] array = {5, 3, 1, 4, 2};
        System.out.println("Original Array: " + Arrays.toString(array));
        sort(array);
        //for (int num : array) {
          //  System.out.print(num + " ");
        System.out.println("Sorted Array: " + Arrays.toString(array));
    }
}
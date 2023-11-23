public class Merge {
    
    public static void sort(int[] org) 
    {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length - 1);
    }

    public static void sort(int[] org, int[] aux, int lo, int hi) 
    {
        if (lo != hi) 
        {
            int mid = (lo + hi) / 2;
            // sort the items from lo to mid
            sort(org, aux, lo, mid);
            // sort the items from mid+1 to hi
            sort(org, aux, mid + 1, hi);
            // merge the two sections using the additional array
            merge(org, aux, lo, mid, hi);
        }
    }

    public static void merge(int[] org, int[] aux, int lo, int mid, int hi) 
    {
        // Copy all items from lo to hi from org to aux
        for (int k = lo; k <= hi; k++) 
        {
            aux[k] = org[k];
        }

        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part

        // Merge the two subarrays back into org
        for (int k = lo; k <= hi; k++) 
        {
            if (i > mid) {
                org[k] = aux[j];
                j++;
            } else if (j > hi) {
                org[k] = aux[i];
                i++;
            } else if (aux[i] <= aux[j]) {
                org[k] = aux[i];
                i++;
            } else {
                org[k] = aux[j];
                j++;
            }
        }
    }
}
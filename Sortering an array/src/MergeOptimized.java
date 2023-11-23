public class MergeOptimized {
    public static void sort(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];
        sort(org, aux, 0, org.length - 1);
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi) / 2;
            // Toggle the arguments for the recursive call
            sort(aux, org, lo, mid);
            sort(aux, org, mid + 1, hi);
            // Merge the two sections using the original array as the destination
            merge(aux, org, lo, mid, hi);
        }
    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        int i = lo; // the index in the first part
        int j = mid + 1; // the index in the second part

        // Merge the two subarrays back into org
        for (int k = lo; k <= hi; k++) {
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

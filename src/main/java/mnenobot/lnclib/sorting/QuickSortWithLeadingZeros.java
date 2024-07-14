package mnenobot.lnclib.sorting;



public class QuickSortWithLeadingZeros {
        // A utility function to swap two elements
        private static void swap(String[] arr, int i, int j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    
    // The main function that implements QuickSort
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


}
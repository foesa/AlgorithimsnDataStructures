// -------------------------------------------------------------------------

/**
 * This class contains static methods that implementing sorting of an array of numbers
 * using different sort algorithms.
 *
 * @author efeosa eguavoen
 * @version HT 2019
 */

class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     */
    static double[] insertionSort(double a[]) {
        for (int count = 0; count < a.length; count++) {
            double move = a[count];
            for (int comp = count + 1; comp < a.length; comp++) {
                if (move > a[comp]) {
                    a[count] = a[comp];
                    a[comp] = move;
                }
            }
        }
        return a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     */
    static double[] quickSort(double a[]) {
        int low = 0;
        int high = a.length - 1;
        a = quicksort(a, low, high);
        return a;
    }//end quicksort

    static double[] quicksort(double arr[], int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            quicksort(arr, low, part - 1);
            quicksort(arr, part + 1, high);
        }
        return arr;
    }

    private static int partition(double arr[], int low, int high) {
        double pivot = arr[(int) high];
        int i = low - 1;
        for (int count = low; count < high; count++) {
            if (arr[count] <= pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

            }

        }
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;

    }

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative(double a[]) {

        int current;
        int leftStart;
        int arraySize = a.length - 1;
        for (current = 1; current <= arraySize; current = 2 * current) {
            for (leftStart = 0; leftStart <= arraySize; leftStart += 2 * current) {

                int mid = leftStart + current - 1;
                int right = getMin(leftStart + 2 * current - 1, arraySize);

                mergeArray(a, leftStart, mid, right);
            }

        }

    }//end mergesortIterative

    public static int getMin(int left, int right) {
        if (left <= right) {
            return left;
        } else {
            return right;
        }
    }

    public static void MergeSort(int[] array) {
        int current;
        int leftStart;
        int arraySize = array.length;
        for (current = 1; current <= arraySize - 1; current = 2 * current) {
            for (leftStart = 0; leftStart < arraySize - 1; leftStart += 2 * current) {

                int mid = leftStart + current - 1;
                int right = getMin(leftStart + 2 * current - 1, arraySize - 1);

                mergeArray(array, leftStart, mid, right);
            }
        }
    }

    static void printArray(int A[]) {
        int i;
        for (i = 0; i < A.length; i++)
            System.out.println(A[i]);
    }

    static void mergeArray(int array[], int left, int mid, int right) {
        int leftArraySize = mid - left + 1;
        int rightArraySize = right - mid;

        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < rightArraySize; j++)
            rightArray[j] = array[mid + 1 + j];

        int leftPtr = 0;
        int rightPtr = 0;
        int tempPtr = left;
        while (leftPtr < leftArraySize && rightPtr < rightArraySize) {
            if (leftArray[leftPtr] <= rightArray[rightPtr]) {
                array[tempPtr] = leftArray[leftPtr];
                leftPtr++;
            } else {
                array[tempPtr] = rightArray[rightPtr];
                rightPtr++;
            }
            tempPtr++;
        }

        while (leftPtr < leftArraySize) {
            array[tempPtr++] = leftArray[leftPtr++];

            leftPtr++;
            tempPtr++;
        }

        while (rightPtr < rightArraySize) {
            array[tempPtr++] = rightArray[rightPtr++];

            rightPtr++;
            tempPtr++;
        }
    }


    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive(double a[]) {
        int left = 0;
        int right = a.length-1;
        mergeSortRecursive(a,left,right);

    }//end mergeSortRecursive

    static void mergeSortRecursive(double a[],int left,int right){
        if (left < right)
        {

            int m = (left+right)/2;


            mergeSortRecursive(a, left, m);
            mergeSortRecursive(a , m+1, right);


            merge(a, left, m, right);
        }
    }

    static void merge(double arr[], int left, int m, int right){
        int n1 = m - left + 1;
        int n2 = right - m;

        /* Create temp arrays */
        double L[] = new double[n1];
        double R[] = new double [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     */
    static double[] selectionSort(double a[]) {

        //todo: implement the sort

    }//end selectionsort

    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

}//end class
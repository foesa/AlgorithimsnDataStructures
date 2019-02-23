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
        if(a.length == 0){
            return null;
        }
        int n = a.length;
        for (int curr=1; curr<n; curr++)
        {
            double num = a[curr];
            int curnum = curr-1;
            while (curnum>=0 && a[curnum] > num)
            {
                a[curnum+1] = a[curnum];
                curnum = curnum-1;
            }
            a[curnum+1] = num;
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
        if(a.length == 0){
            return null;
        }
        int low = 0;
        int high = a.length - 1;
        a = quicksort(a, low, high);
        return a;
    }//end quicksort

    private static double[] quicksort(double arr[], int low, int high) {
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
        if(a.length == 0){
            return null;
        }
       int length = a.length;
       double [] aux = new double[length];
       for(int count =1;count<length;count = count+count){
           for(int bottom = 0;bottom < (length-count);bottom += (count+count)){
               merge(a,aux,bottom,bottom+count-1,Math.min((bottom+count+count)-1,length-1));
           }
       }
       return a;
    }//end mergesortIterative

    static void merge(double a[], double[] aux,int bottom,int mid,int top) {
        int i = bottom;
        int j = mid+1;
        for(int k = bottom;k<= top;k++){
            aux[k] = a[k];
        }
        for(int k = bottom;k <= top; k++){
            if (i >mid){
                a[k] = aux[j++];
            }
            else if(j>top){
                a[k] = aux[i++];
            }
            else if(less(aux[j],aux[i])){
                a[k] = aux[j++];
            }
            else{
                a[k] = aux[i++];
            }
        }
    }

    static boolean less(double a, double b){
        if (b>a) return true;
        return false;
    }

        /**
         * Sorts an array of doubles using recursive implementation of Merge Sort.
         * This method is static, thus it can be called as SortComparison.sort(a)
         *
         * @param a: An unsorted array of doubles.
         * @return after the method returns, the array must be in ascending sorted order.
         */
    static double[] mergeSortRecursive(double a[]) {
        if(a.length == 0){
            return null;
        }
        int left = 0;
        int right = a.length-1;
        mergeSortRecursive(a,left,right);
        return a;
    }//end mergeSortRecursive

    private static void mergeSortRecursive(double a[],int left,int right){
        if (left < right)
        {

            int m = (left+right)/2;


            mergeSortRecursive(a, left, m);
            mergeSortRecursive(a , m+1, right);


            merger(a, left, m, right);
        }
    }

    private static void merger(double arr[], int left, int m, int right){
        int n1 = m - left + 1;
        int n2 = right - m;


        double L[] = new double[n1];
        double R[] = new double [n2];


        for (int i=0; i<n1; ++i)
            L[i] = arr[left + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];



        int i = 0, j = 0;


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


        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }


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
        if(a.length == 0){
            return null;
        }
        int n = a.length;


        for (int i = 0; i < n-1; i++)
        {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            double temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }//end selectionsort

    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

}//end class
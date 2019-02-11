// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author efeosa eguavoen
 *  @version HT 2019
 */

class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        for(int count =0; count<a.length;count++){
            double move = a[count];
            for(int comp = count+1;comp<a.length;comp++){
                if(move>a[comp]){
                    a[count] = a[comp];
                    a[comp] = move;
                }
            }
        }
        return  a;
    }

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        int low = 0;
        int high = a.length-1;
        a = quicksort(a,low,high);
        return a;
    }//end quicksort

    static double[] quicksort(double arr [],int low, int high){
        if (low<high){
            int part = partition(arr,low,high);
            quicksort(arr, low,part-1);
            quicksort(arr,part+1,high);
        }
        return arr;
    }

    private static int partition(double arr[],int low,int high){
        double pivot = arr[(int)high];
        int i = low -1;
        for(int count = low;count <high;count++){
            if(arr[count]<= pivot){
                i++;
                double temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;

            }

        }
        double temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;

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

    static double[] mergeSortIterative (double a[]) {

        //todo: implement the sort

    }//end mergesortIterative



    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {


        //todo: implement the sort

    }//end mergeSortRecursive


    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

        //todo: implement the sort

    }//end selectionsort

    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    }

}//end class
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
/*
This are the times taken in nanoseconds as I used System.nanoTime to get the time taken for the functions
                        Insert |Quick  |MergeIterative|MergeRecursive|Selection
              10 random |5237ns|17086ns|34501ns|20509ns|6703ns
              ---------------------------------------------------------------
             100 random |161659ns|538569ns|296056ns|320593ns|489284ns
             ----------------------------------------------------------------
            1000 random |6170546ns|8778256ns|816630ns|969396ns|5756596ns
            -----------------------------------------------------------------
        1000 few unique |5538016ns|8106127ns|699879ns|841423ns|7782553ns
        ---------------------------------------------------------------------
    1000 nearly ordered |1461614ns|8121586ns|1092712ns|924487ns|6140212ns
    -------------------------------------------------------------------------
     1000 reverse order |10228068ns|13596909ns|791161ns|928143ns|4532232ns
     ------------------------------------------------------------------------
            1000 sorted |91211ns|13988322ns|694781ns|864565ns|4280081ns

            Q1. Insertion sort as if the input is in anyway order the number of moves and such required is reduced as shown in 1000 sorted vs 1000 random
            Q2. Insertion sort as the number of moves and comparisons in an sorted array vs a backwards array is huge resulting in a high time to process
            Q3. From the results, MergeSortIterative/Recursive has best scalability as while the time taken is high, it's very constant as it goes up but in practise it would
            normally be quicksort.
            Q4. Iterative seems to work faster than recursive(probably due to no recursive calls so less reads etc) but only slightly faster. They scale the same though.
            Q5. InsertionSort for n=10
                InsertionSort for n=100
                MergeIterative for n=1000
                MergeIterative for n=1000(few unique)
                MergeRecursive for n=1000(nearly ordered)
                MergeIterative for n=1000(reverseOrdered)
                InsertionSort for n=1000(Sorted)
 */
//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author : efeosa eguavoen 17324649
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTestTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        SortComparison sorter = new SortComparison();
        double[] a = new double[0];
        assertNull("Checking for empty arrays",sorter.quickSort(a));
        assertNull(sorter.insertionSort(a));
        assertNull(sorter.mergeSortRecursive(a));
        assertNull(sorter.mergeSortIterative(a));
        assertNull(sorter.selectionSort(a));
    }

    @Test
    public void testInsertionSort(){
        SortComparison sorter = new SortComparison();
        double[] a = new double[10];
        Random rand = new Random();
        for(int count =0;count<a.length;count++){
            a[count] = (double)rand.nextInt(20);
        }
        double[] b = new double[a.length];
        b = Arrays.copyOf(a,a.length);
        System.out.println(Arrays.toString(b));
        Arrays.sort(a);
        assertArrayEquals(a,sorter.insertionSort(b),0);
    }

   @Test
    public void testMergeIterative(){
        SortComparison sorter = new SortComparison();
        double[] a = new double[10];
        Random rand = new Random();
        for(int count =0;count<a.length;count++){
            a[count] = (double)rand.nextInt(20);
        }
        double[] b = new double[a.length];
        b = Arrays.copyOf(a,a.length);
        Arrays.sort(a);
        assertArrayEquals(a,sorter.mergeSortIterative(b),0);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testMergeRecursive(){
        SortComparison sorter = new SortComparison();
        double[] a = new double[10];
        Random rand = new Random();
        for(int count =0;count<a.length;count++){
            a[count] = (double)rand.nextInt(20);
        }
        double[] b = new double[a.length];
        b = Arrays.copyOf(a,a.length);
        Arrays.sort(a);
        assertArrayEquals(a,sorter.mergeSortRecursive(b),0);
    }

    @Test
    public void testQuickSort(){
        SortComparison sorter = new SortComparison();
        double[] a = new double[10];
        Random rand = new Random();
        for(int count =0;count<a.length;count++){
            a[count] = (double)rand.nextInt(20);
        }
        double[] b = new double[a.length];
        b = Arrays.copyOf(a,a.length);
        Arrays.sort(a);
        assertArrayEquals(a,sorter.quickSort(b),0);
    }

    @Test
    public void testSelectionSort(){
        SortComparison sorter = new SortComparison();
        double[] a = new double[10];
        Random rand = new Random();
        for(int count =0;count<a.length;count++){
            a[count] = (double)rand.nextInt(20);
        }
        double[] b = new double[a.length];
        b = Arrays.copyOf(a,a.length);
        Arrays.sort(a);
        assertArrayEquals(a,sorter.selectionSort(b),0);
    }
    //  add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    // ----------------------------------------------------------

    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {

    }

}

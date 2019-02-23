import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

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
    public ArrayList<Long> timer(double[] numbers){
        ArrayList<Long> times = new ArrayList<Long>();
        int index = 0;
        long start;
        long end;
        long duration;
        SortComparison sorter = new SortComparison();
        for(int count =0;count <4;count++){

        }
    }
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        File file = new File("/home/foesa/Documents/numbers10.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String curr = null;
        int i =0;
        double []a = new double[10];
        while((curr = reader.readLine())!=null){
            double num = Double.parseDouble(curr);
            a[i] = num;
            i++;
        }

    }

}

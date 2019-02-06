public class testinas {
    public static void main (String[] args){
        int x = 4;
        int[] testarr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(testarr,x));
    }
    static boolean binarySearch(int[] a, int x)
    {
        boolean finished = false;
        int start = 0;
        int end = a.length-1;
        while(!finished){
            int currentElem = ((start + end)/2);
            if (a[currentElem] == x){
                return true;
            }
            else if(a[currentElem] > x){
                end = currentElem -1;
            }
            else if(a[currentElem] < x){
                start = currentElem +1;
            }
            if (a[a.length-1]<x){
                finished = true;
            }
        }
        return false;
    }

}

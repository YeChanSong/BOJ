import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        int[] arr = {1,5,2,10,10,20,20,20,30,30,30,50,99};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int lowerBound = lowerBoundByBinarySearch(arr, 99);
        System.out.println(lowerBound);
    }

    private static int lowerBoundByBinarySearch(int[] arr, int target) {

        int count = arr.length;
        int first = 0, step = 0, mid = 0; // it == mid
        while (count > 0) {
            mid = first; step = count/2; mid += step;
            if (arr[mid] < target) {
                first = ++mid;
                count -= step+1;
            } else {
                count = step;
            }
        }
        return first;
    }

}
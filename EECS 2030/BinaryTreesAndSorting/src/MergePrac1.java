/**
 * Created by aamir on 2016-07-28.
 */

import java.util.Arrays;

public class MergePrac1
{
    public static void mergesort(int[] array)
    {
        int arraylen = array.length;
        if(arraylen < 2) return;

        int mid = arraylen / 2; // find initial dividing point
        int leftlen = mid;
        int rightlen = arraylen - mid;

        int[] left = new int[leftlen];
        int[] right = new int[rightlen];

        for(int i = 0; i < mid; i++)
        {
            left[i] = array[i];
        }

        for(int i = mid; i < arraylen; i++)
        {
            right[i-mid] = array[i];
        }

        mergesort(left);
        mergesort(right);
        merge(left, right, array); // merge final left and right arrays back to one array
    }

    private static void merge(int[] left, int[] right, int[] arr)
    {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
        {
            if(left[i] <= right[j])
            {
                arr[k++] = left[i++];
            }
            else
            {
                arr[k++] = right[j++];
            }
        }
        
        while (i < left.length)
        {
            arr[k++] = left[i++];
        }

        while (j < right.length)
        {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {9, 4, 1, 7, 0, 2, -1, 1, 3};
        System.out.println("Input: " + Arrays.toString(arr));
        mergesort(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}

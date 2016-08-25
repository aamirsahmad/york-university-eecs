import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/**
 * This class demonstrates bubble, selection, insertion, and merge
 * sort algorithms.
 *
 * @author Steven Castellucci, 2015
 */
public class Sorting
{
    public static void bubbleSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            // For each element...
            for (int j = i + 1; j < array.length; j++)
            {
                // compare it with each subsequent element and swap if needed
                if (array[i] > array[j]) // Swap
                {
                    int hold = array[i];
                    array[i] = array[j];
                    array[j] = hold;
                }
            }
        }
    }



    public static void selectionSort(int[] array)
    {
        int idxMax;      // Index of the largest element
        for (int i = array.length - 1; i > 0; i--)
        {
            idxMax = i;  // Initialize to the last index of the
            // "not-yet-sorted group"
            for (int j = 0; j < i; j++)
            {
                if (array[idxMax] < array[j])
                {
                    idxMax = j;
                }
            }
            // Largest is at idxMax -- swap
            int hold = array[i];
            array[i] = array[idxMax];
            array[idxMax] = hold;
        }
    }



    public static void insertionSort(int[] array)
    {
        for (int i = array.length - 2; i >= 0; i--)
        {
            // Let the last element be "sorted" and start from the
            // second-last index
            int key = array[i];
            int j = i;
            // Shift the sorted elements down to make room for the
            // new element
            while (j < array.length - 1 && array[j + 1] < key)
            {
                array[j] = array[j + 1];
                j++;
            }
            // Insert the new element in its correct spot
            array[j] = key;
        }
    }



    public static void mergeSort(int[] array)
    {
        // Initiate the recursive call
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int startIdx, int endIdx)
    {
        // Base case: sub-array of 1 element --> no nothing
        // Recursive case: divide sub-array into 2 sub-arrays
        if (startIdx < endIdx)
        {
            int midIdx = startIdx + (endIdx - startIdx) / 2;
            // Recursive call for left sub-array
            mergeSort(array, startIdx, midIdx);
            // Recursive call for right sub-array
            mergeSort(array, midIdx + 1, endIdx);
            // Merge the two sub-arrays in sorted order
            merge(array, startIdx, midIdx, endIdx);
        }
    }

    private static void merge(int[] array, int startIdx, int midIdx, int endIdx)
    {
		/*  Let's call the sub-arrays A and B.  A = 0..midIdx,
			B = midIdx+1..endIdx. Initialize two variables, i and j = 0,
			representing pointers to the next element to merge in each
			of the sub-arrays.

			Loop while i and j are not at the end:
			If array[i] < array[j], move array[i] to the next available
			spot in a temporary array, and increment i. Otherwise, move
			array[j] and increment j.
			
			At the end of the loop, there might be more elements in A or B
			(but not both).  Copy the remaining elements (already sorted).
			Copy the elements from the temporary array back to 'array'.
			The elements are now in sorted order.
		*/
        int i = 0; // starting index of array
        int j = 0; // starting index of tmpArray
        int k = midIdx + 1; // starting index of subarray B - right side

        int[] tmpArray = new int[array.length];

        while( i <= midIdx && k <= endIdx )
        {
            if(array[i] < array[k])
            {
                tmpArray[ j++ ] = array[ i++ ];

            }
            else
            {
                tmpArray[j++] = array[k++];
            }
        }
        while (i <= midIdx)
        {
            tmpArray[j++] = array[i++];
        }
        while (k <= endIdx)
        {
            tmpArray[j++] = array[k++];
        }

        array = tmpArray.clone();

    }



    public static void main(String[] args)
    {
        final int MAX_TO_OUTPUT = 21;     // if n >= 21, don't output elements
        final int MAX_OUTPUT_RANGE = 100; // if n <= 21, elements = 0..100
        final double MS_PER_S = 1000;

        // Prompt user
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;
        output.print("Size of array to sort: ");
        int n = input.nextInt();

        // Generate random array
        int[] original = new int[n];
        Random rng = new Random();
        for (int i = 0; i < n; i++)
        {
            if (n < MAX_TO_OUTPUT)
            {
                // If outputting array, limit elements to 2 digits for space.
                original[i] = rng.nextInt(MAX_OUTPUT_RANGE);
            }
            else
            {
                original[i] = rng.nextInt();
            }
        }
        int[] toSort = Arrays.copyOf(original, n);
        int[] oracle = Arrays.copyOf(original, n);
        Arrays.sort(oracle);
        long start, duration;


        // Call bubble sort
        output.print("\nBubble Sort:\t");
        start = System.currentTimeMillis();  // Get the current time
        Sorting.bubbleSort(toSort);
        duration = System.currentTimeMillis() - start; // Time to sort
        if (Arrays.equals(toSort, oracle))   // Array sorted
        {
            output.printf("passed, %5.3f seconds\n", duration / MS_PER_S);
        }
        else if (n < MAX_TO_OUTPUT)          // Array not sorted
        {
            output.println("failed!");
            for (int i = 0; i < n; i++)
            {
                output.printf("%3d", toSort[i]);
            }
            output.println();
        }
        else                                 // Array not sorted
        {
            output.println("failed! Try a smaller array size to debug.");
        }
        toSort = Arrays.copyOf(original, n); // Reset array for next sort


        // Call selection sort
        output.print("\nSelection Sort:\t");
        start = System.currentTimeMillis();  // Get the current time
        Sorting.selectionSort(toSort);
        duration = System.currentTimeMillis() - start; // Time to sort
        if (Arrays.equals(toSort, oracle))   // Array sorted
        {
            output.printf("passed, %5.3f seconds\n", duration / MS_PER_S);
        }
        else if (n < MAX_TO_OUTPUT)          // Array not sorted
        {
            output.println("failed!");
            for (int i = 0; i < n; i++)
            {
                output.printf("%3d", toSort[i]);
            }
            output.println();
        }
        else                                 // Array not sorted
        {
            output.println("failed! Try a smaller array size to debug.");
        }
        toSort = Arrays.copyOf(original, n); // Reset array for next sort


        // Call insertion sort
        output.print("\nInsertion Sort:\t");
        start = System.currentTimeMillis();  // Get the current time
        Sorting.insertionSort(toSort);
        duration = System.currentTimeMillis() - start; // Time to sort
        if (Arrays.equals(toSort, oracle))   // Array sorted
        {
            output.printf("passed, %5.3f seconds\n", duration / MS_PER_S);
        }
        else if (n < MAX_TO_OUTPUT)          // Array not sorted
        {
            output.println("failed!");
            for (int i = 0; i < n; i++)
            {
                output.printf("%3d", toSort[i]);
            }
            output.println();
        }
        else                                 // Array not sorted
        {
            output.println("failed! Try a smaller array size to debug.");
        }
        toSort = Arrays.copyOf(original, n); // Reset array for next sort


        // Call merge sort
        output.print("\nMerge Sort:\t");
        start = System.currentTimeMillis();  // Get the current time
        Sorting.mergeSort(toSort);
        duration = System.currentTimeMillis() - start; // Time to sort
        if (Arrays.equals(toSort, oracle))   // Array sorted
        {
            output.printf("passed, %5.3f seconds\n", duration / MS_PER_S);
        }
        else if (n < MAX_TO_OUTPUT)          // Array not sorted
        {
            output.println("failed!");
            for (int i = 0; i < n; i++)
            {
                output.printf("%3d", toSort[i]);
            }
            output.println();
        }
        else                                 // Array not sorted
        {
            output.println("failed! Try a smaller array size to debug.");
        }
        toSort = Arrays.copyOf(original, n); // Reset array for next sort
    }
}
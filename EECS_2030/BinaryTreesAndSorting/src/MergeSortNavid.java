import java.util.Arrays;

public class MergeSortNavid
{
    /**
     * Entry point of the merge sort
     * @param arrayToBeSorted is the original array to be sorted
     */
    public static void sort(int[] arrayToBeSorted)
    {
        //create a buffer array to be used in the split, merge and copy tasks
        int[] buffer = new int[arrayToBeSorted.length];
        split(arrayToBeSorted, 0, arrayToBeSorted.length, buffer);
    }

    /**
     * Recursively split the arrayToBeSorted into two halves until size is 1,
     * then merge the halves and copy back the result.
     * @param arrayToBeSorted is the original array to be sorted
     * @param indexStart is the start index, where split starts
     * @param indexEnd is the end index, where split ends
     * @param buffer is the buffer to be used when splitting and merging back
     */
    private static void split(int[] arrayToBeSorted, int indexStart, int indexEnd, int[] buffer)
    {
        //base case -  Only 1 element is given, hence no split is possible
        if (indexEnd - indexStart < 2)
        {
            return;
        }

        //indexMiddle is the middle index between start and end indices
        int indexMiddle = (indexEnd + indexStart) / 2;

        //left half is arrayToBeSorted from indexStart to indexMiddle-1
        //right half is arrayToBeSorted from indexMiddle to indexEnd-1

        //split the left half again
        split(arrayToBeSorted, indexStart, indexMiddle, buffer);

        //split the right half again
        split(arrayToBeSorted, indexMiddle, indexEnd, buffer);

        //merge back the two halves
        merge(arrayToBeSorted, indexStart, indexMiddle, indexEnd, buffer);

        //copy back from buffer to the original arrayToBeSorted
        copy(buffer, indexStart, indexEnd, arrayToBeSorted);
    }


    /**
     *
     * @param arrayToBeSorted is the original array to be sorted
     * @param indexStart is the start index, where merge starts
     * @param indexMiddle is the middle index between start and end indices
     * @param indexEnd is the end index, where merge ends
     * @param buffer is the buffer to be used when merging
     */
    private static void merge(int[] arrayToBeSorted, int indexStart, int indexMiddle, int indexEnd, int[] buffer)
    {
        int i, j, k;

        i = k = indexStart;
        j = indexMiddle;

        //while there are elements in the left or right sides
        while (k < indexEnd)
        {
            //if there is an element in the left side that is smaller and equal to the right side:
            if (i < indexMiddle && (j >= indexEnd || arrayToBeSorted[i] <= arrayToBeSorted[j]))
            {
                buffer[k++] = arrayToBeSorted[i++];
            }
            else
            {
                buffer[k++] = arrayToBeSorted[j++];
            }
        }
    }

    /**
     * copy the the source to the destination array from the start index to the end index
     * @param source array to be copied from.
     * @param indexStart start index in the copy process.
     * @param indexEnd end index in the copy process.
     * @param destination array to be copied to.
     */
    private static void copy(int[] source, int indexStart, int indexEnd, int[] destination)
    {
        for (int i = indexStart; i < indexEnd; i++)
        {
            destination[i] = source[i];
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {8, 2, 0, 9, 7, 3, 6, 5, 4, 11, -2};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println();
    }

}


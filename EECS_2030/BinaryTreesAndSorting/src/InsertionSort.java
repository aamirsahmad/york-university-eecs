/**
 * Created by aamir on 2016-07-27.
 */
public class InsertionSort
{
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

    // TESTING
    public static void main(String[] args)
    {
        int[] arr = new int[6];
        arr[0] = 3;
        arr[1] = 7;
        arr[2] = 5;
        arr[3] = 2;
        arr[4] = 11;
        arr[5] = 9;

        System.out.println("Print Array");
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        System.out.println("Selection Sort and Print Array");
        insertionSort(arr);
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
    }
}

/**
 * Created by aamir on 2016-07-27.
 */
public class BubbleSort
{
    public static void bubbleSort(int[] array)
    {
        // For looping over the entire array
        for (int i = 0; i < array.length - 1; i++)
        {
            // For each element...
            for (int j = i + 1; j < array.length; j++)
            {
                // compare it with each subsequent element and swap if needed
                if (array[i] > array[j]) // Swap
                {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
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

        for(int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
        bubbleSort(arr);
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
    }
}

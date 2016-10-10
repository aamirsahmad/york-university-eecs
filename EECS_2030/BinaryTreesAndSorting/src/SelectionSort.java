/**
 * Created by aamir on 2016-07-27.
 */
public class SelectionSort
{
    public static void selectionSort(int[] array)
    {
        int min;      // Index of the smallest element
        for (int i = 0; i < array.length - 1 ; i++)
        {
            min = i;  // assume first element is smallest
            // "not-yet-sorted group"
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < array[min])
                {
                    min = j;
                }
            }
            // Largest is at idxMax -- swap
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
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
        selectionSort(arr);
        for(int i : arr)
        {
            System.out.print(i + " ");
        }
    }
}

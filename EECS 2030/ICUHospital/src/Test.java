import java.util.Scanner;

/**
 * Created by aamir on 2016-08-06.
 */
public class Test
{
    public static void main(String[] args)
    {
        ICU icuWard = ICU.getInstance();
        Scanner input = new Scanner(System.in);
        boolean on = true;
        while(on)
        {
            System.out.println("Please select the following options. Enter the number only.");
            System.out.println("1. Add a Patient");
            System.out.println("2. Add a Doctor");
            System.out.println("3. Add a Nurse");

            try{
                String select0 = input.next();

                switch (select0)
                {
                    case "1":
                        System.out.println("Enter Name");
                        String name = input.next();
                        icuWard.addPatient(name);
                        System.out.println("Enter DOB");
                        String dob = input.next();
                        System.out.println("Enter Sex");
                        String sex = input.next();
                        System.out.println("Enter Blood Group");
                        String bg = input.next();
                        System.out.println("Assign Doctor");
                        String str = input.next();
                        break;
                    case "2":
                        System.out.println("Enter Name");
                        break;
                    case "3":
                        System.out.println("Enter Name");
                        break;
                    case "q":
                        on = false;
                        return;
                }
            }
            catch (Exception e)
            {
                System.out.println("Wrong input. Try again.");
            }

        }
    }
}

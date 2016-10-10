/**
 * Created by aamir on 2016-08-06.
 */
public class ICU
{
    private static volatile ICU instance = null;

    public static ICU getInstance()
    {
        if (null == instance)
        {
            synchronized (ICU.class)
            {
                if (null == instance)
                {
                    instance = new ICU();
                }
            }
        }
        return instance;
    }

    public Patient addPatient(String name)
    {
        return new Patient(name);
    }


    public Doctor addSurgeon(String name)
    {
        return new Surgeon(name);
    }

    public Doctor addConsultant(String name)
    {
        return new Consultant(name);
    }

    public Nurse addNurse(String name)
    {
        return new Nurse(name);
    }


    private ICU()
    {
    }
}

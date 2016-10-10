import java.util.UUID;

public class UUIDFactory {

    //private constructor
    private UUIDFactory()
    {
    }

    //static volatile instance of the class
    private static volatile UUIDFactory instance = null;

    //getInstance to get a reference to the singleton class
    public static UUIDFactory getInstance()
    {
        //if instance is created, no need to creat a new one
        if (null == instance)
        {
            //double clutching to assure no issues with other threads
            synchronized (UUIDFactory.class)
            {
                if (null == instance)
                {
                    instance = new UUIDFactory();

                    uuid = new UUID(32,16);
                }
            }
        }
        return instance;
    }


    //rest of the methods can remain regular
    private static volatile UUID uuid = null; //http://www.ietf.org/rfc/rfc4122.txt
    public UUID generate()
    {
        return uuid.randomUUID();
    }


}


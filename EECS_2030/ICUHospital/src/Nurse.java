import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aamir on 2016-08-06.
 */
public class Nurse
{
    private String name;
    private String dept;
    private String type;
    private double sallary;
    private boolean benefits;
    private Map<Patient, Date> shiftsLog;

    public Nurse(String name)
    {
        this.name = name;
        this.shiftsLog = new HashMap<Patient, Date>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDept()
    {
        return dept;
    }

    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getSallary()
    {
        return sallary;
    }

    public void setSallary(double sallary)
    {
        this.sallary = sallary;
    }

    public boolean isBenefits()
    {
        return benefits;
    }

    public void setBenefits(boolean benefits)
    {
        this.benefits = benefits;
    }

    public void addShift(Patient patient, Date date)
    {
        this.shiftsLog.put(patient, date);
    }

    @Override
    public String toString()
    {
        return "Nurse{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", type='" + type + '\'' +
                ", sallary=" + sallary +
                ", benefits=" + benefits +
                ", shiftsLog=" + shiftsLog +
                '}';
    }
}

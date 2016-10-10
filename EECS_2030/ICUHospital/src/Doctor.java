import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by aamir on 2016-08-06.
 */
public abstract class Doctor
{
    private UUID id;
    private String name;
    private String dept;
    private String type;
    private double sallary;
    private boolean benefits;
    private Map<Patient, Date> visitsLog;

    public Doctor(){}

    public Doctor(String name)
    {
        this.id = id.randomUUID();
        this.name = name;
        this.visitsLog = new HashMap<Patient, Date>();
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

    public void addVisit(Patient patient, Date date)
    {
        this.visitsLog.put(patient, date);
    }

    @Override
    public String toString()
    {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", type='" + type + '\'' +
                ", sallary=" + sallary +
                ", benefits=" + benefits +
                ", visitsLog=" + visitsLog.toString() +
                '}';
    }
}

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by aamir on 2016-08-06.
 */
public class Patient implements Curable, Comparable<Patient>
{
    private UUID id;
    private String name;
    private Date dob;
    private char sex;
    private String bloodGrp;
//    private enum Sex {MALE, FEMALE, OTHER};
//    private enum bloodGrp {Apos, Bpos, ABpos, Opos, Aneg, Bnev, ABnev, Onev};
    private Date admitDate;
    private Date releaseDate;
    private List<Doctor> doctors;
    private List<Nurse> nurses;
    private List<String> illnesses;


    public Patient(String name)
    {
        this.id = id.randomUUID();
        this.name = name;
        this.admitDate = new Date();
        this.doctors = new ArrayList<Doctor>();
        this.nurses = new ArrayList<Nurse>();
        this.illnesses = new ArrayList<String>();

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getDob()
    {
        return new Date(this.dob.getTime());
    }

    public void setDob(Date dob)
    {
        this.dob = new Date(dob.getTime());
    }

    public char getSex()
    {
        return sex;
    }

    public void setSex(char sex)
    {
        this.sex = sex;
    }

    public String getBloodGrp()
    {
        return bloodGrp;
    }

    public void setBloodGrp(String bloodGrp)
    {
        this.bloodGrp = bloodGrp;
    }

    public Date getAdmitDate()
    {
        return admitDate;
    }


    public Date getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public List getDoctors()
    {
        return doctors;
    }

    public void addDoctor(Doctor doctor)
    {
        this.doctors.add(doctor);
    }

    public List getNurses()
    {
        return nurses;
    }

    public void addNurse(Nurse nurse)
    {
        this.nurses.add(nurse);
    }

    public List getIllnesses()
    {
        return illnesses;
    }

    public void addIllnesses(String illness)
    {
        this.illnesses.add(illness);
    }

    @Override
    public boolean isCurable()
    {
        boolean check = true;
        for(String s : this.illnesses)
        {
            if(s.contains("cancer") || s.contains("Cancer"))
            {
                check = false;
            }
        }
        return check;
    }

    @Override
    public int compareTo(Patient o)
    {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString()
    {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", sex=" + sex +
                ", bloodGrp='" + bloodGrp + '\'' +
                ", admitDate=" + admitDate +
                ", releaseDate=" + releaseDate +
                ", doctors=" + getDocsName() +
                ", nurses=" + getNursesName() +
                ", illnesses=" + illnesses.toString() +
                '}';
    }

    public String getDocsName()
    {
        String str = "";
        for(Doctor d : this.doctors)
        {
            str += d.getName();
            if(this.doctors.get(this.doctors.size() - 1) != d)
            {
                str += ", ";
            }

        }
        return str;
    }

    public String getNursesName()
    {
        String str = "";
        for(Nurse n : this.nurses)
        {
            str += n.getName();
            if(this.nurses.get(this.nurses.size() - 1) != n)
            {
                str += ", ";
            }

        }
        return str;
    }
}

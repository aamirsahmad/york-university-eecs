import java.util.Date;

/**
 * Created by aamir on 2016-08-06.
 */
public class Main
{
    public static void main(String[] args)
    {
        ICU icuWard = ICU.getInstance();

        Doctor drake = icuWard.addConsultant("Drake");
        drake.setDept("Heart");
        drake.setSallary(200000);
        drake.setType("perm");
        drake.setBenefits(true);

        Doctor snoop = icuWard.addSurgeon("Snoop");
        snoop.setDept("Brain");
        snoop.setSallary(223000);
        snoop.setType("perm");
        snoop.setBenefits(false);

        Nurse mia = icuWard.addNurse("Mia");
        mia.setDept("Care");
        mia.setType("temp");
        mia.setSallary(100000);
        mia.setBenefits(true);

        Nurse nicki = icuWard.addNurse("Nicki");
        nicki.setDept("Cleaning");
        nicki.setType("perm");
        nicki.setSallary(125000);
        nicki.setBenefits(true);

        Patient john = icuWard.addPatient("John");
        Date johnDOB = new Date();
        johnDOB.setYear(1992);
        johnDOB.setMonth(5);
        johnDOB.setDate(20);
        john.setSex('M');
        john.addIllnesses("STD");
        john.setDob(johnDOB);
        john.setBloodGrp("AB-");
        john.addDoctor(drake);
        john.addDoctor(snoop);
        john.addNurse(mia);
        john.addNurse(nicki);

        john.addIllnesses("cancer");
        john.addIllnesses("HIV");
        john.addIllnesses("Pneumonia");

        // Visits Log
        drake.addVisit(john, new Date());
        snoop.addVisit(john, new Date());

        // Shifts Log
        mia.addShift(john, new Date());
        nicki.addShift(john, new Date());


        System.out.println(john);

        System.out.println(drake);
        System.out.println(snoop);
        System.out.println(mia);
        System.out.println(nicki);

        System.out.println(john.isCurable());

    }
}


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.lang.*; 

public class NameSplitter 
{
    NameSplitter(String text)
    {
        String[] splitted = text.split(" ");
        if((splitted.length < 3) || (splitted.length > 5))
        {
            throw new RuntimeException();
        }

        F = splitted[0];
        I = splitted[1];
        O = splitted[2];

        char s = O.charAt(O.length() - 1);

        switch (s) 
        {
            case 'а':
                sex = "жен";
                break;
            case 'ч':
                sex = "муж";
                break;
            default:
                throw new RuntimeException();
        }

        if (splitted.length > 3)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate burthDate = LocalDate.parse(splitted[3], formatter);
            
            Period period = Period.between(burthDate, LocalDate.now());

            int ageInt = period.getYears();
 
            if (ageInt < 0)
            {
                throw new RuntimeException();
            }

            age = Integer.toString(ageInt);
            bDate = splitted[3];
        }
        else
        {
            age = "NA";
            bDate = "NA";
        }

    };

    public String getF() {return F; };
    public String getI() {return I; };
    public String getO() {return O; };

    public String getSex() {return sex; };
    public String getAge() {return age; };
    public String getDateOfBirth() {return bDate; };

    public char getIShort() {return I.charAt(0); };
    public char getOShort() {return O.charAt(0); };    

    private String F, I, O;
    private String age, bDate;
    private String sex;

}
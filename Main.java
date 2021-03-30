import java.util.Scanner;

public class Main
{
    public static void main(final String args[])
    {
        System.out.print("Введите ФИО и (опционально) дату рождения в формате дд.мм.гггг\n");
        Scanner in = new Scanner(System.in);
        String rawString = in.nextLine();

        try 
        {
            NameSplitter splitted = new NameSplitter(rawString);
            System.out.println(splitted.getF() + " " + 
                               splitted.getIShort() + "." + 
                               splitted.getOShort() + ". пол " + 
                               splitted.getSex() + ". возраст " +
                               splitted.getAge());
            in.close();
        } 
        catch (Exception e) 
        {
            System.err.print("Ошибка обработки!\nПроверьте введённые данные.\n");
            in.close();
        }
    }    
}

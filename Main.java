import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Here we go, lab №3! To start with, enter your name in this way: Surname GivenName Patronymic:");
        String name = scanner.nextLine();

        System.out.println("Now write your age in yyyy-mm-dd format:");
        String birthday = scanner.nextLine();

        String[] nameCut = name.split(" ");
        String lastName = nameCut[0];
        String firstName = nameCut[1];
        String patronymic = nameCut[2];
        try {
            LocalDate birthDate = LocalDate.parse(birthday);
            Person person = new Person(lastName, firstName, patronymic, birthDate);
            person.printInfo();
        } catch (DateTimeException e) {
            System.out.println("Invalid date format. Please use the correct format: yyyy-mm-dd or write a correct date!");
        } catch (FutureBirthdayException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}

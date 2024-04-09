import java.time.*;

class Person {
    private  String lastName;
    private String firstName;
    private String patronym;
    private LocalDate birthDate;

    public Person (String lastName, String firstName, String patronym, LocalDate birthDate) {
        if (birthDate.isAfter(LocalDate.now())) {
            throw new FutureBirthdayException("Oh, I see, you are from future.. or, well, happy birthday^^");
        }

        this.lastName = lastName;
        this.firstName = firstName;
        this.patronym = patronym;
        this.birthDate = birthDate;
    }

    public String getGender() {
        char defLetter = patronym.charAt(patronym.length() - 1);
        return (defLetter == 'а') ? "Женский" : "Мужской";
    }

    public String getName() {
        return lastName + " " + firstName.charAt(0) + ". " + patronym.charAt(0) + ". ";
    }

    public int getAge() {
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(birthDate, curDate);
        return period.getYears();
    }

    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Gender: " + getGender());
        System.out.println("Age: " + getAge() + " y.o.");
    }
}

class FutureBirthdayException extends RuntimeException {
    public FutureBirthdayException(String message) {

        super(message);
    }
}

/*class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}*/

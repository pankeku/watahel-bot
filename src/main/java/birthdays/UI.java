package birthdays;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class UI {

    private Logic logic;


    public UI() {
        this.logic = new Logic();
    }



    public void start() {
        read();
        logic.printNames();
    }

    public Person birthdayPerson() {
            return logic.returnBirthdayPerson();
    }

    public void printSentDate() {
        System.out.println(birthdayPerson().getDateMessageSent());
    }

    public void read() {
        try (Scanner scanner = new Scanner(Paths.get("bdays"))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] parts = row.split(",");
                logic.addPersons(new Person(parts[0], new Date(Integer.valueOf(parts[1]), Integer.valueOf(parts[2]), Integer.valueOf(parts[3])), Boolean.valueOf(parts[4]), Boolean.valueOf(parts[5])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        logic.print();
    }

    public void writer(String file) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (Person person : logic.returnList()) {
                System.out.println("WRITING: " + person.getName() + " " + person.isNotice7Sent());
                writer.println(person.getName()+","+person.getBday().returnBDAYYear()+","+person.getBday().returnBDAYMonth()+","+person.getBday().returnBDAYDay()+","+person.isNotice7Sent()+","+person.isNotice1Sent());
            }
                writer.close();
            } catch(Exception e){
                e.getMessage();
            }

    }


    /*public void print() {
        System.out.println(logic);
        System.out.println("");
        logic.print();
        logic.daysDifference();
    }*/




}

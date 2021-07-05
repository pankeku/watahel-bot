package birthdays;

import java.util.ArrayList;

public class Logic {

    private ArrayList<Person> persons;

    public Logic () {
        this.persons = new ArrayList<>();
    }

    public ArrayList<Person> returnList() {
        return this.persons;
    }

    public void addPersons(Person person) {
        persons.add(person);
    }

    public void printNames() {
        for (Person person : persons) {
            System.out.println(person.getName());
        }
    }

    //days till bday
    public void daysDifference() {
        for (Person person : persons) {
            System.out.println(person.getBday().daysUntilBday());
        }
    }

    public void print() {
        persons.stream()
                .forEach(Person -> System.out.println(Person));
    }
//dabar sustoja po pirmo jubiliato; galima gal praplesti surenkant bdaypersons i lista
    public Person returnBirthdayPerson() {
        Person bdayPerson = null;
        for (Person person : persons) {
            if (person.getDaysUntilBday() <= 7 && person.getDaysUntilBday() > 0 || person.getDaysUntilBday() == 1) {
                bdayPerson = person;
                return bdayPerson;
            }
        }
        System.out.println(bdayPerson.getName());
        return bdayPerson;
    }

   /* public void resetNotices() {
        for (Person person : persons) {
            long diff = person.getBday().daysBetweenNoticeandBday();
            if (diff == 0 || diff > 7) {
                person.setSent7DaysUntil(false);
                person.setSent1DayUntil(false);
                System.out.println("Notices for " + person.getName() + " reseted. Notice date now: " + person.getDateMessageSent());
            }
        }
    }*/

    /*public void checkIfSent() {
        for (Person person: persons) {
            person.getDaysUntilBday()
        }
    }*/


}

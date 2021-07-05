package birthdays;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;

public class Date {

    private LocalDate date;
    private LocalDate dateNow;


    public Date(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
        this.dateNow = LocalDate.now();
    }

    public Date() {
        this.dateNow = LocalDate.now();

    }

    public LocalDate setDateToNow() {
        return LocalDate.now();
    }

    public int returnBDAYYear() {
        return this.date.getYear();
    }
    public int returnBDAYMonth() {
        return this.date.getMonthValue();
    }

    public String returnBDAYmonthText(){
        return this.date.getMonth().toString();
    }
    public int returnBDAYDay() {
        return this.date.getDayOfMonth();
    }

    public int returnNowYear() {
        return LocalDate.now().getYear();
    }

    public int returnNowMonth() {
        return LocalDate.now().getMonthValue();
    }

    public int returnNowDay() {
        return LocalDate.now().getDayOfMonth();
    }

    public String returnWeekDay() { return date.withYear(returnNowYear()).getDayOfWeek().toString();}

    public LocalDate getDate() {
        return date;
    }
    public LocalDate getDateNow() { return dateNow;}

    public long daysUntilBday() {
        long difference = ChronoUnit.DAYS.between(dateNow, getDate().withYear(dateNow.getYear()));

        //days till next bday;
        if (difference < 0) {
            difference = ChronoUnit.DAYS.between(dateNow, getDate().withYear(dateNow.getYear() + 1));
            return difference;
        }

      return difference;
          }

    public long daysBetweenNoticeandBday() {

        /*//days till next bday;
        if (difference < 0) {
            difference = ChronoUnit.DAYS.between(dateNow, getDate().withYear(dateNow.getYear() + 1));
            return difference;
        }*/

        return ChronoUnit.DAYS.between(dateNow, getDate().withYear(dateNow.getYear()));
    }


    public String toString() {
        return date.toString();
          }


}

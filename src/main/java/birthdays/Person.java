package birthdays;

public class Person {

    private String name;
    private Date bday;
    private long daysUntilBday;
    private boolean notice7Sent;
    private boolean notice1Sent;
    private boolean sent7DaysUntil;
    private boolean sent1DayUntil;
    private Date dateMessageSent;


    public boolean isNotice1Sent() {
        return notice1Sent;
    }

    public void setNotice1Sent(boolean notice1Sent) {
        this.notice1Sent = notice1Sent;
    }

    public int personAge() { return this.getBday().returnNowYear() - this.getBday().returnBDAYYear();}

    public void setNotice7Sent(boolean notice7Sent) {
        this.notice7Sent = notice7Sent;
    }

    public boolean isNotice7Sent() {
        return notice7Sent;
    }

    public Person (String name, Date bday, boolean notice7Sent, boolean notice1Sent) {
        this.name = name;
        this.bday = bday;
        this.daysUntilBday = bday.daysUntilBday();
        this.sent7DaysUntil = false;
        this.sent1DayUntil = false;
        this.notice7Sent = notice7Sent;
        this.notice1Sent = notice1Sent;
        this.dateMessageSent = new Date(2000,1,1);
    }

    public Date getDateMessageSent() {
        return dateMessageSent;
    }

    public void setDateMessageSent() {
        this.dateMessageSent = new Date(dateMessageSent.returnNowYear(), dateMessageSent.returnNowMonth(), dateMessageSent.returnNowDay());
    }

    public String getName() {
        return this.name;
    }

    public Date getBday() {
        return this.bday;
    }

    public long getDaysUntilBday() {
        return this.daysUntilBday;
    }

    @Override
    public String toString() {
        return "name: " + getName() + ", birthday: " + getBday() + ", days till birthday: " + getDaysUntilBday();
    }



}

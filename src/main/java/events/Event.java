package events;
//hello
//pm
import birthdays.UI;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class Event extends ListenerAdapter {
    private final JDA jda;
    private List<User> userList;
    private List<String> names;
    private UI ui;
    private TextEditor textEditor;

    public Event(JDA jda) {
        this.jda = jda;
        this.userList = new ArrayList<>();
        this.names = new ArrayList<>();
        this.ui = new UI();
        this.textEditor = new TextEditor();
        //this.sent7DaysBeforeBday = false;
    }



    public void onReady(@Nonnull ReadyEvent e) {

        //kaip cia geriausiai padaryt butu??
        try {
            ui.start();
            getMembers();
            sendPM(isBdayBoyInServer(getName()));
            ui.writer("bdays");
        } catch (NullPointerException error) {
            System.out.println("No bdays");
        }
    }

    @Override
    public void onPrivateMessageReceived(final PrivateMessageReceivedEvent event) {
        System.out.println("Received message from :");
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase("!watahel")) {

            TextChannel textChannel = event.getJDA().getTextChannelsByName("bendras",true).get(0);
                    //event.getJDA().getTextChannelsByName("test", true).get(0);

            textChannel.sendMessage("watahel " + args[1] + "??").queue();
            }
        }


    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] args = e.getMessage().getContentRaw().split(" ");
        String name = e.getMember().getUser().getName(); //Get the name of the user who sent the message
        if (args[0].equalsIgnoreCase("!info")) {
                e.getMember().getUser().openPrivateChannel().complete().sendMessage("laba diena, aš esu botas, kol kas siuntinėju priminimus apie artėjančius gimtadienius. \n \nDar moku:\n- !watahel <vardas/zodis> - parašius man PM su šia komanda pawatahelinsiu nurodytą objektą #bendras kanale. \n \nArtimiausioj ateity Linas planuoja pridėti funkcijas: 1) kad priminčiau pirmadieniais apie muzikos pildymą, " +
                        "2) kaupčiau siūlomus pažiūrėti filmus #kapažiūrėt kanale ir išlistinčiau juos, kai reikia, vienoje vietoje, 3) jei Spotify API leis, pranešti #music kanale tada, kai kas nors papildys Draugeliūzų melodijų playlistą. \n \nJei turite pasiūlymų, maloniai laukiam (rašykit Linui arba viešai, nes neloginu PMs)").queue();
        }
    }

    public String getName() {
        return ui.birthdayPerson().getName();
    }

//paupdeitint kad pildytu servo narius tik po to kai kazkas prisijungia, o siaip juos laikyt txt faile;
    //istraukia serverio narius ir sudeda i User userList

    public void getMembers() {
        List<Guild> list = jda.getGuildsByName("Draugeliūzai", true);
        Guild channel = null;
        for (Guild guild : list) {
            channel = guild;
        }
        for (Member member : channel.getMembers()) {
            User user = member.getUser();
            if (!userList.contains(user)) {
                userList.add(user);
            }
        }
    }

    //lygina saraso vardus su jubiliatu
    public User isBdayBoyInServer(String name) {

        User returningUser = null;
        for (User user : userList) {
            if (user.getName().equals(name)) {
                returningUser = user;
            }
        }
        return returningUser;
    }

    String message7() {
        return "Artėja gimtadienis! " + textEditor.naudininkas(ui.birthdayPerson().getName()) + " " + textEditor.translate(ui.birthdayPerson().getBday().returnBDAYmonthText()) + " " + ui.birthdayPerson().getBday().returnBDAYDay()+" d. ("+
                textEditor.savaitesDiena(ui.birthdayPerson().getBday().returnWeekDay()) + ") sukanka " + ui.birthdayPerson().personAge() + " " + textEditor.metuLinksnis(ui.birthdayPerson().personAge()) + "!"; }

    String message1() {
        return "Rytoj (" + textEditor.translate(ui.birthdayPerson().getBday().returnBDAYmonthText()) + " " + ui.birthdayPerson().getBday().returnBDAYDay()+" d., " + textEditor.savaitesDiena(ui.birthdayPerson().getBday().returnWeekDay()) + ") " + textEditor.kilmininkas(ui.birthdayPerson().getName()) + " gimtadienis!" ;
    }


    //sends to all members except user in method parameter and bot itself
    public void sendPM(User notToSendToUser) {

    long daysUntilBday = ui.birthdayPerson().getDaysUntilBday();

    //message if from 7 to 2 days are left till bday
        if ( (daysUntilBday <= 7 && daysUntilBday > 1 && !ui.birthdayPerson().isNotice7Sent())) {

            if (!(notToSendToUser == null)) {
                System.out.println("!!! Sending 7 day notices !!!");
                for (User user : userList) {
                    if (!user.equals(notToSendToUser) && !user.isBot()) {
                        user.openPrivateChannel().complete().sendMessage(message7()).queue();
                        System.out.println("Message sent to " + user.getName());
                    }
                }

                    ui.birthdayPerson().setNotice7Sent(true);


                bdayPersonStatus();

            } else {
                System.out.println("BDAY BOY (" + notToSendToUser.getName() + ") NOT IN THE SERVER");
            }
        }
        //message with 1 day left
        if ( (daysUntilBday == 1 && !ui.birthdayPerson().isNotice1Sent())) {
            if (!(notToSendToUser == null)) {
                System.out.println("!!! Sending 1 day notices !!!");

                for (User user : userList) {
                    if (!user.equals(notToSendToUser) && !user.isBot()) {
                        user.openPrivateChannel().complete().sendMessage(message1()).queue();
                        System.out.println("Message sent to " + user.getName());
                    }
                }

                ui.birthdayPerson().setNotice1Sent(true);
                bdayPersonStatus();

            } else {
                System.out.println("BDAY BOY (" + notToSendToUser.getName() + ") NOT IN THE SERVER");
            }

        }
        }

    public void bdayPersonStatus() {
        System.out.println("BDAY: " + ui.birthdayPerson().getName() + " " + ui.birthdayPerson().getBday() + "until bday: " + ui.birthdayPerson().getDaysUntilBday() + "notice sent:" + ui.birthdayPerson().isNotice7Sent());
    }

}
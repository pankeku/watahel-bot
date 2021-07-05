package events;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TextEditor {

    private Map<String, String> names;
    private Map<String, String> kilmininkas;
    private Map<String, String> monthsTranslated;
    private Map<String, String> weekDays;


    //yra failas, kuriame surasyti 1. naudininko linksniai vardams 2. menesiai is ENG
    // if (moteriski vardai) pronoun - "ji"/ else { "jis"

    public TextEditor() {
        this.names = new HashMap<>();
        names.put("Linas", "Linui");
        names.put("monikenzo", "Monikai");
        names.put("Neda", "Nedai");
        names.put("Adomas", "Adomui");
        names.put("Arūnėlė", "Jorūnei");
        names.put("ignacio", "Ignui");
        names.put("Karolis", "Karoliui");
        names.put("klevas", "Billui Cosby (niekas įdomaus daugiau negimė tą dieną, sorry)");
        names.put("Laurita", "Lauritai");
        names.put("nebasa", "Rasai");
        names.put("Povilas", "Povilui");
        names.put("ramintukse", "Ramintai");
        names.put("Rokas", "Rokui");
        names.put("rutami", "Rūtai");
        names.put("simas", "Simui");
        names.put("Skaiste", "Skaistei");
        names.put("Astronauc", "Laurynui");
        names.put("Karalius Mindaugas", "Karaliui Mindaugui");

        this.kilmininkas = new HashMap<>();
        kilmininkas.put("Linas", "Lino");
        kilmininkas.put("monikenzo", "Monikos");
        kilmininkas.put("Neda", "Nedos");
        kilmininkas.put("Adomas", "Adomo");
        kilmininkas.put("Arūnėlė", "Jorūnės");
        kilmininkas.put("ignacio", "Igno");
        kilmininkas.put("Karolis", "Karolio");
        kilmininkas.put("klevas", "Billo Cosbio (niekas įdomaus daugiau negimė tą dieną, sorry)");
        kilmininkas.put("Laurita", "Lauritos");
        kilmininkas.put("nebasa", "Rasos");
        kilmininkas.put("Povilas", "Povilo");
        kilmininkas.put("ramintukse", "Ramintis");
        kilmininkas.put("Rokas", "Roki");
        kilmininkas.put("rutami", "Rūtos");
        kilmininkas.put("simas", "Simo");
        kilmininkas.put("Skaiste", "Skaist4s");
        kilmininkas.put("Astronauc", "Lauryno");
        kilmininkas.put("Karalius Mindaugas", "Karaliaus Mindaugo");

        this.monthsTranslated = new HashMap<>();
        monthsTranslated.put("January", "sausio");
        monthsTranslated.put("February", "Monikos");
        monthsTranslated.put("March", "kovo");
        monthsTranslated.put("April", "balandžio");
        monthsTranslated.put("May", "gegužės");
        monthsTranslated.put("June", "birželio");
        monthsTranslated.put("July", "liepos");
        monthsTranslated.put("August", "rugpjūčio");
        monthsTranslated.put("September", "rugsėjo");
        monthsTranslated.put("October", "spalio");
        monthsTranslated.put("November", "lapkričio");
        monthsTranslated.put("December", "gruodžio");

        this.weekDays = new HashMap<>();
        weekDays.put("Monday", "pirmadienį");
        weekDays.put("Tuesday", "antradienį");
        weekDays.put("Wednesday", "trečiadienį");
        weekDays.put("Thursday", "ketvirtadienį");
        weekDays.put("Friday", "penktadienį");
        weekDays.put("Saturday", "šeštadienį");
        weekDays.put("Sunday", "sekmadienį");


    }


    public String naudininkas(String string) {

        String text = "error in TextEditor naudininkas()";
        for (String name : names.keySet()) {
            if (name.equalsIgnoreCase(string)) {
                text = names.get(name);
            }
        }
        return text;
    }

    public String kilmininkas(String string) {

        String text = "error in TextEditor naudininkas()";
        for (String name : kilmininkas.keySet()) {
            if (name.equalsIgnoreCase(string)) {
                text = kilmininkas.get(name);
            }
        }
        return text;
    }

    public String translate(String string) {
        String text = "error in TextEditor translate()";
        for (String month : monthsTranslated.keySet()) {
            if (month.equalsIgnoreCase(string)) {
                text = monthsTranslated.get(month);
            }
        }
        return text;
    }

    //galima gal per char paskutini int simboli tikrint?
    public String metuLinksnis(int age) {
        if (age == 30) {
            return "metų";
        } else
            return "metai";
    }


    public String savaitesDiena(String string) {
        String text = "error in TextEditor savaitesDiena()";
        for (String day : weekDays.keySet()) {
            if (day.equalsIgnoreCase(string)) {
                text = weekDays.get(day);
            }
        }
        return text;
    }
}
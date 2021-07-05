package birthdays;

import java.util.ArrayList;

public class BDAY {
    //i faila bdays "Vardas,metai,menuo,diena" is jo suloadina ir lygina;
//vardas ir bday, Date class comparina, jei iki gimses 7 arba 1 diena,
    //siuncia zinute visiems memberiams iskyrus jubiliatui
    //galetu checkint kiek dienu liko isijungus; suejus naujai dienai nuo paskutinio prisijungimo;


    private String name;
    private Date bday;


    public BDAY(String name, Date bday) {

        this.name = name;
        this.bday = bday;
    }

    public Date getBday() {
        return bday;
    }

@Override
    public String toString() {
        return name + " " + bday;
    }








}

package domain;

import java.text.ParseException;
import java.util.Date;

public class Accounts {
    private Date dateIn;
    private Date dateOut;
    private int volume;

    public Accounts(Date dateIn, Date dateOut, int volume) throws ParseException {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.volume = volume;
    }

    public void setDateIn(Date dateIn){
        this.dateIn = dateIn;
    }

    public void setDateOut(Date dateOut){
        this.dateOut = dateOut;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }
}

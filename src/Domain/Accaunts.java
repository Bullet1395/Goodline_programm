package Domain;

import java.util.Date;

public class Accaunts {
    private Date dateIn;
    private Date dateOut;
    private int volume;

    public Accaunts(Date dateIn, Date dateOut, int volume){
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

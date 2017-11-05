package domain;

import java.time.LocalDate;

public class Accounts {
    private LocalDate dateIn;
    private LocalDate dateOut;
    private Integer volume;

    public Accounts(LocalDate dateIn, LocalDate dateOut, Integer volume) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.volume = volume;
    }

    public void setDateIn(LocalDate dateIn){
        this.dateIn = dateIn;
    }

    public void setDateOut(LocalDate dateOut){
        this.dateOut = dateOut;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }
}

package domain;

import java.time.LocalDate;

public class Accounts {
    private String login;
    private LocalDate dateIn;
    private LocalDate dateOut;
    private Integer volume;

    public Accounts() {
        this.dateIn = LocalDate.parse("0000-00-00");
        this.dateOut = LocalDate.parse("0000-00-00");
        this.volume = Integer.parseInt("000");
        this.login = "Empty_User_Test";
    }

    public Accounts(LocalDate dateIn, LocalDate dateOut, Integer volume, String login) {
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.volume = volume;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}

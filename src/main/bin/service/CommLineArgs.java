package main.bin.service;

public class CommLineArgs {
    private String login;
    private String password;
    private String role;
    private String path;
    private String dateIn;
    private String dateOut;
    private String volume;

    public String getLogin() {
        return login;
    }

    CommLineArgs withLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    CommLineArgs withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    CommLineArgs withRole(String role) {
        this.role = role;
        return this;
    }

    public String getPath() {
        return path;
    }

    CommLineArgs withPath(String path) {
        this.path = path;
        return this;
    }

    public String getDateIn() {
        return dateIn;
    }

    CommLineArgs withDateIn(String dateIn) {
        this.dateIn = dateIn;
        return this;
    }

    public String getDateOut() {
        return dateOut;
    }

    CommLineArgs withDateOut(String dateOut) {
        this.dateOut = dateOut;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    CommLineArgs withVolume(String volume) {
        this.volume = volume;
        return this;
    }
}

package bin.domain;

import bin.domain.enums.Roles;

public class Resources {
    private String user;
    private Roles role;
    private String path;

    public Resources(String user, Roles role, String path) {
        this.user = user;
        this.role = role;
        this.path = path;
    }

    public String getUser() {
        return this.user;
    }

    public String getPath() {
        return this.path;
    }

    public Roles getRole() {
        return this.role;
    }
}

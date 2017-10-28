package Library_classes;

import Enums.Roles;

public class Resources {
    private String user;
    private Enum<Roles> role;
    private String path;

    public Resources(String user, Enum<Roles> role, String path)
    {
        this.user = user;
        this.role = role;
        this.path = path;
    }

    String getUser(){
        return this.user;
    }

    String getPath(){
        return this.path;
    }

    Enum<Roles> getRole(){
        return this.role;
    }
}

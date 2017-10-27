package Library_classes;

import Enums.Roles;

public class Resources {
    private String User;
    private Enum<Roles> Role;
    private String Path;

    public Resources(String user, Enum<Roles> role, String path)
    {
        this.User = user;
        this.Role = role;
        this.Path = path;
    }

    String getUser(){
        return this.User;
    }

    public void SetUser(String user){
        this.User = user;
    }

    String getPath(){
        return this.Path;
    }

    public void SetPath(String path){
        this.Path = path;
    }

    Enum<Roles> getRole(){
        return this.Role;
    }

    public void SetRole(Enum<Roles> role){
        this.Role = role;
    }
}

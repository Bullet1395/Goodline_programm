package Library_classes;

import Enums.Roles;

import java.util.List;

public class Resources {
    private String User;
    private Enum<Roles> Role;
    private String Path;

    public Resources(String User, Enum<Roles> Role, String Path)
    {
        this.User = User;
        this.Role = Role;
        this.Path = Path;
    }

    public String GetUser(){
        return this.User;
    }

    public void SetUser(String User){
        this.User = User;
    }

    public String GetPath(){
        return this.Path;
    }

    public void SetPath(String Path){
        this.Path = Path;
    }

    public Enum<Roles> GetRole(){
        return this.Role;
    }

    public void SetRole(Enum<Roles> Role){
        this.Role = Role;
    }
}

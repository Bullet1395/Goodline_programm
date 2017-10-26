package Library_classes;

import Enums.Roles;

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

    String GetUser(){
        return this.User;
    }

    public void SetUser(String User){
        this.User = User;
    }

    String GetPath(){
        return this.Path;
    }

    public void SetPath(String Path){
        this.Path = Path;
    }

    Enum<Roles> GetRole(){
        return this.Role;
    }

    public void SetRole(Enum<Roles> Role){
        this.Role = Role;
    }
}

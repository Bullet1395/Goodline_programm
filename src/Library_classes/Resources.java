package Library_classes;

import Enums.Roles;

public class Resources {
    private String User;
    private Enum<Roles> Role;
    private String Path;

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

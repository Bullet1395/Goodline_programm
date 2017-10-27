package Library_classes;

import Enums.Roles;

public class Resources {
    private String mUser;
    private Enum<Roles> mRole;
    private String mPath;

    public Resources(String User, Enum<Roles> Role, String Path)
    {
        this.mUser = User;
        this.mRole = Role;
        this.mPath = Path;
    }

    String getUser(){
        return this.mUser;
    }

    public void SetUser(String User){
        this.mUser = User;
    }

    String getPath(){
        return this.mPath;
    }

    public void SetPath(String Path){
        this.mPath = Path;
    }

    Enum<Roles> getRole(){
        return this.mRole;
    }

    public void SetRole(Enum<Roles> Role){
        this.mRole = Role;
    }
}

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

    public static void CheckParam(Users user, List<Resources> resources, String Role, String Path) {
        for (Resources res : resources) {
            if (user.GetLogin().equals(res.GetUser())) {
                for (Roles r : Roles.values()) {
                    if (r.name().equals(Role)) {
                        if (Path.equals(res.GetPath())) {
                            if (Roles.valueOf(Role) == res.GetRole()) {
                                System.exit(0);
                            } else System.exit(4);
                        } else System.exit(4);
                    } if (Roles.valueOf(r.name()).ordinal() == Roles.values().length-1) System.exit(3);
                }
            } else if (resources.indexOf(res) == resources.size()) System.exit(1);
        }
    }

    public void CheckPathRole(String Path){

    }
}

package Library_classes;

import Enums.Roles;

import java.util.List;

public class Authorization {

    public static void CheckParam(Users user, List<Resources> resources, String Role, String Path) {
        int iter = 0;
        int iter2 = CountInUser(resources, user.GetLogin());
        for (Resources res : resources) {
            if (user.GetLogin().equals(res.GetUser())) {
                iter++;
                if (CheckInRole(Role)) {
                    if (CheckPathRole(Path, res)) {
                        if (Roles.valueOf(Role) == res.GetRole()) {
                            System.exit(0);
                        } else if (iter == iter2) System.exit(4);
                    } else if (iter == iter2) System.exit(4);
                }
            } else if (resources.indexOf(res) == resources.size()) System.exit(1);
        }
    }

    private static boolean CheckInRole(String Role) {
        for (Roles r : Roles.values()) {
            if (r.name().equals(Role)) {
                return true;
                }else if (Roles.valueOf(r.name()).ordinal() == Roles.values().length-1) System.exit(3);
            }
        return false;
    }

    private static int CountInUser(List<Resources> resources, String User) {
        int count_us = 0;
        for (Resources res: resources) {
            if (res.GetUser().equals(User))
                count_us ++;
        }
        return count_us;
    }

    private static boolean CheckPathRole(String Path, Resources resource){
        if (Path.length() >= resource.GetPath().length()) {
            String p1 = resource.GetPath();
            String p2 = Path.substring(0, resource.GetPath().length());
            return p1.equals((p2));
        }
        return false;
    }
}

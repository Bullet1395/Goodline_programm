package Library_classes;

import Enums.Roles;

import java.util.List;

public class Authorization {

    public static void sCheckParam(Users user, List<Resources> resources, String Role, String Path) {
        int miter = 0;
        int miter2 = sCountInUser(resources, user.getLogin());
        for (Resources res : resources) {
            if (user.getLogin().equals(res.getUser())) {
                miter++;
                    if (isCheckInRole(Role)) {
                    if (isCheckPathRole(Path, res)) {
                        if (Roles.valueOf(Role) == res.getRole()) {
                            return;
                        } else if (miter == miter2) System.exit(4);
                    } else if (miter == miter2) System.exit(4);
                }
            } else if (resources.indexOf(res) == resources.size()) System.exit(1);
        }
    }

    private static boolean isCheckInRole(String Role) {
        for (Roles r : Roles.values()) {
            if (r.name().equals(Role)) {
                return true;
                }else if (Roles.valueOf(r.name()).ordinal() == Roles.values().length-1) System.exit(3);
            }
        return false;
    }

    private static int sCountInUser(List<Resources> resources, String User) {
        int count_us = 0;
        for (Resources res: resources) {
            if (res.getUser().equals(User))
                count_us ++;
        }
        return count_us;
    }

    private static boolean isCheckPathRole(String Path, Resources resource){
        if (Path.length() >= resource.getPath().length()) {
            String p1 = resource.getPath();
            String p2 = Path.substring(0, resource.getPath().length());
            return p1.equals((p2));
        }
        return false;
    }
}

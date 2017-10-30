package service;

import domain.Resources;
import domain.Users;
import domain.enums.Roles;

import java.util.List;

public class Authorization {
    public static void checkParam(Users user, List<Resources> resources, String role, String path) {
        int iter = 0;
        int iter2 = countInUser(resources, user.getLogin());
        for (Resources res : resources) {
            if (user.getLogin().equals(res.getUser())) {
                iter++;
                if (isCheckAccess(role, path, res, iter, iter2)){
                    break;
                }
            } else if (resources.indexOf(res) == resources.size()) {
                System.exit(1);
            }
        }
    }

    private static boolean isCheckAccess(String role, String path, Resources res, int iter, int iter2){
        if (isCheckInRole(role)) {
            if (isCheckPathRole(path, res)) {
                if (isCheckRoleToResource(role, res, iter, iter2)){
                    return true;
                }
            } else if (iter == iter2) {
                System.exit(4);
            }
        }
        return false;
    }

    private static boolean isCheckInRole(String role) {
        for (Roles r : Roles.values()) {
            if (r.name().equals(role)) {
                return true;
            } else if (Roles.valueOf(r.name()).ordinal() == Roles.values().length - 1) {
                System.exit(3);
            }
        }
        return false;
    }

    private static boolean isCheckRoleToResource(String role, Resources res, int iter, int iter2){
        if (Roles.valueOf(role) == res.getRole()) {
            return true;
        } else if (iter == iter2) {
            System.exit(4);
        }
        return false;
    }

    private static int countInUser(List<Resources> resources, String user) {
        int count_us = 0;
        for (Resources res : resources) {
            if (res.getUser().equals(user)) {
                count_us++;
            }
        }
        return count_us;
    }

    private static boolean isCheckPathRole(String path, Resources resource) {
        if (path.length() >= resource.getPath().length()) {
            String p1 = resource.getPath();
            String p2 = path.substring(0, resource.getPath().length());
            return p1.equals((p2));
        }
        return false;
    }
}

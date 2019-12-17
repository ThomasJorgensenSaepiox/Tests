package tester;

public class testingVariablesPile {
   public enum months3Letter {
        JAN, FEB,MAR,APR,MAY,JUN,JUL,AUG,SEB,OCT,NOV,DEC
    }
    public enum months{JANUARY,FEBRUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER

    }

    private static String[] list1;
    private static String[] list2;
    private static String[] list3;
    private static String host = "http://localhost:5000/";
    private static String adminlogin = "tj@saepiox.com";
    private static String adminPass="pass";

    public static void setList1(String[] list1) {
        testingVariablesPile.list1 = list1;
    }

    public static void setList2(String[] list2) {
        testingVariablesPile.list2 = list2;
    }

    public static void setList3(String[] list3) {
        testingVariablesPile.list3 = list3;
    }

    public static String[] getList1() {
        return list1;
    }


    public static String[] getList2() {
        return list2;
    }

    public static String[] getList3() {
        return list3;
    }

    public static String getAdminlogin(){
        return adminlogin;
    }

    public static void setAdminPass(String adminPass) {
        testingVariablesPile.adminPass = adminPass;
    }

    public static void setAdminlogin(String adminlogin) {
        testingVariablesPile.adminlogin = adminlogin;
    }

    public static String getAdminPass() {
        return adminPass;
    }

    public static String getHost() {
        return host;
    }
    public static void setHost(String toSet){

        testingVariablesPile.host = toSet;
    }
}

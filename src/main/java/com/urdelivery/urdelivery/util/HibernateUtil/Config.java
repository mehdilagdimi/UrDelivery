package com.urdelivery.urdelivery.util.HibernateUtil;


import io.github.cdimascio.dotenv.Dotenv;



public final class Config {
    private static Dotenv dotenv;
    private  static String DRIVER;
    private  static String DIALECT;
    private  static String URL;
    private  static String USER;
    private  static String PASSWORD;

    private static String DBNAME;

    static {
//        try{
        dotenv = Dotenv.configure().ignoreIfMissing().load();
        Config.setDIALECT(dotenv.get("DIALECT"));
        Config.setDRIVER(dotenv.get("DRIVER"));
        Config.setURL(dotenv.get("URL"));
        Config.setUSER(dotenv.get("USER"));
        Config.setPASSWORD(dotenv.get("PASSW"));
        System.out.println(" URL " + dotenv.get("URL"));
    }

    public static String getDIALECT() {
        return DIALECT;
    }

    public static void setDIALECT(String DIALECT) {
        Config.DIALECT = DIALECT;
    }

    public static String getDRIVER() {
        return DRIVER;
    }

    public static void setDRIVER(String DRIVER) {
        Config.DRIVER = DRIVER;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String URL) {
        Config.URL = URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static void setUSER(String USER) {
        Config.USER = USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static void setPASSWORD(String PASSWORD) {
        Config.PASSWORD = PASSWORD;
    }
}

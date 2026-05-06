package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect
{
    public static Connection getcon() throws Exception
    {
        Class.forName(Dbinfo.driver);
        return DriverManager.getConnection(
                Dbinfo.url,
                Dbinfo.Uname,
                Dbinfo.pwd);
    }
}
package com.example.rest.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {

        public Connection getAcceso() throws Exception {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	//Connection conn = DriverManager.getConnection("jdbc:mysql://node226092-env-7321910.j.layershift.co.uk/rest?serverTimezone=UTC","root","AKOytr01161");
        	
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rest?serverTimezone=UTC","root","msql");
           	
        return conn;
    }
}

package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

        private static String url= "jdbc:mariadb://localhost:3306/db_empleados";
        private static String user= "root";
        private static String password = "";
        private static Connection conexion=null;

        public static Connection getConexion(){
            System.out.println("exito");
            if(conexion==null){
                try{
                    conexion =  DriverManager.getConnection(url, user, password);
                    System.out.println("Conexion exitosa");
                    System.out.println(conexion.getCatalog());
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
            return conexion;
        }

}

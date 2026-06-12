package vallegrande.edu.pe.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://54.90.72.9:3306/expediciones";

    private static final String USER = "admin";
    private static final String PASSWORD = "Expedicion2026";

    public static Connection getConexion() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexión exitosa");

            return conexion;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
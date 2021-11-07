package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.*;

public class Conexion {

    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tamtumbd", "root", "");
        } catch (Exception e) {
            System.err.println("error" + e.getMessage());
        }
    }

    public static void main(String[] args) {

        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {

            st = cn.con.createStatement();
            rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("Nombres") + " " + rs.getString("Apellidos"));
            System.out.println("Conexión Exitosa");
            }

            cn.con.close();

        } catch (Exception e) {

        }

    }

}

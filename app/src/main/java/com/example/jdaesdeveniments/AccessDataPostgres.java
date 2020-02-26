package com.example.jdaesdeveniments;

import android.annotation.SuppressLint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AccessDataPostgres {

    @SuppressLint("StaticFieldLeak")
    private static AccessDataPostgres accessDataPostgres;

    private Connection conn;
    private String user = "ada";
    private String pwd = "lovelace";
    private String url = "jdbc:postgresql://192.168.0.22:5432/esdeveniments";

    private AccessDataPostgres(){

    }

    public static AccessDataPostgres getInstance(){
        if(accessDataPostgres == null){
            return new AccessDataPostgres();
        }
        return accessDataPostgres;
    }

    // Método para insertar datos
    public void insertInPostgres(final String nombre, final Date fecha,
                                 final String lugar, final String mail, final String sala,
                                 final String descripcion, final int precio, final int aforo) {

        Thread hiloPostgres = new Thread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");

                    conn = DriverManager.getConnection(url, user, pwd);

                    Statement st = conn.createStatement();

                    st.executeUpdate("Insert into EventDetail values('" + nombre + "','" +
                            fecha + "','" + lugar + "','" + mail + "','" + sala + "','" + descripcion + "','" + precio + "', " + aforo + ")");
                    conn.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
        hiloPostgres.start();
    }
/*
    // Método para borrar datos
    public void deleteInPostgres (final String nombre, final Date fecha,
                                  final String lugar, final String mail, final String sala,
                                  final String descripcion, final int precio, final int aforo){

        Thread hiloPostgress = new Thread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");

                    conn = DriverManager.getConnection(url, user, pwd);

                    Statement st = conn.createStatement();

                    st.executeUpdate("Delete from Pilotos where nombre ='" + nombre + "'");
                    conn.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
        hiloPostgress.start();
    }

    // Método para actualizar datos
    public void updateInPostgres (final String nombre, final Date fecha,
                                  final String lugar, final String mail, final String sala,
                                  final String descripcion, final int precio, final int aforo){

        Thread hiloPostgresss = new Thread() {
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");

                    conn = DriverManager.getConnection(url, user, pwd);

                    String update = "Update Pilotos set escuderia=? where nombre=?)";

                    PreparedStatement ps = conn.prepareStatement(update);
                    ps.setString(1, escuderia); // Parametro del nuevo
                    ps.setString(2, nombre); // Parametro de búsqueda del antiguo
                    ps.executeUpdate();

                    conn.close();
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
        hiloPostgresss.start();
    }

    // Método para buscar datos
    public void getPilotsPostgres() {

        Thread hiloPostgressss = new Thread() {
            @Override
            public void run() {
                try {

                    Class.forName("org.postgresql.Driver");

                    conn = DriverManager.getConnection(url, user, pwd);

                    Statement st = conn.createStatement();

                    String select = ("Select * from Pilotos");

                    ResultSet rs = st.executeQuery(select);

                    while (rs.next()) {
                        Piloto piloto = new Piloto();
                        piloto.setNombre(rs.getString("nombre"));
                        piloto.setEscuderia(rs.getString("escuderia"));
                        piloto.setNacionalidad(rs.getString("nacionalidad"));
                        piloto.setDescripcion(rs.getString("descripcion"));
                    }

                    rs.close();
                    conn.close();

                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        };

        hiloPostgressss.start();

    }*/
}

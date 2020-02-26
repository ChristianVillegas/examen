package com.example.jdaesdeveniments;

import com.example.jdaesdeveniments.Model.Esdeveniment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultsPostgres implements Runnable {

        private List<Esdeveniment> esdeveniments;

        private Connection conn;
        private String user = "ada";
        private String pwd = "lovelace";
        private String url = "jdbc:postgresql://192.168.0.22:5432/esdeveniments";

        @Override
        public void run() {
            try {
                List<Esdeveniment> catchPilotos = new ArrayList<>();

                Class.forName("org.postgresql.Driver");

                conn = DriverManager.getConnection(url, user, pwd);

                Statement st = conn.createStatement();

                String select = ("Select * from EventDetail");

                ResultSet rs = st.executeQuery(select);


                while (rs.next()) {
                    Esdeveniment esdeveniment = new Esdeveniment();
                    esdeveniment.setNombre(rs.getString("nombre"));
                    esdeveniment.setFecha(rs.getDate("fecha"));
                    esdeveniment.setLugar(rs.getString("lugar"));
                    esdeveniment.setMail(rs.getString("mail"));
                    esdeveniment.setSala(rs.getString("sala"));
                    esdeveniment.setDescripcion(rs.getString("descripcion"));
                    esdeveniment.setPrecio(rs.getInt("precio"));
                    esdeveniment.setAforo(rs.getInt("aforo"));
                    catchPilotos.add(esdeveniment);
                }

                esdeveniments = catchPilotos;
                rs.close();
                conn.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public List<Esdeveniment> getEsdeveniments(){
            return esdeveniments;
        }
    }


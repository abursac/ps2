/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import domen.Laborant;
import domen.Laboratorija;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar
 */
public class DBBroker 
{
    Connection konekcija;
    
    public void ucitajDrajver()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void otvoriKonekciju()
    {
        try {
            konekcija = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/prosoftsept2020", "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void zatvoriKonekciju()
    {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void commit()
    {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void rollback()
    {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Laborant> vratiLaborante() 
    {
        ArrayList<Laborant> lista = new ArrayList<>();
        String sql = "SELECT * FROM laborant l JOIN laboratorija lab ON l.LaboratorijaID = lab.LaboratorijaID";
        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next())
            {
                Laboratorija lab = new Laboratorija(rs.getInt("lab.LaboratorijaID"), rs.getString("lab.Naziv"), rs.getInt("lab.DnevniKapacitetTestova"), rs.getString("lab.Grad"));
                Laborant l = new Laborant(rs.getInt("l.LaborantID"), rs.getString("l.Ime"), rs.getString("l.Prezime"), rs.getString("l.KorisnickoIme"), rs.getString("l.Lozinka"), lab);
                lista.add(l);
            }
            s.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
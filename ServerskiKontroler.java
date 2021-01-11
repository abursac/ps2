/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import domen.Laborant;
import java.util.ArrayList;

/**
 *
 * @author Aleksandar
 */
public class ServerskiKontroler 
{
    private static ServerskiKontroler instance;
    DBBroker db;

    private ServerskiKontroler() 
    {
        db = new DBBroker();
    }
    
    public static ServerskiKontroler getInstance()
    {
        if(instance == null)
            instance = new ServerskiKontroler();
        return instance;
    }

    public ArrayList<Laborant> vratiLaborante() 
    {
        ArrayList<Laborant> lista = new ArrayList<>();
        db.otvoriKonekciju();
        lista = db.vratiLaborante();
        db.zatvoriKonekciju();
        return lista;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import niti.ObradaServerskihOdgovora;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Aleksandar
 */
public class Komunikacija 
{
    private static Komunikacija instance;
    Socket soket;

    private Komunikacija() 
    {
        try {
            soket = new Socket("localhost", 9000);
            ObradaServerskihOdgovora oso = new ObradaServerskihOdgovora();
            oso.start();
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Komunikacija getInstance()
    {
        if(instance == null)
            instance = new Komunikacija();
        return instance;
    }
    
    public void posaljiZahtev(KlijentskiZahtev kz)
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ServerskiOdgovor primiOdgovor()
    {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }
}

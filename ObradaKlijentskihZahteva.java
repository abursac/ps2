/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import domen.Laborant;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.Konstante;
import logika.ServerskiKontroler;

/**
 *
 * @author Aleksandar
 */
public class ObradaKlijentskihZahteva extends Thread
{
    Socket klijentskiSocket;
    boolean kraj = false;

    public ObradaKlijentskihZahteva(Socket klijentskiSocket) {
        this.klijentskiSocket = klijentskiSocket;
    }

    @Override
    public void run() 
    {
        while(!kraj)
        {
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            switch(kz.getOperacija())
            {
                case Konstante.LOGIN:
                   so.setOperacija(Konstante.LOGIN);
                   Laborant laborantOdKlijenta = (Laborant) kz.getArgument();
                   if(ServerskiKontroler.getInstance().vratiLaborante().contains(laborantOdKlijenta))
                   {
                       so.setOdgovor(true);
                   }
                   else
                   {
                       so.setOdgovor(false);
                   }
            }
            posaljiOdgovor(so);
        }
    }

    private KlijentskiZahtev primiZahtev() 
    {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(klijentskiSocket.getInputStream());
            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kz;
    }

    private void posaljiOdgovor(ServerskiOdgovor so)
    {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(klijentskiSocket.getOutputStream());
            oos.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

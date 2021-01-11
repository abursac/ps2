/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aleksandar
 */
public class PokretanjeServera extends Thread
{

    @Override
    public void run() 
    {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Waiting for connection...");
            while(true)
            {
                Socket s = ss.accept();
                System.out.println("Client connected.");
                ObradaKlijentskihZahteva okz = new ObradaKlijentskihZahteva(s);
                okz.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

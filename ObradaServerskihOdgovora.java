/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import koms.Komunikacija;
import konstante.Konstante;
import logika.KlijentskiKontroler;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Aleksandar
 */
public class ObradaServerskihOdgovora extends Thread
{
    boolean kraj = false;

    @Override
    public void run() 
    {
        while(!kraj)
        {
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            switch(so.getOperacija())
            {
                case Konstante.LOGIN:
                    boolean uspesno = (boolean) so.getOdgovor();
                    KlijentskiKontroler.getInstance().izvrsiLogovanje(uspesno);
                    break;
                default:
                    break;
            }
        }
    }
    
    
}

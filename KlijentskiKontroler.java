/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Laborant;
import forme.GlavnaForma;
import forme.LoginForma;

/**
 *
 * @author Aleksandar
 */
public class KlijentskiKontroler 
{
    private static KlijentskiKontroler instance;
    private LoginForma lf;
    private GlavnaForma gf;
    private Laborant l;

    private KlijentskiKontroler() {
    }
    
    public static KlijentskiKontroler getInstance()
    {
        if(instance == null)
            instance = new KlijentskiKontroler();
        return instance;
    }

    public LoginForma getLf() {
        return lf;
    }

    public void setLf(LoginForma lf) {
        this.lf = lf;
    }

    public GlavnaForma getGf() {
        return gf;
    }

    public void setGf(GlavnaForma gf) {
        this.gf = gf;
    }

    public Laborant getL() {
        return l;
    }

    public void setL(Laborant l) {
        this.l = l;
    }
    
    public void izvrsiLogovanje(boolean uspesno)
    {
        if(uspesno)
        {
            lf.setVisible(false);
            gf = new GlavnaForma();
            gf.setVisible(true);
            
        }
        else
        {
            lf.setNeuspesnoLogovanje();
        }
    }
}

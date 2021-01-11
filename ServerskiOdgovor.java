/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Aleksandar
 */
public class ServerskiOdgovor implements Serializable
{
    private Object odgovor;
    private String poruka;
    private int operacija;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, String poruka, int operacija) {
        this.odgovor = odgovor;
        this.poruka = poruka;
        this.operacija = operacija;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    
    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }
    
    
}

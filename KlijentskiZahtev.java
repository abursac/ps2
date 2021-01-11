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
public class KlijentskiZahtev implements Serializable
{
    private int operacija;
    private Object argument;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, Object argument) {
        this.operacija = operacija;
        this.argument = argument;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    
    
}

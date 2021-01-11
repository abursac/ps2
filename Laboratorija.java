/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Aleksandar
 */
public class Laboratorija implements Serializable
{
    private int laboratorijaID;
    private String naziv;
    private int dnevniKapacitetTestova;
    private String grad;

    public Laboratorija() {
    }

    public Laboratorija(int laboratorijaID, String naziv, int dnevniKapacitetTestova, String grad) {
        this.laboratorijaID = laboratorijaID;
        this.naziv = naziv;
        this.dnevniKapacitetTestova = dnevniKapacitetTestova;
        this.grad = grad;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getLaboratorijaID() {
        return laboratorijaID;
    }

    public void setLaboratorijaID(int laboratorijaID) {
        this.laboratorijaID = laboratorijaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getDnevniKapacitetTestova() {
        return dnevniKapacitetTestova;
    }

    public void setDnevniKapacitetTestova(int dnevniKapacitetTestova) {
        this.dnevniKapacitetTestova = dnevniKapacitetTestova;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Laboratorija other = (Laboratorija) obj;
        if (this.laboratorijaID != other.laboratorijaID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() 
    {
        return naziv;
    }
    
    
}

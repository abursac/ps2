/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Aleksandar
 */
public class Laborant implements Serializable
{
    private int laborantID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    private Laboratorija laboratorija;

    public Laborant() {
    }

    public Laborant(int laborantID, String ime, String prezime, String korisnickoIme, String lozinka, Laboratorija laboratorija) {
        this.laborantID = laborantID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.laboratorija = laboratorija;
    }

    public Laboratorija getLaboratorija() {
        return laboratorija;
    }

    public void setLaboratorija(Laboratorija laboratorija) {
        this.laboratorija = laboratorija;
    }

    public int getLaborantID() {
        return laborantID;
    }

    public void setLaborantID(int laborantID) {
        this.laborantID = laborantID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

        @Override
    public String toString() 
    {
        return ime + " " + prezime;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Laborant other = (Laborant) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        return true;
    }
    
    
}

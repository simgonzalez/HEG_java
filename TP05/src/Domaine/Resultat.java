package Domaine;

import java.time.LocalDateTime;

public class Resultat {
    private int noDossard;
    private double temps;

    public Resultat(int noDossard, double temps) {
        this.noDossard = noDossard;
        this.temps = temps;
    }

    public int getNoDossard() {
        return noDossard;
    }

    public double getTemps() {
        return temps;
    }

    @Override
    public String toString() {
        return "Dossard " + this.noDossard + " : " + this.temps;
    }
}

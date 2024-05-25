public abstract class Personnage implements Combattant {
    private String nom;
    private int niveau;
    private int pv;
    private int pm;
    private int pa;
    private int pd;

    public Personnage(String nom, int niveau, int pv, int pm, int pa, int pd) {
        this.nom = nom;
        this.niveau = niveau;
        this.pv = pv;
        this.pm = pm;
        this.pa = pa;
        this.pd = pd;
    }

    public String getNom() {
        return nom;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getPv() {
        return pv;
    }

    public int getPm() {
        return pm;
    }

    public int getPa() {
        return pa;
    }

    public int getPd() {
        return pd;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public reduirePv(int montant) {
        int degatApresReduction = montant - this.getPd();
        this.setPv(this.getPv() - (degatApresReduction < 0 ? 0 : degatApresReduction));
    }

    @Override
    public getMontantAttaque() {
        return this.getPa();
    }

    @Override
    public void attaquer(Personnage cible) {
        cible.reduirePv(this.getMontantAttaque());
    }

    @Override
    public void defendre() {
        this.pd +=1;
    }

    @Override
    public String toString() {
        return this.nom + "  est de niveau " + this.niveau + ", il s'agit d'un "+ this.getClass().getSimpleName();
    }
}

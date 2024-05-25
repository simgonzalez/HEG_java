public class Guerrier extends Personnage {
    private int resistance;

    public Guerrier(String nom, int niveau, int pv, int pm, int pa, int pd, int resistance) {
        super(nom, niveau, pv, pm, pa, pd);
        this.resistance = resistance;
    }


    @Override
    public void defendre() {
        super.defendre();
        this.setPd(this.getPd() + this.resistance);
    }

    @Override
    public void special() {
        this.resistance *= 2;
    }
}

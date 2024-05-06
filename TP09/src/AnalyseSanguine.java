public class AnalyseSanguine extends Analyse {
    private String typeAnalyse;
    private int valeurAnalyse;

    public AnalyseSanguine(int analyseID, int patientID, int patientAge, String typeAnalyse, int valeurAnalyse) {
        super(analyseID, patientID, patientAge);
        this.typeAnalyse = typeAnalyse;
        this.valeurAnalyse = valeurAnalyse;
    }

    public boolean isProblematic() {
        if (this.getPatientAge() >= 5 && this.getPatientAge() <= 10) {
            return this.valeurAnalyse < 160000 || this.valeurAnalyse > 450000;
        } else if (this.getPatientAge() >= 11 && this.getPatientAge() <= 15) {
            return this.valeurAnalyse < 160000 || this.valeurAnalyse > 400000;
        } else {
            return this.valeurAnalyse < 160000 || this.valeurAnalyse > 350000;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Bilan Plaquette, valeur " + this.valeurAnalyse;
    }
}

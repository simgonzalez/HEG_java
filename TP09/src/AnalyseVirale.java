public class AnalyseVirale extends Analyse {
    private String nomVirus;
    private boolean valeurAnalyse;

    public AnalyseVirale(int analyseID, int patientID, int patientAge, String nomVirus, String valeurAnalyse) {
        super(analyseID, patientID, patientAge);
        this.nomVirus = nomVirus;
        this.valeurAnalyse = valeurAnalyse.toLowerCase().equals("positif");
    }

    public boolean isProblematic() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " Virus " + this.nomVirus + " " + (this.valeurAnalyse ? "Positif" : "Négatif");
    }
}

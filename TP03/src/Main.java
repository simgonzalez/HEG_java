public class Main {
    public static void main(String[] args)
    {
        Ecole e1 = new Ecole("Haute école de gestion", "Route de drize 19", Ecole.EcoleType.PUBLIC,5, Ecole.EcoleDegree.UNI,"Gestion",1500);
        Ecole e2 = new Ecole("Schultz", "Route du lac 29", Ecole.EcoleType.PRIVATE,2, Ecole.EcoleDegree.C_O,"Général",200);
        Ecole e3 = new Ecole("Collège Saint-Louis", "Route de Corzier 23", Ecole.EcoleType.PRIVATE,3, Ecole.EcoleDegree.C_O,"Général",400);
        Ecole e4 = new Ecole("Collège Saint-Louis", "Route de Corzier 23", Ecole.EcoleType.PRIVATE,1, Ecole.EcoleDegree.C_O,"Mathématique",50);
        Ecole e5 = new Ecole("Collège de Carouge", "Route des centenaires 34", Ecole.EcoleType.PUBLIC,4, Ecole.EcoleDegree.C_O,"Général",1500);
        Ecole e6 = new Ecole("Collège de Carouge", "Route des centenaires 34", Ecole.EcoleType.PUBLIC,4, Ecole.EcoleDegree.C_O,"Général",500);

        System.out.println("Affichage des écoles");
        System.out.println("---------------------------------------------");
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println(e4.toString());
        System.out.println(e5.toString());
        System.out.println(e6.toString());
        System.out.println("");
        System.out.println("Test des égalités entre écoles");
        System.out.println("---------------------------------------------");
        if (!(e3.equals(e4)))
        {
            System.out.println(e3.toString());
            System.out.println("-------------- n'est pas égal à --------------");
            System.out.println(e4.toString());
            System.out.println("");
            System.out.println("");
        }
        else
        {
            System.out.println(e3.toString());
            System.out.println("-------------- est égal à --------------");
            System.out.println(e4.toString());
            System.out.println("");
            System.out.println("");
        }

        if (!(e5.equals(e6)))
        {
            System.out.println(e5.toString());
            System.out.println("-------------- n'est pas égal à --------------");
            System.out.println(e6.toString());
            System.out.println("");
            System.out.println("");
        }
        else
        {
            System.out.println(e5.toString());
            System.out.println("-------------- est égal à --------------");
            System.out.println(e6.toString());
            System.out.println("");
            System.out.println("");
        }

        //------------------------------------------------------------------------------

        //Rajoutez vos instances de Personne pour réaliser vos différents tests
        System.out.println(new Personne("test", e1));
        System.out.println(new Personne("test", e2));
    }
}
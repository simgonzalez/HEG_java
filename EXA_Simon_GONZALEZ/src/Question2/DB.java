package Question2;

import java.util.ArrayList;

public class DB {

    public static ArrayList<String> GetInsertEmployes(){
        ArrayList<String> requetes = new ArrayList<>();

        requetes.add("INSERT INTO Employe VALUES ( Lopez , John , Sculpteur ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Martin , Louise , Gestionnaire ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Dubois , Sophie , Designer ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Moreau , James , Analyste ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Roux, Julien , Consultant ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Semoun , Elie , Comique ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Muller , James , Ingénieur ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Petit , Maxime , Technicien ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Yaffa , Elie , Artiste ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Walker , James , Musicien ) ;");
        requetes.add("INSERT INTO Employe VALUES ( Daniels , Louise , Designer ) ;");


        requetes.add("INSERT INTO Employe VALUES ( Rogers , Steven , Superhero )"); // doit lever une SyntaxException
        requetes.add("INSERTION INTO Employe VALUES ( Evans , Chris , Superhero ) ;"); // doit lever une SyntaxException
        requetes.add("INSERT INTO Sportif VALUES ( Joshua , Anthony , Boxeur ) ;"); // doit lever une TableInexistanteException
        requetes.add("INSERT INTO Employe VALUES ( Yaffa , Elie , Artiste ) ;"); // doit lever une DoublonException

        return requetes;
    }

    public static ArrayList<String> GetUpdateEmployes(){
        ArrayList<String> requetes = new ArrayList<>();

        requetes.add("UPDATE Employe SET nom = Lion , prenom = Curtis , poste = Chef WHERE nom LIKE Semoun ; ");

        requetes.add("UPDATING Employe SET nom = Petit , prenom = Camille , poste = Ingénieur WHERE nom LIKE Petit ; "); // doit lever une SyntaxException
        requetes.add("UPDATE Employe SET nom = Blanc , prenom = Maxime , poste = Directeur WHERE nom LIKE Moreau"); // doit lever une SyntaxException
        requetes.add("UPDATE Personne SET nom = Muller , prenom = Hugo , poste = Technicien WHERE nom LIKE Muller ; "); // doit lever une TableInexistanteException

        return requetes;
    }


    public static ArrayList<String> GetSelectEmployes(){
        ArrayList<String> requetes = new ArrayList<>();

        requetes.add("SELECT * FROM Employe WHERE prenom LIKE James ;");

        requetes.add("SELECTS * FROM Employe WHERE prenom LIKE Maxime ;"); // doit lever une SyntaxException
        requetes.add("SELECT * FROM Employe WHERE prenom LIKE Julien "); // doit lever une SyntaxException
        requetes.add("SELECT * FROM Personne WHERE prenom LIKE Julien ;"); // doit lever une TableInexistanteException

        return requetes;
    }
}

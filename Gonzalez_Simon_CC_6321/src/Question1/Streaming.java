package Question1;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class Streaming {
    //Declarez les variables de classes ici
    private static ArrayList<VideoContent> videoContents = new ArrayList<>();
    private static HashMap<Integer, ArrayList<VideoContent>> library = new HashMap<>();

    public static void main(String[] args) {

        //Ces instances sont créées pour tester les classes Movie et TVShow, elles ne sont pas utilisées dans la suite du code
        Movie movie = new Movie(666, "Inception", 150, "Christopher Nolan", 200);
        TVShow tvShow = new TVShow(555, "Breaking Bad", 2008, 5);

        System.out.println();
        movie.play();

        System.out.println();
        tvShow.play();

        //Chargement des données dans une seule structure de données
        loadData();

        //Test de la méthode getVideoContent
        System.out.println();
        System.out.println("Get Video 3 :\n" + getVideoContent(new Movie(3, null, 0, null, 0)));
        System.out.println();
        System.out.println("Get Video 25 :\n" + getVideoContent(new TVShow(25, null, 0, 0)));

    }

    /**
     * recher le videocontent dans l'app de streaming
     *
     * @param videoContent VideoContent à rechercher
     * @return
     */
    private static String getVideoContent(VideoContent videoContent) {
        for (VideoContent vc : videoContents) {
            if (vc.equals(videoContent)) {
                return vc.toString();
            }
        }
        return "Video not found";
    }

    /**
     * Charge les données de l'application de streaming
     * Chaque VideoContent ID est unique
     */
    private static void loadData() {
        for (int i = 0; i < DataBase.MOVIE_TITLES.length; i++) {
            videoContents.add(new Movie(i+1, DataBase.MOVIE_TITLES[i], DataBase.MOVIE_YEARS[i], DataBase.MOVIE_DIRECTORS[i], DataBase.DURATIONS[i]));
        }
        for (int i = 0; i < DataBase.TVSHOW_TITLES.length; i++) {
            videoContents.add(new TVShow(videoContents.size() + 1, DataBase.TVSHOW_TITLES[i], DataBase.MOVIE_YEARS[i], DataBase.TVSHOW_SEASONS[i]));
        }
    }

    /**
     * groupe tous les films et séries par année dans une seule et même structure de données
     */
    private static void createLibrary() {
        for (VideoContent vc : videoContents) {
            if (library.containsKey(vc.getYear())) {
                library.get(vc.getYear()).add(vc);
            } else {
                ArrayList<VideoContent> list = new ArrayList<>();
                list.add(vc);
                library.put(vc.getYear(), list);
            }
        }
    }
}

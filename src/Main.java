import com.sun.org.apache.xpath.internal.operations.Bool;
import objects.*;
import persistance.DBQueries;
import persistance.FileIO;
import persistance.SQLConnection;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Main {
    public static void main(String ... args) {

        List<Car> cars = new ArrayList<Car>(Arrays.asList(
            //  Car(int ID, int idClient, Type type, String marque, String matricule, Couleur couleur)
            new Car(1, null, Type.PICK_UP, "Tundra", "AB-7698/AA", Couleur.NOIR),
            new Car(2, 2, Type.SPORT, "McLaren", "AC-2342/AA", Couleur.CYAN),
            new Car(3, 1, Type.SPORT, "Porsche", "AC-4563/AA", Couleur.SEPIA),
            new Car(4, 2, Type.CAMPING_CAR, "Toyota", "AA-4534/FA", Couleur.BLANC),
            new Car(5, 1, Type.AMIBULANCE, "4x4", "AA-4534/FA", Couleur.NOIR)
        ));

        List<Client> clients = new ArrayList<Client>(Arrays.asList(
                new Client(1, "John Doe", "johndoe@gmail.com"),
                new Client(2, "Jane Doe", "janedoe@gmail.com")
        ));


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        // Nouvelle reservation
        // Le client 1, reserve la voiture a 0
        Booking booking = new Booking(1, date, clients.get(1), cars.get(0));

        /**
         * Enregistrement dans la base de donnees
         * d'une reservation
         *
         * System.out.println(DBQueries.insert(booking));
         */

        /**
         * Enregistrement dans le fichier .txt
         * de la reservation
         *
         * System.out.println(FileIO.create(booking.getPath(), booking.toString()));
         */

        /**
         * package objects : Ou se trouve tous les objets
         * package FileIO : La manipulation des fichiers .txt
         */


    }
}
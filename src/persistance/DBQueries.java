package persistance;

import objects.*;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class DBQueries {

    private static String query;
    private static ResultSet resultSet;

    /**
     * @return Statement
     */
    private static Statement getState() {
        Statement statement = null;
        try {
            statement = SQLConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    /**
     * @param object
     * @return boolean
     */
    public static boolean insert(Object object) {

        if(object instanceof Client) {
            Client client = (Client) object;
            String query = "INSERT INTO client (id, name, email) VALUES (" +
                    client.getID() + ",'" +
                    client.getName() + "','" +
                    client.getEmail() +"');";

        }

        if(object instanceof Car) {

            Car car = (Car) object;
            String query = "INSERT INTO client (id,type, marque, matricule, couleur, id_user) VALUES (" +
                    car.getID() + ",'" +
                    car.getType() + "','" +
                    car.getMarque() + "','" +
                    car.getMatricule() + "','" +
                    car.getCouleur() + "','" +
                    car.getClient().getID() +"');";
        }

        if(object instanceof Car) {

           Booking booking = (Booking) object;
            String query = "INSERT INTO booking (id, id_client, id_car, date) VALUES (" +
                    booking.getId() + ",'" +
                    booking.getClient() + "','" +
                    booking.getCar() + "','" +
                    booking.getDate() + "','" ;
        }


        return (state(query) == 0) ? false : true;
    }

    /**
     * @param query
     * @return int
     */
    private static int state(String query) {
        int state = 0;
        try {
            state = getState().executeUpdate(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
        return state;
    }

    public static boolean delete(int id, String table) {
        query = "DELETE FROM " + table + " WHERE id=" + id + ";";
        return (state(query) == 0) ? false : true;
    }

    public static boolean update(int id, String table, Object object) {
        try {
            Statement statement = SQLConnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        /**
         * UPDATE Customers
         * SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
         * WHERE CustomerID = 1;
         */
        query = "UPDATE " + table + "SET ";

        if(object instanceof Client) {

        }

        if(object instanceof Car) {

        }

        return false;
    }


    private static boolean updateClient() {
        return false;
    }

    private static boolean updateCar() {
        return false;
    }

    private static boolean updateBooking() {
        return false;
    }



    public static List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<Booking>();

        try {
            query = "SELECT * FROM booking; ";
            resultSet = getState().executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int id_client = resultSet.getInt("id_client");
                int id_car = resultSet.getInt("id_car");
                String date = resultSet.getString("date");


                try {
                    Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date);
                    Booking booking = new Booking(id, date1, getClients().get(id_client), getCars().get(id_car));
                    bookings.add(booking);
                } catch (ParseException e) {
                    e.getErrorOffset();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookings;
    }

    private static List<Car> getCars() {
        List<Car> cars = new ArrayList<Car>();

        try {
            query = "SELECT * FROM booking; ";
            resultSet = getState().executeQuery(query);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String marque = resultSet.getString("marque");
                String matricule = resultSet.getString("matricule");
                String couleur = resultSet.getString("couleur");
                int id_user = resultSet.getInt("id_user");


                Type type1 = Type.valueOf(type);
                Couleur couleur1 = Couleur.valueOf(couleur);

                Car car = new Car(id, id_user, type1, marque, matricule, couleur1);
                cars.add(car);
            }

            resultSet.close();
            getState().close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }


    private static List<Client> getClients() {
        List<Client> clients = new ArrayList<Client>();

        try {
            query = "SELECT * FROM client;";
            resultSet = getState().executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                Client client = new Client(id, name, email);

                clients.add(client);
            }

            resultSet.close();
            getState().close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return clients;
    }
}

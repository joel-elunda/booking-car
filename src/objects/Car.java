package objects;

import java.util.Objects;

public class Car {


    private int ID;
    private Type type;
    private String marque;
    private String matricule;
    private Couleur couleur;

    private Car car;
    private Client client = new Client();

    public Car() {}

    public Car(int id, Integer o, Type pickUp, String tundra, String matricule, Couleur noir) {}

    public Car(int ID, int idClient, Type type, String marque, String matricule, Couleur couleur) {
        this.ID = ID;
        client.setID(idClient);
        this.type = type;
        this.marque = marque;
        this.matricule = matricule;
        this.couleur = couleur;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static boolean create(Car car) {
        return false;
    }

    public static boolean read() {
        return false;
    }

    public static boolean update(Car car) {
        return false;
    }

    public static boolean delete(Car car) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return ID == car.ID &&
                Objects.equals(type, car.type) &&
                Objects.equals(marque, car.marque) &&
                Objects.equals(matricule, car.matricule) &&
                couleur == car.couleur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, type, marque, matricule, couleur);
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID=" + ID +
                ", type='" + type + '\'' +
                ", marque='" + marque + '\'' +
                ", matricule='" + matricule + '\'' +
                ", couleur=" + couleur +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
}

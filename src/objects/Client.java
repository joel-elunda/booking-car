package objects;

import java.util.Objects;

public class Client {

    private int ID;
    private String name;
    private String email;

    public Client() {

    }

    public Client(int ID, String name, String email) {
        this.ID = ID;
        this.name = name;
        this.email = email;
    }


    public static boolean create(Client client ) {
        return false;
    }

    public static boolean read() {
        return false;
    }

    public static boolean update(Client client) {
        return false;
    }

    public static boolean delete(Client client) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return ID == client.ID &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
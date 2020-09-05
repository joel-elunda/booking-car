package objects;

import java.util.Date;
import java.util.Objects;

public class Booking {

    private int id;
    private Date date;
    private Client client;
    private Car car;

    public String path = "src/data/booking.txt";

    public Booking() {}

    public Booking(int id, Date date, Client client, Car car) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id &&
                Objects.equals(date, booking.date) &&
                Objects.equals(client, booking.client) &&
                Objects.equals(car, booking.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, client, car);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", date=" + date +
                ", client=" + client +
                ", car=" + car +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

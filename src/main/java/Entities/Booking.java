package Entities;

public class Booking {
    String destination;
    String date;
    int rooms;
    int adults;
    int children;
    int age;

    public Booking(String destination, String date, int rooms, int adults, int children, int age) {
        this.destination = destination;
        this.date = date;
        this.rooms = rooms;
        this.adults = adults;
        this.children = children;
        this.age = age;
    }

    public String[] getDates(){
        return date.split(",");
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

package adapter;

public class Main {
    public static void main(String[] args) {
        Car sportCar = new SportCarAdapter(20);
        sportCar.light();
        sportCar.ride(20);
    }
}

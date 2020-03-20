package adapter;

public class SportCarAdapter extends Car {
    private SportsCar sportsCar;

    public SportCarAdapter(int km) {
        this.sportsCar = new SportsCar(km);
    }

    @Override
    public void ride(int km) {
        sportsCar.ride(km);
    }

    @Override
    void light() {
        sportsCar.light();
    }
}

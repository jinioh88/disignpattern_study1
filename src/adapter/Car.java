package adapter;

public class Car {
    private int km;

    public Car() {}

    public Car(int km) {
        this.km = km;
    }

    public void ride(int km) {
        System.out.println("시속이 " + km);
    }

    void light() {
        System.out.println("차에 불이 켜졌다!");
    }
}

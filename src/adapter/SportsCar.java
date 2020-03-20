package adapter;

public class SportsCar {
    private int km;

    public SportsCar(int km) {
        this.km = km;
    }

    public void ride(int km) {
        System.out.println("시속이 " + km*2);
    }

    void light() {
        System.out.println("차에 불이 4개 켜졌다!");
    }
}

package project.singleton;

/**
 * StatefulService
 */
public class StatefulService {

    private int price;

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // this is not stateful
    }

    public int getPrice() {
        return price;
    }
}

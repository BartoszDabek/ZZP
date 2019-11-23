package bi.zzp.pizza.model;

public interface Observable {
    void add(Observer o);
    void remove(Observer o);
    void notify(Pizza pizza, String clientAddress, int price);
}

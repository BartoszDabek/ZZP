package bi.zzp.pizza.model;

public interface Observer {
    void update(Pizza pizza, String clientAddress, int price);
}

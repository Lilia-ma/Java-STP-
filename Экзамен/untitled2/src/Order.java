import java.util.ArrayList;

public class Order {
    private Integer table;
    private ArrayList<Dish> content = new ArrayList<>();
    private Boolean closed = false;

    public Order(Integer table) {
        this.table = table;

    }
    public void showOrder(){
        int sum = 0;
        System.out.println(String.format("Заказ на столик №%d", table));
        System.out.println("Блюда в заказе:");
        for (Dish meal : content) {
            System.out.println(String.format("%s - %d",meal.getName(), meal.getPrice()));
            sum+= meal.getPrice();
        }
        System.out.println(String.format("Сумма заказа: %d", sum));
        System.out.println("--------------");
    }
    public void add(Dish meal){
        if (meal.isAvailable()) {
            content.add(meal);
    }}
    public void close(){
        this.closed = true;
    }
}
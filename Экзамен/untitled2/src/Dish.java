public class Dish {
    private String name, unit, structure;
    private Boolean available, bar;
    private Integer price, qty;

    public Dish(String name, Boolean available, Integer price, Boolean bar, String unit, Integer qty, String structure) {
        this.name = name;
        this.available = available;
        this.price = price;
        this.bar = bar;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Boolean changeAvailability() {
        this.available = isAvailable() ? false : true;
        return this.available;
    }

    public Boolean isAvailable() {
        return available ? true : false;
    }
}
import java.util.ArrayList;

public class Menu {
    private ArrayList<Dish> eat = new ArrayList<>();
    public void show(){

        int i = 0;
        for (Dish meal : eat) {
            System.out.println(String.format("%d: %s - %s",i+1, meal.getName(), outAvailability(meal)));
            i++;
        }
    }
    public Dish getMealByID(Integer id){
        return eat.get(id-1);
    }
    public void changeAvailability(Integer id){
        eat.get(id - 1).changeAvailability();
    }
    private String outAvailability(Dish meal){
        return (meal.isAvailable() ? "Доступно" : "Не доступно");
    }
    public Menu(){
        eat.add (new Dish("Пицца",true,400,false,"гр",400,"Тесто, соус, "));
        eat.add (new Dish("Бургер",true,900,false,"см",30,"Булка, котлета"));
        eat.add (new Dish("Картошка",false,900,false,"гр",340,"Картошка"));
        eat.add (new Dish("Сок",true,150,true,"Упаковочный",1,"Яблоко"));
        eat.add (new Dish("Коктейль",false,250,true,"Самодельный",1,"Ваниль"));
    }
}

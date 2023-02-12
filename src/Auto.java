import java.util.ArrayList;
import java.util.List;

public class Auto {
    private String brand, model;
    private double power, price, boost;
    private int year, speed, averagePower;
    private boolean engineCondition;
    static List<Auto> collections = new ArrayList<>();


    public Auto(String brand, String model, String color, double power, double price, int year, int speed, boolean engineCondition, double boost) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.price = price;
        this.year = year;
        this.speed = speed;
        this.boost = boost;
        collections.add(this);
        this.engineCondition = engineCondition;
    }

    String getBrand() {
        return brand;
    }


    String getModel() {
        return model;
    }

    double getPower() {
        return power;
    }

    double getPrice() {
        return price;
    }

    int getYear() {
        return year;
    }

    int getSpeed() {
        return speed;
    }

    double getBoost() {return boost;}
    

    public void getInfo() {
        System.out.println("Автомобиль: " + brand + " " + model + ". Год выпуска: " + year
                + ". Объём двигателя: " + power + ". Максимальная скорость: " + speed
                + ". Производительность: " + averagePower + ". Цена: " + price);
    }

    public void start() {
        engineCondition = true;
        System.out.println("Автомобиль " + brand + " " + model + " заведён...");
        way();
    }

    public void stop() {
        engineCondition = false;
        System.out.println("Автомобиль " + brand + " " + model + " заглушен...");
        way();
    }

    public void way() {
        if (engineCondition) System.out.println("Автомобиль " + brand + " " + model + "едет по маршруту");
        else System.out.println("Автомобиль " + brand + " " + model + " не движется");
    }

    public static List<Auto> getCollections (){
        return collections;
    }

    @Override
    public String toString() {
        return this.model;
    }
}

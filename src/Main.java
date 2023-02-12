import java.util.Random;
import java.util.Scanner;

public class Main {
    /*
    Доработайте программу в свободном стиле.
Можно сравнить 2 автомобиля между собой
Или пусть авто заедет за фруктами :-)
Добавьте несколько произвольных методов и свойств
<br>
ДОП: Сделать гонки:
- задаём растояние
- едут до финиша.
Сказать кто победит.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ваше имя:");
        User us1 = new User(scan.next());
        System.out.println("Введите имя соперника:");
        User us2 = new User(scan.next());
        getBet(us1, us2);

        /*
//    Если захочется посравнивать:
        auto1.getInfo();
        auto2.getInfo();
        auto3.getInfo();
        auto1.start();
        auto1.stop();
        auto2.start();
        comparison(auto1, auto2);
     */
    }

    public static void getBet(User us1, User us2) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        Auto auto1 = new Auto("Lamborghini", "Diablo", "black", 6.4, 1025.55, 2017, 100, false, 9.3);
        Auto auto2 = new Auto("Porche", "917TT", "white", 5.7, 893.74, 2018, 200, false, 7.8);
        Auto auto3 = new Auto("Lada", "Granta", "green", 6.2, 1150.43, 2011, 310, false, 6.4);
        auto1.getInfo();
        auto2.getInfo();
        auto3.getInfo();
        int way = rand.nextInt(1, 30) * 5000; // длина трассы
        System.out.println("Длина трассы равна " + way + " км");
        System.out.println(us1.name + " у вас " + us1.getCredit() + " кредитов. Выберите автомобиль из списка " + Auto.getCollections() + " и ставку на него, через запятую:");
        String[] choiser = scan.next().split(",");
        for (Auto it : Auto.collections
        ) {
            if (it.getModel().equals(choiser[0])) {
                us1.Choise(it);
                us1.bet = Integer.parseInt(choiser[1]);
                if (us1.bet < us1.credit) {
                    us1.setCredit(-(us1.bet));
                } else {
                    System.out.println("У вас не хватает денежных средств");
                }
            }
        }

        System.out.println(us2.name + " у вас " + us2.getCredit() + " кредитов. Выберите автомобиль из списка " + Auto.getCollections() + " и ставку на него, через запятую:");
        String[] choiserr = scan.next().split(",");
        for (Auto it : Auto.collections
        ) {
            if (it.getModel().equals(choiserr[0])) {
                us2.Choise(it);
                us2.bet = Integer.parseInt(choiserr[1]);
                if (us2.bet < us2.credit) {
                    us2.setCredit(-(us2.bet));
                } else {
                    System.out.println("У вас не хватает денежных средств");
                }
            }
        }
        race(way, us1.mod, us2.mod, us1, us2);
    }


    public static void race(int way, Auto somecar1, Auto somecar2, User us1, User us2) {
        double v1 = 0; // скорость первой машины
        double v2 = 0; // скорость второй машины
        double s1 = 0; // путь, проделанный первой машиной
        double s2 = 0; // путь, проделанный второй машиной
        int money = 0;
        for (int i = 0; i < way; i += 5) {
            if (v1 < somecar1.getSpeed()) {
                v1 = somecar1.getBoost() * i;
                s1 += v1 * i;
            } else {
                s1 += v1 * i;
            }
            if (v2 < somecar2.getSpeed()) {
                v2 = somecar2.getBoost() * i;
                s2 += v2 * i;
            } else {
                s2 += v2 * i;
            }

            if (s1 >= way) {
                money += us1.bet * 2;
                us1.setCredit(money);
                System.out.println("ПОбедила " + somecar1 + ". У пользователя " + us1.name + " " + us1.getCredit() + " рублей");
                System.out.println("-----------------------------------------------------------------");
                break;
            } else if (s2 >= way) {
                money += us2.bet * 2;
                us2.setCredit(money);
                System.out.println("ПОбедила " + somecar2 + ". У пользователя " + us2.name + " " + us2.getCredit() + " рублей");
                System.out.println("-----------------------------------------------------------------");
                break;
            }
        }
        if (us1.getCredit() == 0 || us2.getCredit() == 0)
        {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("ИТОГО");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("У первого игрока кредитов: " +us1.getCredit() +". У второго: "+us2.getCredit());
            return;
        }
        else {
            getBet(us1, us2);}
    }





    public static void comparison(Auto car1, Auto car2) {
        System.out.println("Сравнение:" + car1.toString() + " VS " + car2.toString());
        if (car1.getYear() > car2.getYear())
            System.out.println("  ~~~ " + car1.getBrand() + " " + car1.getModel() + " Более свежая модель");
        else System.out.println("  ~~~ " + car2.getBrand() + " " + car2.getModel() + " Более свежая модель");
        System.out.print(car1.getPower() + " --- " + car2.getPower());
        if (car1.getPower() > car2.getPower())
            System.out.println("  ~~~ " + car1.getBrand() + " " + car1.getModel() + " На ~" + (int) (car1.getPower() - car2.getPower()) + "л.с. мощнее.");
        else
            System.out.println("  ~~~ " + car2.getBrand() + " " + car2.getModel() + " На ~" + (int) (car2.getPower() - car1.getPower()) + "л.с. мощнее.");
        System.out.print(car1.getSpeed() + " --- " + car2.getSpeed());
        if (car1.getSpeed() > car2.getSpeed())
            System.out.println("  ~~~ " + car1.getBrand() + " " + car1.getModel() + " На " + (car1.getSpeed() - car2.getSpeed()) + "км/ч быстрее.");
        else
            System.out.println("  ~~~ " + car2.getBrand() + " " + car2.getModel() + " На " + (car2.getSpeed() - car1.getSpeed()) + "км/ч быстрее.");
        System.out.print(car1.getPrice() + " --- " + car2.getPrice());
        if (car1.getPrice() < car2.getPrice())
            System.out.println("  ~~~ " + car1.getBrand() + " " + car1.getModel() + " На " + (int) (car2.getPrice() - car1.getPrice()) + " кредитов дешевле.");
        else
            System.out.println("  ~~~ " + car2.getBrand() + " " + car2.getModel() + " На " + (int) (car1.getPrice() - car2.getPrice()) + " кредитов дешевле.");
        ;
    }



}




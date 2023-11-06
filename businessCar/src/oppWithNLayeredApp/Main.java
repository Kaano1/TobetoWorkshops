package oppWithNLayeredApp;

import oppWithNLayeredApp.business.CarManager;
import oppWithNLayeredApp.dataAccess.*;
import oppWithNLayeredApp.entities.Car;

public class Main {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car(1, 100000, "X", "Cruze");
        Car car2 = new Car(1, 100000, "i8", "Bmw");
        Car car3 = new Car(1, 100000, "1", "Ferra");

        CarManager carManager = new CarManager(new JdbcCarDao());
        carManager.add(car1);
        carManager.add(car2);
        CarManager carManager2 = new CarManager(new HibernateCarDao());
        carManager2.add(car3);

    }
}
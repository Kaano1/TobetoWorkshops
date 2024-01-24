package oppWithNLayeredApp.business;

import  oppWithNLayeredApp.dataAccess.*;
import oppWithNLayeredApp.entities.Car;

public class CarManager {
        private CarDao cardao;
        public CarManager(CarDao cardao)
        {
            this.cardao = cardao;
        }

        public void add(Car car) throws Exception {
            if (car.getPrice() < 10000) {
                throw new Exception("The price is under minimum limit. you have to increase than 10000");
            }
            System.out.println(car.getBrand() + " " + car.getModel() + " is added !!!");
            cardao.add(car);
        }
}
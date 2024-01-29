package oppWithNLayeredApp.entities;

import oppWithNLayeredApp.dataAccess.HibernateCarDao;

public class Car {

        int     id;
        double  price;
        String  model;
        String  brand;

        public Car()
        {

        }

    public Car(int id, double price, String model, String brand)
        {
            this.id = id;
            this.price = price;
            this.model = model;
            this.brand = brand;
        }


    public int getId()
    {
        return (id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
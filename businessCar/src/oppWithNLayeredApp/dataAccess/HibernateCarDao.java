package oppWithNLayeredApp.dataAccess;


import oppWithNLayeredApp.entities.Car;
public class HibernateCarDao implements CarDao {
    public void add(Car car) { System.out.println(car.getBrand() + " added with Hibernate"); }

    public void update(Car car) {
        System.out.println(car.getBrand() + " update with Hibernate");
    }

    public void delete(Car car) {
        System.out.println(car.getBrand() + " delete with Hibernate");
    }
}
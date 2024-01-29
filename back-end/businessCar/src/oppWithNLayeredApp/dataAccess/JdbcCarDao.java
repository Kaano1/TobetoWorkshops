package oppWithNLayeredApp.dataAccess;


import oppWithNLayeredApp.entities.Car;
public class JdbcCarDao implements CarDao {
    public void add(Car car)
    {
        System.out.println(car.getBrand() + " added with Jdbc");
    }

    public void update(Car car) {
        System.out.println(car.getBrand() + " update with Jdbc");
    }

    public void delete(Car car) {
        System.out.println(car.getBrand() + "delete with Jdbc");
    }
}
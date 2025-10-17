public class lesson_5 {
    Car myCar = new Car(2020, "BMW X6", 3.5);

    public static class Car {
        int year;
        String model;
        double engine;
        public Car(int theYear, String theModel, double theEngine){
            year = theYear;
        model = theModel;
        engine = theEngine;
        }
    }
}

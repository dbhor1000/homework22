import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;

public class Car extends Transport implements Transport.Competitor, Transport.DriverAndCarInformation {

    enum CarTypes {         //Перечисления с типами для класса Car
        Седан("Седан"),
        Хетчбек("Хетчбек"),
        Купе("Купе"),
        Универсал("Универсал"),
        Внедорожник("Внедорожник"),
        Кроссовер("Кроссовер"),
        Пикап("Пикап"),
        Фургон("Фургон"),
        Минивэн("Минивэн");

        private String carType;

        CarTypes(String carType) {
            this.carType = carType;
        }

        public static void carTypesToString(){

            Car.CarTypes[] cars = Car.CarTypes.values();
            for(int i = 0; i < cars.length; i++){

                System.out.println(cars[i]);

            }

            System.out.println();
        }
    }




    private DriverCategoryB driver;
    private CarTypes type;

    ArrayList<Mechanic> mechanics = new ArrayList<Mechanic>();


    public <T extends DriverCategoryB> Car(String model, String subModel, double engineSize, T driver, CarTypes type) {     //Альтернативный конструктор с указанием типа автомобиля

        super(model, subModel, engineSize);
        this.driver = driver;
        this.type = type;

    }

    public <T extends DriverCategoryB> Car(String model, String subModel, double engineSize, T driver) {

        super(model, subModel, engineSize);
        this.driver = driver;
        this.type = null;       //Если тип не указан, значение null

    }

    public DriverCategoryB getDriver() {
        return driver;
    }

    public CarTypes getType() {
        return type;
    }

    public ArrayList<Mechanic> getMechanics() {
        return mechanics;
    }

    public void setMechanics(ArrayList<Mechanic> mechanics) {
        this.mechanics = mechanics;
    }

    public void setType(CarTypes type) {
        this.type = type;
    }

    //ДЗ от 9 января


    @Override
    public void pitStop() {

        System.out.println(model + " " + subModel + " ушёл на питстоп.");
        System.out.println();

    }

    @Override
    public void bestTime() {

        System.out.println("Лучшее время круга " + model + " " + subModel + " :" + ((Math.random()*((90-60)+1))+60));

    }

    @Override
    public void maxSpeedOnLap() {

        System.out.println("Наибольшая скорость " + model + " " + subModel + " на круге: " + ((Math.random()*((220-150)+1))+150));
    }


    @Override
    public void requestDriverAndCarInformation() {

        System.out.println("Водитель " + driver.getDriverName() + " управляет " + model + " " + subModel + " и будет участвовать в заезде.");

        if(mechanics.size() > 0) {
            System.out.println("Механики транспортного средства: ");
            for (int i = 0; i < mechanics.size(); i++) {
                System.out.println(mechanics.get(i).getName());
            }
        } else {
            System.out.println("Транспортное средство не обслуживается механиками.");
        }

        System.out.println();
    }

    @Override
    public void undergoDiagnostic() throws DriverLicenseException {

        if (driver.getDriverLicenseCategory() == "B") {
            System.out.println("Автомобиль " + model + " " + subModel + " проходит диагностику.");
        } else {
            throw new DriverLicenseException("У водителя " + model + " " + subModel + " неподходящая категория прав " + driver.getDriverLicenseCategory() + " .");
        }
    }

    @Override
    public void printType() {      //Выводим тип автомобиля

        System.out.println(model + " " + subModel + " :");

        if(type == null){
            System.out.println("Данных по ТС не достаточно.");
        } else {

            System.out.println("Тип автомобиля: " + type);
        }

        System.out.println();
    }
}

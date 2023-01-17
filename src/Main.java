import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {



        //Водители, участвующие в гонках

        DriverCategoryB driver1 = new DriverCategoryB("Иван", true, 8, "B");
        DriverCategoryB driver2 = new DriverCategoryB("Сергей", true, 5, "С");
        DriverCategoryB driver3 = new DriverCategoryB("Артур", true, 6, "B");
        DriverCategoryB driver4 = new DriverCategoryB("Арсен", true, 3, "B");

        DriverCategoryC driver5 = new DriverCategoryC("Фёдор", true, 3, "D");
        DriverCategoryC driver6 = new DriverCategoryC("Михаэль", true, 5, "C");
        DriverCategoryC driver7 = new DriverCategoryC("Александр", true, 7, "C");
        DriverCategoryC driver8 = new DriverCategoryC("Дмитрий", true, 7, "C");

        DriverCategoryD driver9 = new DriverCategoryD("Пётр", true, 10, "D");
        DriverCategoryD driver10 = new DriverCategoryD("Святослав", true, 12, "D");
        DriverCategoryD driver11 = new DriverCategoryD("Денис", true, 8, "D");
        DriverCategoryD driver12 = new DriverCategoryD("Арсений", true, 13, "C");

        //Транспортные средства, участвующие в гонках

        Car car1 = new Car("Форд", "Фокус", 1.6, driver1);
        Car car2 = new Car("Форд", "Мустанг", 2.6, driver2, Car.CarTypes.Универсал);
        Car car3 = new Car("Ауди", "A8", 1.6, driver3, Car.CarTypes.Внедорожник);
        Car car4 = new Car("Лада", "Калина", 3.4, driver4, Car.CarTypes.Кроссовер);


        Truck truck1 = new Truck("Скания", "Model 1", 4.6, driver5, Truck.TruckTypes.N2);
        Truck truck2 = new Truck("Джип", "Гладиатор", 5.6, driver6, Truck.TruckTypes.N1);
        Truck truck3 = new Truck("Тойота", "Такома", 4.0, driver7);
        Truck truck4 = new Truck("Шевроле", "Колорадо", 4.2, driver8);


        Bus bus1 = new Bus("Вольво", "B11R", 3.6, driver9, Bus.BusTypes.Средняя);
        Bus bus2 = new Bus("MAN", "Bus1", 3.7, driver10);
        Bus bus3 = new Bus("Marcopolo", "Multego", 3.6, driver11);
        Bus bus4 = new Bus("King Long", "XMQ6996Y", 4.0, driver12);


        //Вывод всех имеющихся типов различных авто:

        Car.CarTypes.carTypesToString();
        Bus.BusTypes.busTypesToString();
        Truck.TruckTypes.truckTypesToString();

        //Вывод типов транспортных средств по интересующим критериям:

        car1.printType(); //Тип не указан
        bus1.printType();
        truck1.printType();
        car2.printType();


        //ДЗ от 28 декабря. С Новым Годом! Добавлены геттеры в правах всех трёх категория, класс для ошибки при проверке водительских прав машин и грузовиков.
        //В класс transport добавлен абстрактный метод undergoDiagnostic, переопределён в классе для машин и грузовиков. В классе мейн добавлена проверка с помощью
        //добавленного метода и обработка исключений.

        try {
            car1.undergoDiagnostic();       //Указан верный тип прав.
        } catch (DriverLicenseException e) {
            System.out.println(e.getMessage());
            System.out.println("Необходимо указать тип прав.");
        }

        System.out.println();

        try {
            truck1.undergoDiagnostic();     //Тип прав указан ошибочно.
        } catch (DriverLicenseException e) {
            System.out.println(e.getMessage());
            System.out.println("Необходимо указать тип прав.");
        }

        bus1.undergoDiagnostic();       //Автобусам не нужна диагностика, сообщение не выводится.

        System.out.println();

        try {
            car2.undergoDiagnostic();       //Тип прав указан ошибочно.
        } catch (DriverLicenseException e) {
            System.out.println(e.getMessage());
            System.out.println("Необходимо указать тип прав.");
        }

        System.out.println();

        //ДЗ от 9 января. --->
        //C автомобилем могут работать до двух механников одновременно, с грузовиками и автобусами до 3, это прописано в методах класса Mechanic
        //Метод интерфейся DriverAndCarInformation теперь работает по-другому и выводит механиков, обслуживающих автомобиль.
        //Подклассам класса Transport был добавлен список в качестве поля, для учёта механиков.

        ArrayList<Transport> raceParticipants = new ArrayList<Transport>();
        raceParticipants.add(car1);
        raceParticipants.add(car2);
        raceParticipants.add(car3);
        raceParticipants.add(car4);
        raceParticipants.add(truck1);
        raceParticipants.add(truck2);
        raceParticipants.add(truck3);
        raceParticipants.add(truck4);
        raceParticipants.add(bus1);
        raceParticipants.add(bus2);
        raceParticipants.add(bus3);
        raceParticipants.add(bus4);

        Mechanic mechanic1 = new Mechanic("Алексей Петрович", "Автомобильная компания 1", false, true, true);
        Mechanic mechanic2 = new Mechanic("Антон Игнатьевич", "Автомобильная компания 1", false, true, true);
        Mechanic mechanic3 = new Mechanic("Сергей Иванович", "Автомобильная компания 1", false, true, true);
        Mechanic mechanic4 = new Mechanic("Иван Евгеньевич", "Автомобильная компания 2", true, false, true);
        Mechanic mechanic5 = new Mechanic("Артур Денисович", "Автомобильная компания 2", false, false, true);
        Mechanic mechanic6 = new Mechanic("Денис Артурович", "Автомобильная компания 2", true, true, true);
        Mechanic mechanic7 = new Mechanic("Дмитрий Борисович", "Автомобильная компания 2", true, true, true);

        mechanic1.engageTechnicalService(car1, mechanic1);  //Этот механик не работает с автомобилями
        mechanic2.engageRepair(truck1, mechanic2); //Механик чинит грузовик
        mechanic3.engageTechnicalService(bus1, mechanic3); //Механик чинит автобус
        mechanic4.engageTechnicalService(truck1, mechanic4); //Механик чинит грузовик
        mechanic5.engageTechnicalService(truck1, mechanic5);  //Механик чинит грузовик
        mechanic6.engageTechnicalService(truck1, mechanic6);  //Не больше 3 механиков на 1 грузовик!

        //Вызываем информацию о транспортном средстве, водителе и механиках
        car1.requestDriverAndCarInformation();
        truck1.requestDriverAndCarInformation();
        bus1.requestDriverAndCarInformation();


        //ДЗ от 16 января

        //В отдельном классe SetOfDrivers содержится одно поле, являющееся HashSet, drivers. В Main генерируем объект этого класса. Далее добавляем водителей.
        //Добавляем итератор driverFromSet и с помощью него через цикл while выводим список водителей без повторов.

        SetOfDrivers set = new SetOfDrivers();
        set.drivers.add(driver1);
        set.drivers.add(driver2);
        set.drivers.add(driver3);
        set.drivers.add(driver4);
        set.drivers.add(driver5);
        set.drivers.add(driver6);
        set.drivers.add(driver7);
        set.drivers.add(driver8);
        set.drivers.add(driver9);
        set.drivers.add(driver10);
        set.drivers.add(driver11);
        set.drivers.add(driver12);
        set.drivers.add(driver12); //Повторно добавленные объекты
        set.drivers.add(driver12); //Не учитываются в HashSet :)


        Iterator<Driver> driverFromSet = set.drivers.iterator();

        while(driverFromSet.hasNext()) {
            Driver next = driverFromSet.next();
            System.out.println(next);
        }






    }
}
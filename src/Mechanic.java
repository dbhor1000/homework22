public class Mechanic {

    private final String name;
    private String companyName;
    private boolean worksWithCars;
    private boolean worksWithBuses;
    private boolean worksWithTrucks;

    public Mechanic(String name, String companyName, boolean worksWithCars, boolean worksWithBuses, boolean worksWithTrucks) {
        this.name = name;
        this.companyName = companyName;
        this.worksWithCars = worksWithCars;
        this.worksWithBuses = worksWithBuses;
        this.worksWithTrucks = worksWithTrucks;
    }


    public String getName() {
        return name;
    }

    public void engageTechnicalService(Car car, Mechanic mechanic){        //сервис для автомобилей, одновременно чинить автомобиль могут до 2 человек

        if(worksWithCars == true && (car.mechanics.size() < 2)){

            System.out.println("Механик " + name + " проводит техобслуживание " + car.model + " " + car.subModel + " .");
            car.mechanics.add(mechanic);


        } else{

            System.out.println(name + " не может работать с данным транспортным средством.");
        }

        System.out.println();
    }

    public void engageTechnicalService(Truck truck, Mechanic mechanic){        //сервис для грузовиков, одновременно чинить грузовик могут до 3 человек

        if(worksWithTrucks == true && (truck.mechanics.size() < 3)){

            System.out.println("Механик " + name + " проводит техобслуживание " + truck.model + " " + truck.subModel + " .");
            truck.mechanics.add(mechanic);


        } else{

            System.out.println(name + " не может работать с данным транспортным средством.");
        }

        System.out.println();
    }

    public void engageTechnicalService(Bus bus, Mechanic mechanic){        //сервис для автобусов, одновременно чинить автобус могут до 3 человек

        if(worksWithBuses == true && (bus.mechanics.size() < 3)){

            System.out.println("Механик " + name + " проводит техобслуживание " + bus.model + " " + bus.subModel + " .");
            bus.mechanics.add(mechanic);


        } else{

            System.out.println(name + " не может работать с данным транспортным средством.");
        }

        System.out.println();
    }


    public void engageRepair(Car car, Mechanic mechanic){        //починка для автомобилей, одновременно чинить автомобиль могут до 2 человек

        if(worksWithCars == true && (car.mechanics.size() < 2)){

            System.out.println("Механик " + name + " проводит починку " + car.model + " " + car.subModel + " .");
            car.mechanics.add(mechanic);


        } else{

            System.out.println(name + " не может работать с данным транспортным средством.");
        }

        System.out.println();
    }

    public void engageRepair(Truck truck, Mechanic mechanic){        //починка для грузовиков, одновременно чинить грузовик могут до 3 человек

        if(worksWithTrucks == true && (truck.mechanics.size() < 3)){

            System.out.println("Механик " + name + " проводит починку " + truck.model + " " + truck.subModel + " .");
            truck.mechanics.add(mechanic);


        } else{

            System.out.println(name + " не может работать с данным транспортным средством.");
        }

        System.out.println();
    }

    public void engageRepair(Bus bus, Mechanic mechanic){        //починка для автобусов, одновременно чинить автобус могут до 3 человек

        if(worksWithBuses == true && (bus.mechanics.size() < 3)){

            System.out.println("Механик " + name + " проводит починку " + bus.model + " " + bus.subModel + " .");
            bus.mechanics.add(mechanic);


        } else{

            System.out.println(name + " не может работать с данным транспортным средством.");
        }

        System.out.println();
    }

}

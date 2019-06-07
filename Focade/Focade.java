class Car{
    public  void engineStop(){
        System.out.println("engine stoped");
    }

    public void engineStart(){
        System.out.println("engine started");
    }

    public void doorLock(){
        System.out.println("door locked");
    }

    public void doorUnlock(){
        System.out.println("door Unlocked");
    }

    public void wheelRoll(){
        System.out.println("wheel rolled");
    }

    public void wheelStop(){
        System.out.println("wheel Stoped");
    }
}

class CarFocade{
    private Car car;
    CarFocade(Car car){
        this.car = car;
    }

    public void stop(){
        System.out.println("\nCar Stopeed");
        car.wheelStop();
        car.engineStop();
        car.doorUnlock();
    }

    public  void drive(){
        System.out.println("\nCar Drive");
        car.doorLock();
        car.wheelRoll();
        car.engineStart();
    }

    public void  park(){
        System.out.println("\nCar parked");
        car.engineStop();
        car.doorLock();
        car.wheelStop();
    }
}

class Client{
    public static void main(String[] args) {
        Car car = new Car();
        CarFocade focade = new CarFocade(car);

        focade.drive();
        focade.stop();
        focade.park();
    }
}
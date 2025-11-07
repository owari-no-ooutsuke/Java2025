interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    //Определяем метод интерфейса
    @Override
    public void start() {
        System.out.println("Машина поехала");
    }

    //Определяем метод интерфейса
    @Override
    public void stop() {
        System.out.println("Машина остановилась");
    }

    public void makeSound() {
        System.out.println("Звуковой сигнал");
    }
}

class Truck extends Car {
    //Переопределяем метод суперкласса
    @Override
    public void makeSnd() { //опечатка makeSnd вместо makeSound - Override помогает обнаружить
        System.out.println("Очень громкий звуковой сигнал");
    }
}

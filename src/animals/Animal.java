
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }
}

interface Run {
    void run();
}

interface Speak {
    void speak();
}

class Dog extends Animal implements Run, Speak {
    Dog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + " is running.");
    }

    @Override
    public void speak() {
        System.out.println(name + " says Woof!");
    }
}

class Cat extends Animal implements Run, Speak {
    Cat(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + " is running gracefully.");
    }

    @Override
    public void speak() {
        System.out.println(name + " says Meow!");
    }
}

class Shark extends Animal {
    Shark(String name) {
        super(name);
    }
}

class HomeAnimal {
    private Animal animal;

    HomeAnimal(Animal animal) {
        if (!(animal instanceof Run) || !(animal instanceof Speak)) {
            throw new IllegalArgumentException("Invalid class type for HomeAnimal");
        }
        this.animal = animal;
    }

    Animal getObject() {
        return animal;
    }

    void showClassType() {
        System.out.println("Type of object: " + animal.getClass().getSimpleName());
    }

    void sleepOnTheCouch() {
        System.out.println(animal.name + " is sleeping on the couch.");
    }
}

class Main {
    public static void main(String[] args) {
        HomeAnimal dogHome = new HomeAnimal(new Dog("Buddy"));
        Animal dogObj = dogHome.getObject();
        dogHome.showClassType();
        ((Run) dogObj).run();
        ((Speak) dogObj).speak();
        dogHome.sleepOnTheCouch();
        System.out.println();

        HomeAnimal catHome = new HomeAnimal(new Cat("Whiskers"));
        Animal catObj = catHome.getObject();
        catHome.showClassType();
        ((Run) catObj).run();
        ((Speak) catObj).speak();
        catHome.sleepOnTheCouch();
        System.out.println();

        try {
            HomeAnimal sharkHome = new HomeAnimal(new Shark("Jaws"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

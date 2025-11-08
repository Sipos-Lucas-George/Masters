public abstract class Animal {
    private int age;
    private int speed;

    public Animal(int age, int speed) {
        if (age < 0 || speed < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        this.age = age;
        this.speed = speed;
    }

    public int getAge() {
        return age;
    }

    public int getSpeed() {
        return speed;
    }

    public final boolean isFaster(Animal animal) {
        return this.speed > animal.getSpeed();
    }

    public final boolean isOlder(Animal animal) {
        return this.age > animal.getAge();
    }

    public abstract Animal[] multiply(int noInstances);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && speed == animal.speed;
    }

    @Override
    public String toString() {
        return "is " + age + " year" + (getAge() == 1 ? "" : "s") + " old, is " + speed + " units fast.";
    }
}

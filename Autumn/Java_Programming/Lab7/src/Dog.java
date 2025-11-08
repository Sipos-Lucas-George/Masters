public final class Dog extends Animal {
    public enum types {HOUND, GUNDOG};
    private types type;
    private String breed;

    public Dog(int age, int speed, types type, String breed) {
        super(age, speed);

        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be null or empty");
        }

        this.type = type;
        this.breed = breed;
    }

    public types getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public Animal[] multiply(int noInstances) {
        if (noInstances < 1) {
            throw new IllegalArgumentException("Number of instances must be greater than 0");
        }
        Animal[] animals = new Dog[noInstances];
        for (int i = 0; i < noInstances; i++) {
            animals[i] = new Dog(0, getSpeed(), getType(), getBreed());
        }
        return animals;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            return super.equals(o) && ((Dog)o).getBreed().equals(breed) && ((Dog)o).getType() == type;
        } else {
            return super.equals(o);
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + " (" + breed + ": " + type + ") " + super.toString();
    }

    public static void main(String[] args) {
        Dog dog = new Dog(2015, 10, types.HOUND, "Canecorso");
        System.out.println(dog);
        Animal[] animals = dog.multiply(5);
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}

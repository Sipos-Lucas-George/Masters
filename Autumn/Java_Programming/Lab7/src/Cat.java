public final class Cat extends Animal {
    public static final int LION = 0;
    public static final int HOUSE_CAT = 1;

    private int type;
    private String breed;

    public Cat(int age, int speed, int type, String breed) {
        super(age, speed);

        if (type < 0 || type > 1) {
            throw new IllegalArgumentException("Unknown Cat type: " + type);
        }

        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be empty");
        }

        this.type = type;
        this.breed = breed;
    }

    public int getType() {
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
        Animal[] animals = new Cat[noInstances];
        for (int i = 0; i < noInstances; i++) {
            animals[i] = new Cat(0, getSpeed(), getType(), getBreed());
        }
        return animals;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Cat) {
            return super.equals(o) && ((Cat)o).getBreed().equals(breed) && ((Cat)o).getType() == type;
        } else {
            return super.equals(o);
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + " (" + breed + ": " + (type == LION ? "Lion" : "House cat") + ") " + super.toString();
    }

    public static void main(String[] args) {
        Cat cat = new Cat(2015, 10, 0, "Ragdoll");
        System.out.println(cat);
        Animal[] animals = cat.multiply(5);
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}

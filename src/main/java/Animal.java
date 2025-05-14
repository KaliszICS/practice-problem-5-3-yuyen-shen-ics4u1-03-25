abstract class Animal {

    private String name;
    private int age;
    private String type;
    private int position;

    public Animal(String name, int age, String type, int position) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.position = position;
    }

    abstract String animalSound();

    abstract void move();

    public String sleep() {
        return "Zzz";
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getType() {
        return this.type;
    }

    public int getPosition() {
        return this.position;
    }
}
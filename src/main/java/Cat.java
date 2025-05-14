class Cat extends Animal {

    protected int position;

    public Cat(String name, int age, String type, int position) {
        super(name, age, type, position);
        this.position = position;
    }

    public String animalSound() {
        return "Meow";
    }

    public void move() {
        this.position += 5;
    }
}
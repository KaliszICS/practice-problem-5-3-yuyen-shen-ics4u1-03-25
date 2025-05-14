class Bear extends Animal {

    protected int position;

    public Bear(String name, int age, String type, int position) {
        super(name, age, type, position);
        this.position = position;
    }

    public String animalSound() {
        return "Roar";
    }

    public void move() {
        this.position += 1;
    }
}
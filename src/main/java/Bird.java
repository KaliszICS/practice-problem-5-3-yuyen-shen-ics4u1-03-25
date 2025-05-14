class Bird extends Animal {

    protected int position;

    public Bird(String name, int age, String type, int position) {
        super(name, age, type, position);
        this.position = position;
    }

    public String animalSound() {
        return "Chirp";
    }

    public void move() {
        this.position += 50;
    }
}
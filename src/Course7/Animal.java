package Course7;

public class Animal {
    public void sunet(){
        System.out.println("Animalul scoate un sunet!");
    }
    protected void respira() {
        System.out.println("Animalul respira.");
    }
}

class Caine extends Animal {
    @Override
    public void sunet() {
        System.out.println("Cainele latra!");
    }
}

class Pisica extends Animal {
    @Override
    public void sunet() {
        System.out.println("Pisica miauna!");
    }
}



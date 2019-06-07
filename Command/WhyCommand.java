//Reciever 1
class Torch {
    public void turnOn() {
        System.out.println("turn on the Torch");
    }
}

// Reciever 2
class Ring {
    public void turnOn() {
        System.out.println("Ring on");
    }
}

interface Button{
    public void pressed();
}

class RingButton implements Button{
    private Ring ring;
    public RingButton(Ring ring){
        this.ring = ring;
    }
    public void pressed(){
        ring.turnOn();
    }
}

class TorchButton implements Button{
    private Torch torch;
    public TorchButton(Torch torch){
        this.torch = torch;
    }
    public void pressed(){
        torch.turnOn();
    }
}

class Client3{
    public static void main(String[] args) {
        Ring ring1 = new Ring();
        Torch torch1 = new Torch();



        Button bt = new RingButton(ring1);
        bt.pressed();

        bt = new TorchButton(torch1);
        bt.pressed();
        
    }
}
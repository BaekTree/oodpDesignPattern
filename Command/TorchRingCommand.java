/**
 * 
 * Design Pattern: Command pattern
 * Components: Invoker, Receivers, Command interface, Concrete Command
 * Invoker: Button
 * Reciever: Torch, Ring class
 * Command Interface: Command
 * Concrete Command: TorchComand, RingCommand
 * 
 * One Invoker calls a functions. This makes other class work.
 * Recievers are the entity to work. They have the functions.
 * 
 * 
 * 
 * 
 * 
 * 
 */
//Reciever 1
class Torch {
    public void turnOn() {
        System.out.println("turn on the Torch");
    }
}

//Reciever 2
class Ring {
    public void turnOn() {
        System.out.println("Ring on");
    }
}

class ButtonT{
    Torch theTorch;
    public ButtonT(Torch theTorch){
        this.theTorch = theTorch;
    }
    public void pressed(){
        theTorch.turnOn();
    }

}


class ButtonR{
    Ring Ring;
    public ButtonR(Ring Ring){
        this.Ring = Ring;
    }
    public void pressed(){
        Ring.turnOn();
    }
}


class Client1{    
    public static void main(String args[]){
        Torch Torch = new Torch();
        ButtonT TorchBt = new ButtonT(Torch);
        TorchBt.pressed();

        Ring Ring = new Ring();
        ButtonR RingBt = new ButtonR(Ring);
        RingBt.pressed();
    }
}









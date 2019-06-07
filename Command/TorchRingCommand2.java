/**
 * Torch와 Ring이라는 객체들이 있다. 
 * 각각의 버튼은 이 둘을 association한다.
 * 횃불 버튼이 눌리면 횃불을 켠다.
 * 종 버튼이 눌리면 종을 울린다.
 * 
 * 버튼을 누르면 작동한다는 비슷한 기능이 있으니 묶을 수 있다. 
 * 일일히 두개 다 따로 따로 만들지 않아도 된다. 
 * 
 *  전략:
 *      버튼을 누르면 작동을 하는 방법은 유지한다. 
 *      횃불과 종 대신에 command interface을 만든다. 
 *      concrete command는 connmand interface을 상속하고, 횃불과 종을 association한다. 
 *      concrete command: ramp command, ring command
 *       
 * **/


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

//Invoker
class Button{
    Command command;
    public Button(Command command){
        this.command = command;
    }
    public void setCommand(Command command){
        this.command = command;
    }
}

//Command interface
interface Command{
    void execute();
}

//Concrete Command
class RingCommand implements Command{
    Ring alram;

    public RingCommand(Ring alram){
        this.alram = alram;
    }

    @Override
    public void execute(){
        alram.turnOn();
    }
}

//Concrete Command
class TorchCommand implements Command{
    Torch Torch;
    public TorchCommand(Torch Torch){
        this.Torch = Torch;
    }

    @Override
    public void execute(){
        Torch.turnOn();
    }
}


//Client
class Client2{
    public static void main(String[] args) {
        Torch l = new Torch();
        Command c = new TorchCommand(l);
        c.execute();

        Ring a = new Ring();
        c = new RingCommand(a);
        c.execute();

    }
}
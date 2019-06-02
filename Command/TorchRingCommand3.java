


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
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
 *      버튼을 누르면 작동을 하는 방법은 유지한다. 버튼은 press method을 가지고 있다.
 *      버튼이 press을 실행하면 버튼에 연결되어 있는 기능이 실행되어야 한다. 
 *      
 *      버튼을 횃불과 종으로 바로 연결하는 대신에 command interface을 만든다.
 *          command interface을 매개로 횃불과 종을 연결한다.
 *              이렇게 하는 이유는 이렇게 하면 버튼 자체를 뜯어 고치지 않아도 되기 때문이다. 
 *              client에서만 변경을 시켜주면 된다. 
 *      버튼은 command interface을 navigation arrow한다. 
 *          버튼은 command을 attribute으로 가지고 있다. 자유롭게 사용하기 위해서이다. 
 *          버튼은 command을 constructor으로 attribute에 저장한다.  
 *          버튼은 pressd method에 command interface의 instance와 command interface의 execute method을 사용한다.
 *              execute method는 하위 class에서 구현된다.
 *              command interface는 execute method을 가진다.
 *      concrete command는 connmand interface을 상속하고, 횃불과 종을 navigation arrow한다. 
 *      concrete command: ramp command, ring command
 *          횃불과 종을 attribute으로 가지고 있다. 
 *          횃불과 종의 instance을 constructor으로 attribute에 저장한다. 
 *      concnrete command의 method:
 *          execute: 횃불이나 종의 작동을 실행한다. 
 *          작동을 실행할 때 attribute에 저장된 instance을 사용한다.
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
    public void pressed(){
        command.execute();
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
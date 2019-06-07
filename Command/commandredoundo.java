/**
 * Command.java 설명: 
    * Torch와 Ring이라는 객체들이 있다. 각각의 버튼은 이 둘을 association한다. 횃불 버튼이
    * 눌리면 횃불을 켠다. 종 버튼이 눌리면 종을 울린다.
    * 
    * 버튼을 누르면 작동한다는 비슷한 기능이 있으니 묶을 수 있다. 일일히 두개 다 따로 따로 만들지 않아도 된다.
    * 
    * 전략: 버튼을 누르면 작동을 하는 방법은 유지한다. 버튼은 press method을 가지고 있다. 버튼이 press을 실행하면 버튼에
    * 연결되어 있는 기능이 실행되어야 한다.
    * 
    * 버튼을 횃불과 종으로 바로 연결하는 대신에 command interface을 만든다. command interface을 매개로 횃불과 종을
    * 연결한다. 이렇게 하는 이유는 이렇게 하면 버튼 자체를 뜯어 고치지 않아도 되기 때문이다. client에서만 변경을 시켜주면 된다. 버튼은
    * command interface을 navigation arrow한다. 버튼은 command을 attribute으로 가지고 있다. 자유롭게
    * 사용하기 위해서이다. 버튼은 command을 constructor으로 attribute에 저장한다. 버튼은 pressd method에
    * command interface의 instance와 command interface의 execute method을 사용한다. execute
    * method는 하위 class에서 구현된다. command interface는 execute method을 가진다. concrete
    * command는 connmand interface을 상속하고, 횃불과 종을 navigation arrow한다. concrete
    * command: ramp command, ring command 횃불과 종을 attribute으로 가지고 있다. 횃불과 종의
    * instance을 constructor으로 attribute에 저장한다. concnrete command의 method: execute:
    * 횃불이나 종의 작동을 실행한다. 작동을 실행할 때 attribute에 저장된 instance을 사용한다.
 * 
 * Commandredoundo.java 설명: 
    * command interface가 존재하는 이유는 command pattern.md에도
    * 나와있다. command interface가 존재하면서 command들을 가지고 더 유연하게 조잡한 것들을 조합시킬 수 있다. 일례로
    * commnad으로 list을 만들어서 Redu와 Undo command도 만들 수 있다. 
    * 만약 [Command iterface의 유무의 비교](./Command\2_&_3_Comparison_and_Why.PNG)에서도 보는 것처럼
    * 그냥 template method으로만 구현했다면 List을 만들기 위해서는 새로운 navigation arrow가 template class에 작동하거나 할 것이다.
 * 
 **/

import java.util.List;
import java.util.ArrayList;

//Reciever 1
class Torch {
    public void turnOn() {
        System.out.println("\tturn on the Torch");
    }

    public void turnOff(){
        System.out.println("\tTorch off");
    }
}

// Reciever 2
class Ring {
    public void turnOn() {
        System.out.println("\tRing on");
    }

    public void turnOff(){
        System.out.println("\tRing off");
    }
}

//Invoker
class Button{
    Command command;
    List<Command> redo = new ArrayList<>();
    List<Command> undo = new ArrayList<>();
    
    public Button(){}

    public Button(Command command){
        this.command = command;
    }
    public void setCommand(Command command){
        this.command = command;
    }
    public void pressed(){
        command.execute();

        //new feature in redo and undo
        undo.add(command);
    }

    //new feture in redo
    //after undo, redo feature can be activated
    public void redo(){
        try{
            Command cmd = redo.get(redo.size()-1);
            cmd.execute();
            redo.remove(cmd);
            undo.add(cmd);
        }catch(Exception e){
            System.out.println("\tThere is no action redo");
        }
    }

    //new feture undo
    //after execute one action, undo feature can be activated.
    //
    public void undo(){
        try{
            Command cmd = undo.get(undo.size()-1);
            cmd.undo();
            undo.remove(cmd);
            redo.add(cmd);
        }catch(Exception e){
            System.out.println("\tThere is not action undo");
        }
    }

}

//Command interface
interface Command{
    void execute();
    void undo();
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


    @Override
    public void undo(){
        alram.turnOff();
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


    @Override
    public void undo(){
        Torch.turnOff();
    }
}

enum Choice{
    TORCH(0), 
    RING(1), 
    REDO(2), 
    UNDO(3),
    QUIT(4);

    private int val;

    private Choice(int val){
        this.val = val;
    }

    public int getValue(){
        return val;
    }
}

//Client
class Client3{
    public static void main(String[] args) {
        

        int choice;
        // Command cmd;
        Button bt = new Button();
        Torch tch = new Torch();
        Ring rng = new Ring();
        
        System.out.print("----------Menu---------\n*\tTorch: 0\t*\n*\tRing: 1\t*\n*\tRedo: 2\t*\n*\tUndo: 3\t*\n*\tQuit: 4\t*\n-----------------------\n" );
        do{
            System.out.print("Your input: ");
            java.util.Scanner scan = new java.util.Scanner(System.in);
            choice = scan.nextInt();



            //torch mode
            if(choice == Choice.TORCH.getValue()){
                Command cmd = new TorchCommand(tch);
                bt.setCommand(cmd);
                bt.pressed();
            }
            
            //ring mode
            if(choice == Choice.RING.getValue()){
                Command cmd = new RingCommand(rng);
                bt.setCommand(cmd);
                bt.pressed();
            }

            //undo mode
            if(choice == Choice.UNDO.getValue()){
                bt.undo();
            }

            if(choice == Choice.REDO.getValue()){
                bt.redo();
            }
        }while(choice != Choice.QUIT.getValue());
    }
}
/**
 * 
 * 
 * Template Method 패턴 적용
 */

import java.util.Scanner;

class Driver{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Context = Concrete Context
        Duck engel = new EngelDuck();
        engel.fly();    //Context references interface and its function
        engel.move();   //interface is set to concret through concrete context


        Duck normal = new NormalDuck();
        normal.fly();
        normal.move();

        Duck light = new LightningDuck();
        light.fly();
        light.move();
        // Flying mode test
        // while(true){
        //     System.out.println("choice fly mode");
        //     System.out.println("\tfloat: 1\n\twing: 2\n\tquit: 0");
        //     int choice = input.nextInt();
        //     if(choice == 0)
        //         break;
            
        //     Duck duck = new Duck();
            
        //     if(choice == 1){
        //         duck.setFly("F");
        //     }
        //     else if(choice == 2){
        //         duck.setFly("W");
        //     }
        //     else{
        //         System.out.println("Wrong number!");
        //         continue;
        //     }

        //     duck.fly();
        // }//while

        
        System.out.println("BaBye~~!");
        input.close();
    }

}

enum Fly{
    FLOAT(1),
    WING(2);

    private int val;
    private Fly(int i){
        this.val = i;
    }
    public int getValue(){
        return val;
    }
}

//Context 
abstract class Duck{
    InterfaceFly ff;
    InterfaceMove mv;

    public void fly(){
        //print who this is. Using template pattern.
        WhoIs();
        ff.execute();
    }

    public void move(){
        // print who this is. Using template pattern.
        WhoIs();
        mv.execute();
    }


    public void setFly(String str){
        try{
            if(str.compareTo("F") == 0)
                this.ff = new Float();
            else if(str.compareTo("W") == 0)
                this.ff = new Wing();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void test(){
        System.out.println("test...");
    }

    public abstract void  WhoIs();
}

//Concrete Conext 
class NormalDuck extends Duck{
    public NormalDuck(){
        this.ff = new Float();
        this.mv = new Walk();
    }

    // hook method
    public void WhoIs(){
        System.out.print("NormalDuck: ");
    }
}

// Concrete Conext
class EngelDuck extends Duck{
    public EngelDuck(){
        this.ff = new Wing();
        this.mv = new Walk();
    }

    // hook method
     public void WhoIs(){
        System.out.print("Engel Duck: ");
    }
}

// Concrete Conext
class LightningDuck extends Duck{
    public LightningDuck(){
        this.ff = new Wing();
        this.mv = new Sprint();
    }

    //hook method
    public void WhoIs(){
        System.out.print("Lightning Duck: ");
    }
}

//Strategy Interface
interface InterfaceFly{
    void execute();
}

//Concrete Strategy
class Float implements InterfaceFly{
    public void execute(){
        System.out.println("Float");
    }
}

// Concrete Strategy
class Wing implements InterfaceFly{
    public void execute(){
        System.out.println("Wing");
    }
}

// Strategy interface
interface InterfaceMove{
    void execute();
}

// Concrete Strategy
class Walk implements InterfaceMove{
    public void execute(){
        System.out.println("walk");
    } 
}

// Concrete Strategy
class Sprint implements InterfaceMove{
    public void execute(){
        System.out.println("sprint");
    }
}
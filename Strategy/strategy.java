import java.util.Scanner;

class Driver{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.println("choice fly mode");
            System.out.println("\tfloat: 1\n\twing: 2\n\tquit: 0");
            int choice = input.nextInt();
            if(choice == 0)
                break;
            
            Duck duck = new Duck();
            
            if(choice == 1){
                duck.setFly("F");
            }
            else if(choice == 2){
                duck.setFly("W");
            }
            else{
                System.out.println("Wrong number!");
                continue;
            }

            duck.fly();


        }
        System.out.println("BaBye~~!");
        input.close();
    }//main

}//Driver

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

class Duck{
    InterfaceFly ff;
    InterfaceMove mv;

    public void fly(){
        ff.execute();
    }

    public void move(){
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

}


interface InterfaceFly{
    void execute();
}

class Float implements InterfaceFly{
    public void execute(){
        System.out.println("Float");
    }
}

class Wing implements InterfaceFly{
    public void execute(){
        System.out.println("Wing");
    }
}


interface InterfaceMove{
    void execute();
}

class Walk implements InterfaceMove{
    public void execute(){
        System.out.println("walk");
    } 
}

class Sprint implements InterfaceMove{
    public void execute(){
        System.out.println("sprint");
    }
}
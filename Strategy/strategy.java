class Duck{
    public static void main(String[] args) {
        
        Fly ff;
        Move mv;
    
        ff = new Float();
        ff.fly();
        mv = new Sprint();
        mv.move();
    }
    

}

interface Move{
    void move();
}

interface Fly{
    void fly();
}

class Float implements Fly{
    public void fly(){
        System.out.println("Float");
    }
}

class Wing implements Fly{
    public void fly(){
        System.out.println("Wing");
    }
}

class Walk implements Move{
    public void move(){
        System.out.println("walk");
    } 
}

class Sprint implements Move{
    public void move(){
        System.out.println("sprint");
    }
}
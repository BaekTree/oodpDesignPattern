/**
 * goodcode4
 * 
 * Client는 더 이상 concrete 클래스인 ClassOne, ClassTwo에 의존하지 않고, 대신 ClassFactory 클래스에 의존한다. 
 * Concrete class들의 변화에 직접적으로 Client가 수정을 당하지 않아도 된다. 
 * 
 * 여기서 만약... ClassOne과 CalssTwo의 종류가 상속을 통해서 세분화된다면? 
 * OneClass는 OneClassA와 OneClassB으로 나뉘어진다. OneClass는 더 이상 concrete class가 아니다. 
 * Factory Class가 만들어내는 Object의 클래스가 세분화될 때 사용하는 패턴이 Factory Method 패턴이다. 
 * 
 * Factory도 abstract Factory
 * 
 * SOLID원칙!
 * 특히 책임! 
 * 이제 ClassOne과 ClassTwo의 의미가 달라지기 시작한다
 * Factory의 책임이 커진다! 분리해야 한다!
 * 
 * 번외편: ClassOne만 세분화하기! 
 * 
 * **/
interface InterfaceOne {
    void method();
}

//ClassOne에 child Class들이 발생.
//변화할 부분: method... -> interface으로 만든다!
/*
class ClassOne implements InterfaceOne {
    public void method(){
        System.out.println("one method");
    }
}
*/
interface ClassOne extends InterfaceOne{
    void method();
}

class ClassOneA implements ClassOne {
    public void method() {
        System.out.println("oneA method");
    }
}

class ClassOneB implements ClassOne {
    public void method() {
        System.out.println("oneB method");
    }
}

class ClassTwo implements InterfaceOne{
    public void method(){
        System.out.println("two method");
    }
}

//Client
class Client{
    InterfaceOne itf;   //association to InterfaceOne
    // ClassFactory factory = new ClassFactory();
    public void function(){
        itf.method();   //interface에 dependency 되어있다. 구현되는 부분에는 자유롭다.
    }

    public void setItfOne(String str){
        itf = ClassOneFactory.makeOne(str);
    }

    public void setItfTwo(){
        itf = ClassTwoFactory.makeTwo();
    }
}


//factory class -> change to be interface...
class ClassTwoFactory{
    // public static ClassOne makeOne(String str){
    //     return ClassOneFactory.makeOne(str);
    // }

    public static InterfaceOne makeTwo() {
        return new ClassTwo();
    }   
}

class ClassOneFactory{
    public static ClassOne makeOne(String a){
        if("A".equals(a)) return new ClassOneA();
        if("B".equals(a)) return new ClassOneB();
        return null;
    }
}

class Driver{
    public static void main(String[] args) {
        Client client = new Client();
        
        client.setItfOne("A");
        client.function();
    
        client.setItfTwo();
        client.function();
    }
}

/**
 * goodcode3
 * 
 * goodcode2의 문제점: 
 * Client에서 InterfaceOne에 dependency하고 있다.
 * Interface에 해당하는 ClassOne, ClassTwo 등의 instance을 polymorphysm을 통해서 reference해주어야 한다.
 * 그런데 reference하기 위해서 직접적으로 new ClassOne, new ClassTwo등을 사용했었다.
 * ClassOne, ClassTwo는 concerete class으로써, 이 class들에 직접적으로 dependency 하게 되면 concrete 클래스에 변경이 생길 때
 * (새로운 attributes을 추가해서 constructor에 변화가 생긴다던지, method에 parameter가 추가되어야 한다든지...)
 * Client에서도 똑같이 바꿔줘야 했다.
 * 
 * Class factory class 의 도입으로 Client는 이제 직접 ClassOne, ClassTwo에 dependency하지 않는다.
 * 대신 Client는 ClassFactory 에 dependency 한다.
 * ClassFactory가 대신 ClassOne, ClassTwo에 dependency한다.
 * 
 * 여전히 Client는 ClssFactory에게서 dependency을 끊을 수는 없다. 그러나 직접적으로 concrete class들에 dependency 하는 것보다는 
 * 높은 유연성을 얻는다.
 * 왜? 
 *  비교해보자...
 *  ClassTwo의 method가 변경되었다.
 *  ClassThree가 생겼다.
 *  
 * 
 * 
 * **/
import java.lang.Math;
interface InterfaceOne {
    void method();
}

class ClassOne implements InterfaceOne {
    public void method(){
        System.out.println("one method");
    }
}

//ClassTwo method 변화. attribute 추가
class ClassTwo implements InterfaceOne{
    private int j;

    public ClassTwo(){}

    public ClassTwo(int j){
        this.j = j;
    }

    public void method(){
        System.out.println("two method");
    }

    public void method(int i){
        System.out.println("two method: int i = " + i);
    }
}

//ClassThree 생성
class ClassThree implements InterfaceOne{
    public void method(){
        System.out.println("three method");
    }
}

class Client{
    InterfaceOne itf;   //association to InterfaceOne
    public void function(){
        itf.method();   //interface에 dependency 되어있다. 구현되는 부분에는 자유롭다.
    }

    public void setItfOne(){
        itf = ClassFactory.makeOne();
    }

    public void setItfTwo(int num){
        itf = ClassFactory.makeTwo(num);
    }

    //ClassThree을 불러오기 위한 factory 호출
    public void setItfThree(){
        itf = ClassFactory.makeThree();
    }
}

class ClassFactory{
    public static InterfaceOne makeOne(){
        return new ClassOne();
    }

    public static InterfaceOne makeTwo(int num) {
        return new ClassTwo(num);
    }

    //ClassThree instance 만들기 위한 method 생성
    public static InterfaceOne makeThree(){
        return new ClassThree();
    }
    
}

class Driver{
    public static void main(String[] args) {
        Client client = new Client();
        
        client.setItfOne();
        client.function();
    
        int rand = (int)(Math.random()*10)+1;
        client.setItfTwo(rand);
        client.function();

        //main에서 clientThree 추가
        client.setItfThree();
        client.function();
    }
}

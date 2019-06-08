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
 * 
 * 
 * 
 * **/
interface InterfaceOne {
    void method();
}

class ClassOne implements InterfaceOne {
    public void method(){
        System.out.println("one method");
    }
}

class ClassTwo implements InterfaceOne{
    public void method(){
        System.out.println("two method");
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

    public void setItfTwo(){
        itf = ClassFactory.makeTwo();
    }
}
<<<<<<< HEAD
=======

>>>>>>> 8db5f3c1ce864e048bc91a72bad2eea5511d05c5

class ClassFactory{
    public static InterfaceOne makeOne(){
        return new ClassOne();
    }

<<<<<<< HEAD
class ClassFactory{
    public static InterfaceOne makeOne(){
        return new ClassOne();
    }

=======
>>>>>>> 8db5f3c1ce864e048bc91a72bad2eea5511d05c5
    public static InterfaceOne makeTwo() {
        return new ClassTwo();
    }
    
}

class Driver{
    public static void main(String[] args) {
        Client client = new Client();
        
        client.setItfOne();
        client.function();

        client.setItfTwo();
        client.function();
    }
}

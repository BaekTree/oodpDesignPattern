/**
 * goodCode1.java
 * 문제가 있는 코드
 * 문제점:
 * Client는 ClassOne에 dependency 한다.
 * 그런데 ClassOne은 구현책임을 가지고 있어서 concrete하게 구현되어 있다.
 * 따라서 만약 ClassOne의 attribute나 method가 변경되거나, ClassOne과 비슷한 ClassTwo를 만들게 되면,
 * Client을 뜯어고치거나(new ClassOne()의 코드 등), 새로운 ClassTwo을 다룰 Client2를 만들어야 한다.
 * 코드 중복이 발생한다. 진짜 귀찮음.
 * 
 * 
 * **/


class ClassOne{
    public void method(){
        System.out.println("one method");
    }
}

class Client{
    ClassOne cls = new ClassOne();  // 문제점 1: classOne에 dependency 되어있다. 
    
    public void function(){ 
        cls.method();               //문제점2: classOne에 method도 dependency 되어있다. 
                                    //만약 ClassOne이 변경되면 다 싸그리 고쳐야 한다.
    }
    
}

class Driver1{
    public static void main(String[] args) {
        Client client = new Client();
        client.function();
    }
}

///////////////////////////////////////What if we add ClassTwo?///////////////////////////////////
class ClassTwo{
    public void method(){
        System.out.println("two method");
    }
}


/////////////////////We need to implement Cleint2/////////////////////////////////
class Client2 {
    ClassOne cls = new ClassOne(); // classTwo에 dependency 되어있다.

    public void function() {
        cls.method(); // classTwo에 method도 dependency 되어있다.
                      // 만약 classTwo에 변경되면 다 싸그리 고쳐야 한다.
    }
}
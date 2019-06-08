/**
 * goodcode3
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
        this.itf = new ClassOne();  //실제 ClassOne에 dependency 되어있다.
                                    // ClassOne에 수정이 발생하면 이 부분도 수정해주어야 한다.
    }

    public void setItfTwo(){
        this.itf = new ClassTwo();// 실제 ClassTwo에 dependency 되어있다.
                                  // ClassTwo에 수정이 발생하면 이 부분도 수정해주어야 한다.
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

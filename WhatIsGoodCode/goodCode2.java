/**
 * goodCode.java
 * 
 * 
 * **/
interface OneInterface {
    void method();
}

class OneClass implements OneInterface {
    public void method(){
        System.out.println("one method");
    }
}

class TwoClass implements OneInterface{
    public void method(){
        System.out.println("two method");
    }
}

class Client{
    OneInterface itf;   //association to OneInterface
    
    public void function(){
        itf.method();   //interface에 dependency 되어있다. 구현되는 부분에는 자유롭다.
    }

    public void setItfOne(){
        this.itf = new OneClass();  //실제 OneClass에 dependency 되어있다.
                                    // OneClass에 수정이 발생하면 이 부분도 수정해주어야 한다.
    }

    public void setItfTwo(){
        this.itf = new TwoClass();// 실제 TwoClass에 dependency 되어있다.
                                  // TwoClass에 수정이 발생하면 이 부분도 수정해주어야 한다.
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

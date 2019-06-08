/**
 * goodCode2.java
 * goodCode1의 문제점을 해결하고자...
 * goodCode1의 문제점은... Client가 concrete하게 구현된 ClassOne에 dependency되어 있었다.
 * 두 부분에 dependency 되어 있다.
 **** 첫번째는 new reference으로 instnace을 생성할 때
 **** 두번째는 ClassOne의 instance으로 method을 호출할 때
 * 이로 인한 문제점은 ClassOne이 수정되거나, ClassOne과 비슷한 ClassTwo가 만들어지면 
 * Client를 수정하거나, 새로운 Client를 만들어줘야 한다는 것이다.
 * 
 * 해결책: 계약책임을 가지는 interface을 정의한다.
 * Client에서 ClassOne에 대한 dependency를 줄여야 한다.
 * concrete한 ClassOne이 아니라 soft한 Interface을 ClassOne과 Client 사이에 두어야 한다.
 * 두번째 문제점 해결하기!
 ***** InterfaceOne을 만들고, ClassOne이 가지는 method를 선언해준다. 
 ***** ClassOne은 InterfaceOne을 구현한다.
 ***** Client는 ClassOne대신에 InterfaceOne에 dependency한다.
 * 
 * 여전히 문제점 1은 그대로 가지고 있다.
 * Client의 function은 InterfaceOne의 method으로 구현했어서 ClassOne에 대한 직접적인 dependency는 피했지만
 * Client에서 InterfaceOne에 어떤 instance을 줄지 결정하는 setFunction은 직접적으로 new ClassOne, new ClassTwo
 * 으로 dependency하고 있다.
 * 
 * 
 * goodcode22.java
 * 실제로 ClassTwo에 변화가 생긴다면? 얼마나 많은 부분을 고쳐야 할까?
 * ClassTwo에 attribute을 추가하고
 * constructor을 변화시키고
 * method에 parameter을 추가해보자!
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

class ClassTwo implements InterfaceOne{ //ClassTwo 변화
    private int i;                      // attribute 추가
    private int j;

    public ClassTwo(int i){             //constructor 추가
        this.i = i;
        this.j = i + 2;                     
    }

    public void method(){
        System.out.println("two method: attribute int i : " + i);
    }


    //이걸 이렇게 만들면 단일책임원칙을 위반하는가? Single Responsibility Principle?
    //새로운 class으로 만들어야 하는가?
    public void methodTwo(int k){
        System.out.println("two methodTwo: attribute int k : " + k);
    }
}


class Client{
    InterfaceOne itf;   //association to InterfaceOne
    public void function(){
        //여기서 strategy라도 써줘야 하나?
        itf.method();   //interface에 dependency 되어있다. 구현되는 부분에는 자유롭다.
    }

    public void setItfOne(){
        this.itf = new ClassOne();  //실제 ClassOne에 dependency 되어있다.
                                    // ClassOne에 수정이 발생하면 이 부분도 수정해주어야 한다.
    }

    public void setItfTwo(int num){
        this.itf = new ClassTwo(num);// 실제 ClassTwo에 dependency 되어있다.
                                  // ClassTwo에 수정이 발생하면 이 부분도 수정해주어야 한다.
                                  // ClassTwo의 변화에 따라서 Client도 변화되었다.
    }


}

class Driver{
    public static void main(String[] args) {
        Client client = new Client();
        
        client.setItfOne();
        client.function();

        client.setItfTwo(22);
        client.function();
        client.
    }
}

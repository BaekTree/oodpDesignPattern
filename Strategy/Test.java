/**
 * # Instance Method 이미 알고 있던 것
 * 
 * 
 * >instance method는 instance var, static var, static method, instance method을
 * 모두 호출 가능 static method는 static method, static var만 사용가능. instance var,
 * instance method는 사용 불가능 >
 * 
 * 여기서 해석 가능한 사실 >instance method 안에서 다른 instance method을 호출할 때, instance을 또 다시
 * 안붙여도 된다.
 */

class Test{
    public void print(){
        System.out.println("instance method");
    }

    public void method(){
        print();
    }

    public static void main(String[] args) {

    }
}
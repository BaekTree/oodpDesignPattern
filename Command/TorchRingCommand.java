class Torch {
    public void turnOn() {
        System.out.println("turn on the Torch");
    }
}

class Ring {
    public void turnOn() {
        System.out.println("Ring on");
    }
}

class ButtonT{
    Torch theTorch;
    public ButtonT(Torch theTorch){
        this.theTorch = theTorch;
    }
    public void pressed(){
        theTorch.turnOn();
    }

}


class ButtonR{
    Ring Ring;
    public ButtonR(Ring Ring){
        this.Ring = Ring;
    }
    public void pressed(){
        Ring.turnOn();
    }
}

// 버튼이 알람과 램프에 각각 구분되어 있을 때.
// 다른 버튼도 생긴다면?
// 클래스를 추가, 새 버튼을 추가, 새 버튼을 구현, main에도 새로 구현.
// 하나의 버튼으로 모든 것을 다 조종할 수는 없을까?
// command 디자인 패턴!
class Client1{    
    public static void main(String args[]){
        Torch Torch = new Torch();
        ButtonT TorchBt = new ButtonT(Torch);
        TorchBt.pressed();

        Ring Ring = new Ring();
        ButtonR RingBt = new ButtonR(Ring);
        RingBt.pressed();
    }
}









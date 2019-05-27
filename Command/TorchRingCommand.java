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

// ��ư�� �˶��� ������ ���� ���еǾ� ���� ��.
// �ٸ� ��ư�� ����ٸ�?
// Ŭ������ �߰�, �� ��ư�� �߰�, �� ��ư�� ����, main���� ���� ����.
// �ϳ��� ��ư���� ��� ���� �� ������ ���� ������?
// command ������ ����!
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









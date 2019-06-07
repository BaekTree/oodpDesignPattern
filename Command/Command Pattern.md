# Command Pattern #
## Command_before_pattern class
* 패턴을 적용하지 않은 상태이다.
* 각각의 횃불과 종 마다 모두 개별 버튼을 만들어줘야 한다.
*  코드가 반복된다.


## Command class
 * Torch와 Ring이라는 객체들이 있다. 
 * 각각의 버튼은 이 둘을 association한다.
 * 횃불 버튼이 눌리면 횃불을 켠다.
 * 종 버튼이 눌리면 종을 울린다.
 
 * 버튼을 누르면 작동한다는 비슷한 기능이 있으니 묶을 수 있다. 
 * 일일히 두개 다 따로 따로 만들지 않아도 된다. 
 
 *  전략:
    * 버튼을 누르면 작동을 하는 방법은 유지한다. 버튼은 press method을 가지고 있다.
    * 버튼이 press을 실행하면 버튼에 연결되어 있는 기능이 실행되어야 한다. 
    * 버튼을 횃불과 종으로 바로 연결하는 대신에 command interface을 만든다.
        * command interface을 매개로 횃불과 종을 연결한다.
        * 이렇게 하는 이유는 이렇게 하면 버튼 자체를 뜯어 고치지 않아도 되기 때문이다. 
        * client에서만 변경을 시켜주면 된다. 
    * 버튼은 command interface을 navigation arrow한다. 
        * 버튼은 command을 attribute으로 가지고 있다. 자유롭게 사용하기 위해서이다. 
        * 버튼은 command을 constructor으로 attribute에 저장한다.  
        * 버튼은 pressd method에 command interface의 instance와 command interface의 execute method을 사용한다.
            * execute method는 하위 class에서 구현된다.
            * command interface는 execute method을 가진다.
        *  concrete command는 connmand interface을 상속하고, 횃불과 종을 navigation arrow한다. 
    *  concrete command: ramp command, ring command
        * 횃불과 종을 attribute으로 가지고 있다. 
        * 횃불과 종의 instance을 constructor으로 attribute에 저장한다. 
    *  concnrete command의 method:
        * execute: 횃불이나 종의 작동을 실행한다. 
        * 작동을 실행할 때 attribute에 저장된 instance을 사용한다.

## WhyCommand.java##
* 사실상 버튼 -> command -> concrete command -> 객체의 순서로 연결되는 것이 너무 많은 과정이 소요되는 것처럼 보였다. 
* 그냥 template method 패턴을 사용해서, 버튼을 command 처럼 생각해서 버튼을 abstract class으로 만들고, pressed을 abstract method으로 선언한다. 
* RingButton, TorchButton이 버튼을 상속하여, 
concrete command의 역할로써 torch와 Ring class을 navigate arrow해서 instance을 받고, hook method 을 torch와 ring의 instance의 함수를 호출하는 body로 구현한다.<br>
* 그림: [**WhyCommand와 Command의 비교**](./2_&_3_Comparison_and_Why.PNG)
* 이렇게 하면 같은 기능이지만 중간에 command을 없앨 수 있어 훨씬 간단하게 기능을 구현할 수 있지 않을까?하는 의문이 있다.
* ***<p style='color:lightgreen'>그럼에도 comand interface을 중간에 사용하는 이유는?? <br>-> 중간에 command을 넣으면 다양한 command을 사용할 수 있기 때문이다. Command의 종류가 많다면? Command을 사용해서 redo, undo등의 command집합을 이용해서 조합도 할 수 있다. 일반적으로 말해서 확장에 열어두기 위해 command interface을 사용하는 것이다.<p/>***



## command.mdj ##
starUML으로 열면 다이어그램이 나온다. whyCommand 와 command.java 모두 그려져 있다. 
# Strategy Design Pattern #
## Component
* Description:
    * 동일한 목적을 가지고 같은 기능을 하는 다양한 방법들이 있을 때, 그 방법들을 모두 class으로 만든다.
    * 같은 목적에 따라 어떤 방법을 사용할지를 선택하기 때문에, 전략 패턴이라고 불린다. DuckA는 날기 위해서 ㄱ방법을 사용한다. DuckB는 날기 위해서 ㄴ방법을 사용한다. 
    * <p style='color:lightblue'>method signiture은 동일해야 한다.<p/>
    
    >* **<p style='color:lightgreen'>차이점 between command pattern, strategy pattern, template method pattern<p/>**
        >   * Command: 
        >        * command 객체를 형성한다. 
        >        * 하나의 command에 object와 그 object의 method가 모두 들어간다. 
        >        * 각 command 마다 목적이 다르다.
        >        * ##### invoker과 recierver가 있다. 
        >   * Strategy: 
        >        * 같은 목표를 가지고 있다.
        >        * 어떻게? How to? 가 다르고, 그 How to가 Object을 구성되어 있다.
        >   * Template method:
        >       * 상속을 통해서 같은 parent type을 가진 class 들이 각자 다른 method을 구현하게 만든다. 
        >       * 주로 상속관계가 이미 주어져 있을 때, template가 이미 주어져 있을 때 사용한다.
* **Components**
    * Strategy Interface: 다양한 기능과 알맞은 객체를 조립한다.  abstract method을 선언한다. 
    * Concrete class, which implements interface: interface의 abstract method을 구현한다. 기능들 마다 하나의 class으로써 구현된다. 
    * Context:  알고리즘 부분을 interface으로 넘긴다. interface에 객체를 넣어서 interface의 method만을 사용해서 다양한 기능을 실행시킨다.
* 일반적인 상속의 문제점:
    * 공통되는 부분을 parent class가 맡는다. 캡슐화.
    * child class 마다 다르게 동작하는 부분이 있다. 
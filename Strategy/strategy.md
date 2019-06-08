# Strategy Design Pattern #
## Component
* Description:
    * 동일한 목적을 가지고 같은 기능을 하는 다양한 방법들이 있을 때, 그 방법들을 모두 class으로 만든다.
    
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
        >    * 상속을 통해서 같은 parent type을 가진 class 들이 각자 다른 method을 구현하게 만든다. 
* **Components**
    * Strtegy class
    * Interface
    * concrete class, which implements interface
* 
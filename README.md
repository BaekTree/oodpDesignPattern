# oodpDesignPattern
## Command
## Focade
## Strategy

# UML Diagram
### Kinds of arrows ; Association, Aggregation, Composition, Dependency
#### 더 큰 집합 순서: Association > Aggregation > Composition > Dependency
* **Associattion**: 
    * An object of one class ***may use*** services/methods provided by an object of another class. 
    * 아래 모든 다른 관계들의 일반적인 표현이다.

* **Aggregation**: 
    * ***may use*** relationship -> ***owns*** relationship
    * ***Has - A*** relationship. ***Whole*** has a ***Part***. 
    * 양방향일 수 없다. 한쪽이 부분이면, 다른 한쪽은 전체이어야 한다.
    * i.e. 
        * Car has wheels이지만, 사용할 때에는 A wheel ***is a part of*** a car 이라고 사용한다.
        * Wheel -<> Car
    ```
    class wheel{
        move();
    }
    class car{
        wheel w;    //use wheel
        w.move();   //use wheel mothod
    }
    ```
* **Composition**: 
    * **Aggregation** with shared ***life time***.
    * fingers -<#> Hand
    * 손이 사라지면 손가락도 모두사라진다.
    * Hand instance가 body에서 사라지면, fingers도 모두 사라진다.
    ```
    class finger{

    }
    
    class hand{
        List<finger>;
        finger instance;
        List add finger instance
    }
    
    class body{
        hand instance;

    }
    ```
* **Dependency**: 
    * **Aggregation** with giving an effect with change
    * dependency되면 delegation된다?
    * reference: 
        * 다른 objects을 불러다가 자기의 method에 사용한다.
        * 불려져서 끌려오는 object의 상태나 값에 따라 자기의 값도 변화하기 때문에 dependency한 것이다.
        * parameter로 끌고 오기도 한다.
        * return type으로 끌고 오기도 한다.
        * new 으로 생성하기도 포함.


# Instance Method
* 이미 알고 있던 것


>instance method는 instance var, static var, static method, instance method을 모두 호출 가능
static method는 static method, static var만 사용가능. instance var, instance method는 사용 불가능
>
 
* 여기서 해석 가능한 사실
>instance method 안에서 다른 instance method을 호출할 때, instance을 또 다시 안붙여도 된다.

##패턴의 부재에서 오는 문제점들
* 동일한 코드의 중복
    * 코드를 수정할 때 여러 동일한 성질을 가진 클래스들을 모두 돌아다니면서 수정해야 한다. 
    * normal duck의 크기 확대 -> 다른 모든 duck의 크기도 다 고쳐야 한다.
    * client에서 normal duck의 
    * 코드 재사용 불가
    * 상속으로 해결할 수 있다.

* 의존성이 커진다
    * 한 클래스를 수정하면 그에 연결되어 있는 모든 클래스들을 다 수정하거나 새로 만들어야 한다.
    * 버튼에 한 종류의 기계만 연결시킨다면, 새로운 기계를 추가할 때 새로운 버튼을 만들어야 한다. 
    * 각 버튼들은 동일한 기계를 가지고 있다.
    * 큰 버튼을 interface으로 만든다. 
    * Interface(그리고 abstract class, 혹은 그냥 상속을 통한 parent class)을 사용하는 경우
        * Interface에 변화가 있을 경우, client에서는 그 부분만 수정해주면 된다. 
    
    attribute의 이름, 타입, 초기값 수정
    method의 이름, 파라미터, body, return 타입 수정
# oodpDesignPattern
## What is good code?
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

# Factory #
## Factory Method
* 생성해야 하는 class들이 여러 종류일 때, 하나의 공장은 하나의 Class 만 맡는 것이 좋다. SRP, 단일책임원칙!
* 하나의 factory에서 생성하는 class가 상속 관계를 가질 때 사용하는 것이 factory method 패턴이다!
* 각각의 상속 class 마다 상속 factory을 만들어준다! 왜 굳이?
    * 피자
        * 뉴욕 피자
            * 여러 피자 종류들...
        * 시카고 피자
            * 여러 피자 종류들...
    * 피자 factory
        * NY fac
            * each pizza... 
        * Chi fac
            * each pizza...
    * 뉴욕 피자와 시카고 피자가 다른 점이 있다. 그 다른 점을 해결하기 위해서 분리해준다... 
        * 다른 점은 override 같은 형태로 나타날 수 있다...
    * 그래도 여전히 동일한 공장에서 만들어줘도...? 
# Observer Pattern
## UML diagram
### Components
* Publisher interface
    * add
    * delete
    * notify
* Observer interface
    * update
* NewMachine
    * String news
    * String title
    * ArrayList<Observer>
    * add
    * delete
    * NewMachine
    * setNewsInfo
    * notify
* Subscribers(Subclass of Observer)
    * display
    * update
* 개요
    * publisher는 신문사, observer은 구독자들
    * 구독자들은 항상 대기를 타고 있어서 observer이라는 이름이 붙었다.
    * 신문사들은 뉴스를 받아서 구독자들에게 뿌려준다
    * 신문사들은 구독자에 대한 정보를 가지고 있어서 ArrayList에 저장한다. 
    * 서로 위임하기 위해서 선언된 두 interface가 observer와 publisher
    * NewsMachine을 사용하는 클래스에서 setNewsInfo을 호출한다. 호출할 때, observer에게 전달하는 내용을 parameter으로 보낸다.
    * setNewsInfo -> this.title, this.news을 선언. 그리고 -> notifyOBserver. 
    * NewsMachine의 constuctor은 arrayList을 선언한다. 
    * add 함수는 전달받은 obserber을 list에 저장. delete은 지운다. 
    * notifyOBserver -> ArrayList. list에서 하나씩 observer을 모두 부르면서(for each or iterator), observer은 update을 호출.
    * update은 title, news을 가지고 newstitle을 만든다. 그리고 display을 호출한다.
    * display는 newstitle을 출력
    * subclass의 constructor: 자기 자신을 만들어내면서 동시에 publisher.add을 사용해서 arraylist에 자신을 등록!  
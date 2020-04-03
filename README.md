Java 언어로 배우는 디자인 패턴 입문 정리파일
# Part1 디자인 패턴과 친해지기
## Iterator - 순서대로 지정해서 처리하기
Iterator 패턴
- for 문의 i++ 처럼 i를 하나씩 증가시키면서 사용되는 변수의 기능을 추상화해 일반화한 것을 Iterator 패턴이라 한다. 
- Iterator 패턴이란 무엇인가 많이 모여있는 것들을 순서대로 지정하면서 전체를 검색하는 처리를 실행하기 위한 것이다. 

Iterator 패턴의 등장인물
- Iterator의 역할
  - 요소를 순서대로 검색해가능 인터페이스.
- ConcreateIteator(구체적인 반복자)의 역할
  - Iterator가 결정한 인터페이스를 구현.
  - 예제에서의 BookShelfIterator 클래스.
- Aggregate의 역할
  - Iterator 역할을 만들어내는 인터페이스를 결정.
  - 이 인터페이스는 '내가 가지고 있는 요소를 순서대로 검색해주는 사람'을 만들어내는 메서드.
  - 예제에서의 Aggregate 인터페이스.
- ConcreteAggregate의 역할
  - Aggregate를 실제 구현.
  
독자의 사고를 넓히기 위한 힌트
- 구현에 상관없이 Iterator를 사용할 수 있다. 
  - for문 대신 Iterator를 사용하는 가장 큰이유는 구현과 분리해서 하나씩 셀 수 있기 때문이다. 
  - BookShelf를 구현한 사람이 배열에서 Vector를 사용하도록 수정했다면, BookShelf는 Iterator를 반환하므로 Main 클래스의 while 문은 수정할 필요가 없다.  
- 추상 클래스나 인터페이스는 아무리 해도 서투른데
  - 구체적 클래스만 사용하면 클래스 간의 결합이 강해져, 부품으로 재이용하는 일이 어렵다.  

`연습문제`
```Java
public class BookShelf implements Aggregate {
    private List<Book> books = new ArrayList<>();
    private int last = 0;

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
        last++;
    }

    public int getLength() {
        return last;
    }

    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
```
---
## Adapter - 바꿔서 재이용하기
Adapter 패턴
- 제공되고 있는 것과 필요한 것 사이를 연결해주는 것이 어댑터의 역할이다. 
- 프로그램 세계에서도 이미 제공되어 있는 것을 그대로 사용할 수 없을 때, 필요한 형태로 교환하고 사용하는 일이 자주 있다.
- 이미 제공되어 있는것과 필요한 것 사이의 차이를 없애주는 다자인패턴이 Adapter 패턴이다. 
- Wrapper 패턴이라고 불리기도 한다. 
- Adapter 패턴에는 다음 두 가지 종류가 있다.
  - 클래스에 의한 Adapter 패턴(상속 사용)
  - 인스턴스에 의한 Adapter 패턴(위임 사용)

Adapter 패턴의 등장인물
- Target의 역할
  - 지금 필요한 메서드를 결정.
  - 예제의 Print 인터페이스 or Print 클래스
- Client의 역할
  - Target 역할의 메서드를 사용해 일은 한다. 
  - 예제의 Main 클래스
- Adaptee(개조되는 쪽)의 역할
  - 이미 준비되어 있는 메서드를 가지고 있는 역할. 
  - 예제의 Banner 역할.
  - Adaptee 역할의 메서드가 Target 역할의 메서드와 일치하면 Adapter는 필요가 없다.
- Adapter의 역할
  - Adapter 패턴의 주인공
  - Adaptee 역할의 메서드를 사용해 어떻게든 Target 역할을 만족시키기 위한 것이 Adapter의 임무이다. 
  - 예제의 PrintBanner 클래스
  - 클래스에 의한 Adapter 패턴의 경우 Adapter의 역할은 '상속'을 사용한 Adaptee의 역할을 이용하지만, 인스턴스에 의한 Adapter 패턴의 경우 '위임'을 사용한 Adaptee의 역할을 이용한다. 
  
독자의 사고를 넓히기 위한 힌트
- 어떤 경우에 사용하는 것일까?
  - 우리는 이미 존재하고 있는 클래스를 이용해 프로그래밍 하는 경우가 자주 있다. 
  - Adapter 패턴은 기존의 클래스를 개조해 필요한 클래스를 만든다. 
  - 만약 버그가 발생해도 기존의 클래스(Adaptee의 역할)에는 버그가 없으므로 Adapter 역흴의 클래스를 중점적으로 조사하면 되고, 프로그램 검사도 쉬워진다. 
- 비록 소스가 없더라도
  - Adapter 패턴은 기존의 클래스를 전혀 수정하지 않고 목적한 인터페이스에 맞추려는 것이다. 
  - 또한 Adapter 패턴에서는 기존 클래스의 소스 프로그램이 반드시 필요한것은 아니다.
  - 기존 클래스의 사양만 알면 새로운 클래스를 만들 수 있다.   
- 버전 업과 호환성
  - 구 버전과 신 버전을 공존시키고, 유지와 보수도 편하게 하기 위해 Adapter 패턴이 도움이 되는 경우가 있다. 
  - 신 버전을 Adaptee 역할로 하고, 구 버전을 Target 역할로 한다. 그리고 신 버전의 클래스를 사용해 구 버전의 메서드를 구현하는 Adatper 역할의 클래스를 만든다. 
- 동떨어진 클래스
  - Adaptee 역할과 Target 역할의 기능이 지나치게 동떨어진 경우 Adapter 패턴을 사용할 수 없다. 

---
# Part2 하위 클래스에게 위임하기
## Template Method - 하위 클래스에서 구체적으로 처리하기
템플릿이란 무엇인가?
- 템플릿이란 문자 모양으로 구멍이 뚫려 있는 얇은 플리스틱 판을 말한다.
- 어떤 모양인진 알수 있지만, 필기구에 따라 실제 모양이 결정된다.

Template Method 패턴이란?
- 상위 클래스쪽에 템플릿에 해당하는 메서드가 정의되어 있고, 그 메서드의 정의 안에는 추상 메서드가 사용되고 있다.
- 하위 클래스 측에서 메서드를 구현하면 구체적인 처리가 결정된다.
- 상위 클래스에서 처리의 뼈대를 결정하고, 하위 클래스에서 구체적인 내용을 결정하는 디자인 패턴을 Template Method 패턴이라 한다.

Template Method 패턴의 등장인물
- AbstractClass의 역할
  - 템플릿 메서드를 구현한다.
  - 또한 그 템플릿 메서드에서 사용하고 있는 추상 메서드를 선언한다.
  - 예제의 AbstractDisplay 클래스가 이역할.
- ConcreteClass의 역할
  - AbstractClass 역할에서 정의되어 있는 추상 메서드를 구체적으로 구현한다.
  - 예제의  CharDisplay, StringDisplay 클래스.
 
독자의 사고를 넓히기 위한 힌트
- 로직을 공통화 할 수 있다
  - 상위 클래스의 템플릿 메서드에서 알고리즘이 기술되어 있으므로, 하위 클래스측에서 알고리즘을 일ㅇ리이 기술할 필요가 없다.

---
## Factory Method - 하위 클래스에서 인스턴스 작성하기
Factory Method 패턴
- Template Method 패턴을 인스턴스 생성의 장면에 적용한 것이 Factory Method 패턴이다.
- Factory Method 패턴에서는 인스턴스를 만드는 방법을 상위 클래스 측에서 결정하지만 구체적인 클래스 이름까지는 결정하지 않는다.
- 인스턴스 생성을 위한 골격과 실제 인스턴스 생성의 클래스를 분리해 생각할 수 있다.

Factory Method 패턴의 등장인물
- Product의 역할
  - 이 패턴에서 생성되는 인스턴스가 가져야 할 인터페이스를 결정하는 것은 추상 클래스다.
  - 예제의 Product 클래스
- Creator의 역할
  - new를 사용해 실제 인스턴스를 생성하는 대신, 인스턴스 생성을 위한 메서드를 호출해 구체적인 클래스 이름에 의한 속박에서 상위 클래스를 자유롭게 만든다.
- ConcraeteProduct의 역할
  - 구체적인 제품을 결정
- ConcreteCreator의 역할
  - 구체적인 제품을 만드는 클래스를 결정
 
독자의 사고를 넓히기 위한 힌트
- 인스턴스 생성
  - 에러를 이용한다: 디폴트 구현 내용을 에러로 처리해 두면, 하위 클래스에서 구현하지 않았을 경우 실행할 때 에러가 발생한다.  
---
# 인스턴스 만들기
## Singleton - 인스턴스 한 개 만들기
- 인스턴스가 한 개밖에 존재하지 않는 것을 보증하는 패턴을 Singleton 패턴이라 한다. 
- Singleton 클래스 
  - 프로그래머가 주의해서 new를 하지 않으면 생성자를 private를 하지 않아도 된다. 
  - 그러나 이렇게 하면 싱글턴 패턴이 존재하는 의미가 없다. 
  - 생성자를 private로 해둘 필요가 있다. 

Singleton 패턴의 등장인물
- Singleton의 역할
  - 유일한 인스턴스를 얻기 위한 static 메서드를 가지고 있다. 
  - 이 메서드는 언제나 동일한 인스턴스를 반환한다.  
  
---
## Prototype - 복사해서 인스턴스 만들기
Prototype 패턴
- 클래스 이름을 지정하지 않고 인스턴스를 생성할 때도 있다. 
- 다음의 경우는 클래스로부터 인스턴스를 만드는 것이 아니라 인스턴스를 복사해서 새로운 인스턴스를 만든다.
  - 종류가 너무 많아 클래스로 정리되지 않는 경우
  - 클래스로부터 인스턴스 생성이 어려운 경우
  - framework와 생성할 인스턴스를 분리하고 싶은 경우
- 이와 같이 클래스로부터 인스턴스를 생성하는 것이 아니라 인스턴스로부터 별도의 인스턴스를 만드는 것을 Prototype 패턴이라 한다. 

Prototpye 패턴의 등장인물
- Prototype(원형)의 역할
  - 인스턴스를 복사해 새로운 인스턴스를 만들기위한 메서드를 결정한다. 예제의 Product
- ConcreateProtyotype의 역할
  - 인스턴스를 복사해 새로운 인스턴스를 만드는 메서드를 실제로 구현한다. 예제의 MessageBox

---
## Builder - 복잡한 인스턴스 조립하기
Builder 패턴
- 구조를 가진 인스턴스를 쌓아올리는 패턴이다. 

Builder 패턴의 등장인물
- Builder의 역할
  - 인스턴스를 생성하기 위한 인터페이스를 결정한다. 
  - Builder 역할에는 인스턴스의 각 부분을 만들기 위한 메서드가 준비돼 있다. 
- ConcreteBuilder의 역할
  - Builder 인터페이스를 구현.
- Director의 역할
  - Builder 인터페이스를 사용해 인스턴스를 생성한다. 
  - ConcreteBuilder 역할에 의존한 프로그래밍은 수행하지 않는다. 

---
## Abstract Factory - 관련 부품을 조합해서 제품 만들기
Abstract Factory 패턴
- 추상적 공장에서는 추상적인 부품을 조합해 추상적인 제품을 만든다. 
- 부품의 구체적인 구현에는 주목하지 않고 인터페이스에 주목한다. 
- 인터페이스만을 사용해 부품을 조립하고 제품으로 완성한다. 
- Template Method, Builder 패턴과 마찬가지로 Abstract Factory 패턴도 하위 클래스 단계에서 구체적 구현을 한다. 

Abstract Factory 패턴의 등장인물
- AbstractProduct의 역할
  - AbstractFactory 역할에 의해 만들어진 추상적인 부품이나 제품의 인터페이스를 결정한다.
  - 예제의 Link, Tray, Page 클래스.
- AbstractFactory의 역할
  - AbstractFactory는 AbstractProduct 역할의 인스턴스를 만들어 내기 위한 인터페이스를 결정한다. 

---
# Part 04 분리해서 생각하기
## Bridge - 기능 계층과 구현 계층 분리하기
Bridge 패턴
- Bridge 패턴은 두 장소를 연결하는 역할을 한다. 
- Bridge 패턴이 다리 역할을 하고 있는 두 곳은 '기능의 클래스 계층'과 '구현 클래스 계층'이다.

클래스 계층의 두 가지 역할
- 새로운 '기능'을 추가하고 싶은 경우
  - 상위 클래스의 새로운 기능을 추가하고 싶을 때 우리는 하위클래스를 만들고 여기서 새로운 기능을 추가한다.
  - 하위 클래스에 또 다른 새루운 긴으을 추가하려면 하위 클래스의 또다른 하위 클래스를 만들어 기능을 추가한다. 
  - 새로운 기능을 추가하고 싶을 경우 클래스 계층 안에서 자신의 목적과 가까운 클래스를 찾아내 그 하위 클래스에 만들어, 목적한 기능을 추가한 새루운 클래스를 만든다는 것이 기능의 클래스다.
- 새로운 '구현'을 추가하고 싶은 경우
  - 상위 클래스는 추상 메서드에 의해 인터페이스를 규정하고, 하위 클래스는 구상 메서드에 의해 그 인터페이스를 구현하다.
- 클래스 계층의 혼재와 클래스 계층의 분리
  - 우리가 하위 클래스를 만들려고 할 때, '기능을 추가하려고 하는지', '구현을 수행하려고 하는지'에 대해 확실히할 필요가 있다.
  - '기능의 클래스 계층'과 '구현의 클래스 계층'을 두 개의 독립된 클래스 계층으로 분리해야 한다. 
  - 단순히 분리만 하면 흩어져버리기 때문에 두 개의 클래스 계층 사이에 다리를 놓는 일이 필요하다. 
  
Bridge 패턴의 등장인물
- Abstaction(추상화)의 역할
  - '기능의 클래스 계층'의 최상위 클래스
  - 기본적인 기능만 기술되어 있는 클래스.
  - 예제의 Display 클래스
- RefindedAbstaction(개선된 추상화)의 역할
  - Abstaction 역할에 대해 기능을 추가한 역할
  - 예제의 CountDisplay
- Implementor의 역할
  - '구현 클래스 계층'의 최상위 클래스
  - Abstaction 역할의 인터페이스를 구현하기 위한 메서드를 규정하는 역할
  - 예제의 DisplayImpl 클래스
- Concrete Implementor의 역할
  - 예제의 StringDisplayImpl
  
독자의 사고를 넓히기 위한 힌트
- 분리해 두면 확장이 편해진다
  - 기능을 추가하고 싶으면 기능의 클래스 계층에 클래스를 추가한다. 구현 클래스 계층은 전혀 수정할 필요가 없다. 
  - 새로 추가한 기능은 '모든 구현'에서 이용할 수 있다. 
- 상속은 견고한 연결이고 위임은 느슨한 연결이다
  - 클래스 간 관계를 척척 바꾸고 싶을 때 상속을 사용하는 것은 부적절하다. 
  - 위의 경우 상속이 아닌 위임을 사용해야 한다. 
  
  ---
  ## Strategy - 알고리즘을 모두 바꾸기
  Strategy 패턴
  - Strategy는 알고리즘이라 생각하면 된다. 
  - Strategy 패턴에서는 알고맂므을 구현한 부분을 모두 교환할 수 있다. 
  - 알고리즘을 빈틈없이 교체해 같은 문제를 다른 방법으로 쉽게 해결할 수 있도록 도와주는 패턴이다.
  
  Strategy 패턴의 등장인물
  - Strategy의 역할
    - 전략을 이용하기 위한 인터페이스를 결정한다.
    - 예제의 Strategy
  - ConcreteStrategy의 역할
    - Strategy의 인터페이스를 구현
  - Context
    - Strategy를 이용하는 역할
    - ConcreteStrategy의 인스턴스를 가지고 있으며 필요에 따라 그것을 이용
    - 예제의 Player
    
---
# Part5 동일시하기
## Composite - 그릇과 내용물을 동일시하기
Composite 패턴
- 그릇과 내용물을 동일시해서 재귀적인 구조를 만들기 위한 디자인 패턴이다.

Composite 패턴의 등장인물
- Leaf의 역할
  - 내용물을 표시하는 역할을 하며 내부에는 다른 것을 넣을 수 없다. 
  - 예제의 File
- Composite의 역할
  - 그릇을 나타내며 Leaf나 Composite을 넣을 수 있다. 
  - 예제의 Directory
- Component의 역할
  - Leaf와 Component 역할을 동일시하는 역할을 한다. 
  - 예제의 Entry
  
---
## Decorator - 장식과 내용물을 동일시하기
Decorator 패턴
- 오브젝트에 장식을 해 나가는 디자인 패턴을 Decorator 패턴이라 한다. 

Decorator 패턴의 등장인물
-  Component의 역할
  - 기능을 추가할 때 핵심이 되는 역할.
  - 장식을 하기 전의 스펀지케이크 역할로 케이크의 인터페이스만을 결정한다.
  - 예제의 Display
- ConcreteComponent의 역할
  - 예제의 StringDisplay
- Decorator의 역할
  - Component 역할과 동일한 인터페이스를 가지고, 또한 Decorator 역할이 장식할 대상이 된느 Component의 역할도 가지고 있다. 
  - 예제의 Border
 
---
# Part6 구조를 돌아다니기
## Vistor - 데이터 구조를 돌아다니면서 처리하기
Vistor 패턴
- Visitor 패턴에서는 데이터 구조와 처리를 분리한다. 
- 데이터 구조 안을 돌아다니는 주체인 '방문자'를 나타내는 클래스를 준비해 그 클래스에게 처리를 위임한다. 
- 새로운 처리를 추가하고 싶을 땐 새로운 '방문자'를 만들면 된다.







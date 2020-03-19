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
  
  
  
  
  
package iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.appendBook(new Book("C++ 기초플러스"));
        bookShelf.appendBook(new Book("Mordern Java In Action"));
        bookShelf.appendBook(new Book("Effective Java"));
        bookShelf.appendBook(new Book("HTML & CSS 기초"));

        Iterator it = bookShelf.iterator();

        while(it.hasNext()) {
            Book book = (Book) it.next();
            System.out.println(book.getName());
        }
    }
}

// Exercise 1 - SRP (Single Responsibility Principle)
class Book {
    private String title;
    private String author;
    private String content;

    public Book(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class BookPrinter {
    public void print(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Content:\n" + book.getContent());
    }
}

public class SRP {
    public static void main(String[] args) {
        Book myBook = new Book("Design Patterns", "Robert Martin", "This book explains design principles.");
        BookPrinter printer = new BookPrinter();
        printer.print(myBook);
    }
}
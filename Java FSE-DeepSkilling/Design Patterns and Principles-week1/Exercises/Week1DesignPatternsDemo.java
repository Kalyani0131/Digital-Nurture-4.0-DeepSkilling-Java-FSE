// Main class to run all demonstrations
public class Week1DesignPatternsDemo {
    public static void main(String[] args) {

        System.out.println("\n--- SRP ---");
        Book book = new Book("Java Design Patterns", "Kalyani", "Learn SRP");
        BookPrinter printer = new BookPrinter();
        printer.print(book);

        System.out.println("\n--- OCP ---");
        Shape[] shapes = {new Circle(5), new Rectangle(4, 6)};
        AreaCalculator calc = new AreaCalculator();
        System.out.println("Total Area: " + calc.totalArea(shapes));

        System.out.println("\n--- LSP ---");
        try {
            Bird bird = new Bird();
            bird.fly();
            Bird penguin = new Penguin();
            penguin.fly();
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- ISP ---");
        BasicPrinter basicPrinter = new BasicPrinter();
        basicPrinter.print();

        System.out.println("\n--- DIP ---");
        MessageService service = new EmailService();
        Notification notification = new Notification(service);
        notification.alert("You have a message!");

        System.out.println("\n--- Singleton ---");
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println("Same instance? " + (s1 == s2));

        System.out.println("\n--- Factory ---");
        Vehicle car = VehicleFactory.getVehicle("car");
        car.drive();

        System.out.println("\n--- Builder ---");
        Pizza pizza = new Pizza.Builder().setDough("Thin Crust").setSauce("Tomato").setTopping("Cheese").build();
        System.out.println("Pizza built successfully");

        System.out.println("\n--- Adapter ---");
        MediaPlayer mp = new MediaAdapter();
        mp.play("video.vlc");

        System.out.println("\n--- Strategy ---");
        ShoppingCart cart = new ShoppingCart(new PaypalPayment());
        cart.checkout(150);
    }
}

// --- SRP ---
class Book {
    private String title, author, content;
    public Book(String title, String author, String content) {
        this.title = title; this.author = author; this.content = content;
    }
    public String getContent() { return content; }
}

class BookPrinter {
    public void print(Book book) {
        System.out.println(book.getContent());
    }
}

// --- OCP ---
interface Shape { double calculateArea(); }
class Circle implements Shape {
    double radius;
    Circle(double r) { this.radius = r; }
    public double calculateArea() { return Math.PI * radius * radius; }
}
class Rectangle implements Shape {
    double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    public double calculateArea() { return w * h; }
}
class AreaCalculator {
    public double totalArea(Shape[] shapes) {
        double sum = 0;
        for (Shape s : shapes) sum += s.calculateArea();
        return sum;
    }
}

// --- LSP ---
class Bird { public void fly() { System.out.println("Bird flying"); } }
class Penguin extends Bird {
    public void fly() { throw new UnsupportedOperationException("Penguins can't fly"); }
}

// --- ISP ---
interface IPrinter { void print(); }
class BasicPrinter implements IPrinter {
    public void print() { System.out.println("Printing..."); }
}

// --- DIP ---
interface MessageService { void sendMessage(String message); }
class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Email Sent: " + message);
    }
}
class Notification {
    private MessageService service;
    Notification(MessageService service) { this.service = service; }
    public void alert(String msg) { service.sendMessage(msg); }
}

// --- Singleton ---
class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static synchronized Singleton getInstance() {
        if (instance == null) instance = new Singleton();
        return instance;
    }
}

// --- Factory ---
interface Vehicle { void drive(); }
class Car implements Vehicle { public void drive() { System.out.println("Driving Car"); } }
class Bike implements Vehicle { public void drive() { System.out.println("Riding Bike"); } }
class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        return switch(type) {
            case "car" -> new Car();
            case "bike" -> new Bike();
            default -> null;
        };
    }
}

// --- Builder ---
class Pizza {
    private String dough, sauce, topping;
    public static class Builder {
        private Pizza pizza = new Pizza();
        public Builder setDough(String dough) { pizza.dough = dough; return this; }
        public Builder setSauce(String sauce) { pizza.sauce = sauce; return this; }
        public Builder setTopping(String topping) { pizza.topping = topping; return this; }
        public Pizza build() { return pizza; }
    }
}

// --- Adapter ---
interface MediaPlayer { void play(String filename); }
class VLCPlayer { void playVLC(String file) { System.out.println("VLC Playing: " + file); } }
class MediaAdapter implements MediaPlayer {
    private VLCPlayer vlc = new VLCPlayer();
    public void play(String filename) { vlc.playVLC(filename); }
}

// --- Strategy ---
interface PaymentStrategy { void pay(int amt); }
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amt) { System.out.println("Paid " + amt + " via Credit Card"); }
}
class PaypalPayment implements PaymentStrategy {
    public void pay(int amt) { System.out.println("Paid " + amt + " via PayPal"); }
}
class ShoppingCart {
    private PaymentStrategy strategy;
    ShoppingCart(PaymentStrategy strategy) { this.strategy = strategy; }
    public void checkout(int amt) { strategy.pay(amt); }
}
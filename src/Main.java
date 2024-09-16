import com.sun.nio.sctp.AbstractNotificationHandler;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.util.*;

// 1. Класс "Человек"
class Person {
    String name;
    int age;
    public char gender;
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void getInfo() {
        System.out.println("Имя: " + name + "\nВозраст: " + age + "\nПол: " + gender);
    }
    public void plusAge() {
        age++;
    }
    public void changeName(String newName) {
        this.name = newName;
    }
}
// 2. Наследование: Класс "Работник" и "Менеджер"
class Worker extends Person {
    public double salary;
    public Worker(String name, int age, char gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
    }
    public void getInfo() {
        System.out.println("Имя: " + name + "\nВозраст: " + age + "\nПол: " + gender);
    }
}

class Manager extends Worker {
    public Manager(String name, int age, char gender, double salary) {
        super(name, age, gender, salary);
        this.employees = new ArrayList<>();
    }
    public List<Worker> employees;
    public void addEmployees(Worker worker) {
        employees.add(worker);
    }
}
// 3. Полиморфизм: Животные
interface Animal {
    void MakeSound();
}

class Dog implements Animal {
    public void MakeSound() {
        System.out.println("Гав гав гав");
    }
}

class Cat implements Animal {
    public void MakeSound() {
        System.out.println("Мяу мяу мяу");
    }
}

class Cow implements Animal {
    public void MakeSound() {
        System.out.println("Мууу муууу");
    }
}

// 4. Абстрактный класс "Транспорт"
abstract class Transport {
    abstract void Move();
}

class Bike extends Transport {
    void Move() {
        System.out.println("Велосипед едет");
    }
}

class Car extends Transport {
    void Move() {
        System.out.println("Машина едет");
    }
}

// 5. Класс "Книга" и "Библиотека"
class Book {
    String title;
    String author;
    int year;
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class Library {
    List<Book> books;
    Library() {
        this.books = new ArrayList<>();
    }
    void addBook(Book book) {
        books.add(book);
    }
    void searchAuthor(String author) {
        for (Book book : books) {
            if (book.author == author) {
                System.out.println(book.title + " " + book.year + " г.");
            }
        }
    }

    void searchYear(int year) {
        for (Book book : books) {
            if (book.year == year) {
                System.out.println(book.title + " " + book.author);
            }
        }
    }
}

// 6. Инкапсуляция: Банк
class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    void deposit (double amount) {
        if (amount > 0 ) {
            this.balance += amount;
            System.out.println("Пополнение " + amount + ".");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 & this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Снятие " + amount + ".");
        }
    }

    double getBalance() {
        return this.balance;
    }

    String getAccountNumber() {
        return this.accountNumber;
    }

}

// 7. Счетчик объектов

class Counter {
    private static int Count = 0;

    Counter() {
        Count++;
    }
    static int getCount() {
        return Count;
    }
}

// 8. Площадь фигур

abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    double Radius;
    Circle(double Radius) {
        this.Radius = Radius;
    }
    double getArea() {
        return Math.PI*Math.pow(this.Radius,2);
    }
}

class Rectangle extends Shape {
    double a;
    double b;
    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    double getArea() {
        return a*b;
    }
}

// 9. Наследование: Животные и их движения
class Animals {
    void move() {
        System.out.println("Животное передвигается.");
    }
}

class Fish extends Animals {
    @Override
    void move() {
        System.out.println("Рыба плывет.");
    }
}

class Bird extends Animals {
    @Override
    void move() {
        System.out.println("Птица летит.");
    }
}

class Dogs extends Animals {
    @Override
    void move() {
        System.out.println("Собака бежит.");
    }
}

// 10. Работа с коллекциями: Университет

class Student {
    String name;
    String group;
    double grade;
    Student(String name, String group, double grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
}
class University {
    List<Student> students;
    public University() {
        this.students = new ArrayList<>();
    }
    public void addStudents(Student student) {
        this.students.add(student);
    }
    public void sortStudentsByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public List<Student> filterStudentsByGrade(double minGrade) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.grade >= minGrade) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }

}

// 11. Класс "Магазин"

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Store {
    List<Product> products;
    public Store() {
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(Product product) {
        products.remove(product);
    }
    void searchProduct(Product product) {
        for (Product item : products) {
            if (item == product) {
                System.out.println(item.name + " " + item.price + " " + item.quantity + ".");
            }
        }
    }
}
// 12. Интерфейс "Платежная система"
interface PaymentSystem {
    void pay(double amount);
    void refund(double amount);
}

class CreditCard implements PaymentSystem {
    private String cardNumber;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплата " + amount + " с кредитной карты " + cardNumber);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возврат " + amount + " на кредитную карту " + cardNumber);
    }

}
class PayPal implements PaymentSystem {
    private String email;

    public PayPal(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Оплата " + amount + " через PayPal с email " + email);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Возврат " + amount + " на PayPal с email " + email);
    }
}

// 13. Генерация уникальных идентификаторов
class UniqueID {
    private static int counter = 0; // Счетчик для уникальных идентификаторов

    // Метод для генерации нового уникального идентификатора
    public static int generateID() {
        return counter++; // Инкрементируем и возвращаем текущее значение
    }
}

// 14. Класс "Точка" и "Прямоугольник"
class Point {
    private double x; // Координата x
    private double y; // Координата y

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

class RectangleSecond {
    Point topLeft;
    Point bottomRight;

    public RectangleSecond(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double area() {
        double width = bottomRight.getX() - topLeft.getX();
        double height = topLeft.getY() - bottomRight.getY();
        return width * height;
    }
}

// 15. Комплексные числа

class ComplexNumber {
    public double real;
    public double unreal;

    public ComplexNumber(double real, double unreal) {
        this.real = real;
        this.unreal = unreal;
    }

    public ComplexNumber add(ComplexNumber x) {
        return new ComplexNumber(this.real + x.real,
                this.unreal + x.unreal);
    }

    public ComplexNumber subtract(ComplexNumber x) {
        return new ComplexNumber(this.real - x.real,
                this.unreal - x.unreal);
    }

    public ComplexNumber multiply(ComplexNumber x) {
        return new ComplexNumber(this.real * x.real - this.unreal * x.unreal,
                this.real * x.unreal + this.unreal * x.real);
    }

    public ComplexNumber divide(ComplexNumber x) {
        double denominator = x.real * x.real + x.unreal * x.unreal;
        return new ComplexNumber((this.real * x.real + this.unreal * x.unreal) / denominator,
                (this.unreal * x.real - this.real * x.unreal) / denominator);
    }
}

// 16. Перегрузка операторов: Матрица
class Matrix {
    private double[][] elements;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.elements = new double[rows][cols];
    }

    public void setElement(int row, int col, double value) {
        elements[row][col] = value;
    }

    public double getElement(int row, int col) {
        return elements[row][col];
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Размеры матриц не совпадают!");
        }

        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setElement(i, j, this.getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix add(double scalar) {
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.setElement(i, j, this.getElement(i, j) + scalar);
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно совпадать с количеством строк второй матрицы!");
        }

        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.getElement(i, k) * other.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f ", elements[i][j]);
            }
            System.out.println();
        }
    }
}


// 17. Создание игры с использованием ООП

class Weapon {
    private String name;
    private int damage;


    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }
}


class Enemy {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " получил " + damage + " урона. Текущее здоровье: " + health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}

class Player {
    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " атакует " + enemy.getName() + " с оружием " + weapon.getName() + "!");
        enemy.takeDamage(weapon.getDamage());
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " получил " + damage + " урона. Текущее здоровье: " + health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}


class Order{
    private ArrayList<ProductSecond> products = new ArrayList<>();

    public Order(ArrayList<ProductSecond> products){
        this.products = products;
    }

    public void addProduct(ProductSecond product) {
        products.add(product);
    }

    public void removeProduct(ProductSecond product) {
        products.remove(product);
    }

    public void getProductsList(){
        for(ProductSecond item: products) System.out.println(item.getName());
    }

    public double totalPrice() {
        double total = 0;
        for (ProductSecond product : products) total += product.getPrice();
        return total;
    }
}

class Customer{
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Order MakeOrder(ArrayList<ProductSecond> order){
        return new Order(order);
    }
}

class ProductSecond{
    private String name;
    private double price;

    public ProductSecond(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName(){
        return name;
    }
}

// 19. Наследование: Электроника

class Device {
    private String brand;

    public Device(String brand) {
        this.brand = brand;
    }

    public void turnOn() {
        System.out.println(brand + " is now ON.");
    }

    public void turnOff() {
        System.out.println(brand + " is now OFF.");
    }

    public String getBrand() {
        return brand;
    }
}

class Smartphone extends Device {
    public Smartphone(String brand) {
        super(brand);
    }

    public void takePhoto() {
        System.out.println(getBrand() + " is taking a photo.");
    }
}

class Laptop extends Device {
    public Laptop(String brand) {
        super(brand);
    }

    public void code() {
        System.out.println(getBrand() + " is coding.");
    }
}

// 20. Игра "Крестики-нолики"
class Game {
    private char[][] board;
    private char currentPlayer;

    public Game() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("Текущая игра:");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Недопустимый ход! Попробуйте снова.");
            return false;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int moves = 0;
        while (moves < 9) {
            displayBoard();
            System.out.println("Игрок " + currentPlayer + ", введите строку и столбец (0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (makeMove(row, col)) {
                moves++;
                if (checkWin()) {
                    displayBoard();
                    System.out.println("Игрок" + currentPlayer + " выиграл!");
                    return;
                }
                switchPlayer();
            }
        }
        displayBoard();
        System.out.println("It's a draw!");
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1.
//      Person person = new Person("Andrew", 18, 'M');
//      person.getInfo();
//      person.plusAge();
//      person.changeName("John");
//      person.getInfo();

        // 2.
//      Animal[] animals = new Animal[3];
//      animals[0] = new Dog();
//      animals[1] = new Cat();
//      animals[2] = new Cow();
//
//      for (Animal animal : animals) {
//          animal.MakeSound();
        // 5.
//        Library  library = new Library();
//        Book book1 = new Book("1984", "Джордж Оруэлл", 1949);
//        Book book2 = new Book("Формирование общественного мнения", "Эдвард Бернейс", 1923);
//        Book book3 = new Book("Чемодан", "Сергей Довлатов", 1986);
//        Book book4 = new Book("Компромис", "Сергей Довлатов", 1981);
//        library.addBook(book1);
//        library.addBook(book2);
//        library.addBook(book3);
//        library.addBook(book4);
//        library.searchAuthor("Сергей Довлатов");
//        library.searchYear(1949);

        // 6.
//        BankAccount bankAccount = new BankAccount("123182490723985");
//        System.out.println(bankAccount.getAccountNumber());
//        bankAccount.deposit(1200);
//        System.out.println(bankAccount.getBalance());
//        bankAccount.withdraw(1000);
//        System.out.println(bankAccount.getBalance());

        // 7.
//        System.out.println(Counter.getCount());
//        Counter count1 = new Counter();
//        Counter count2 = new Counter();
//        System.out.println(Counter.getCount());

        // 8.
//        Rectangle rect = new Rectangle(2.2, 2.5);
//        Circle circle = new Circle(2.5);
//        System.out.println(rect.getArea());
//        System.out.println(circle.getArea());

        // 9.
//        Dogs dog = new Dogs();
//        dog.move();
//        Bird bird =new Bird();
//        bird.move();
//        Fish fish = new Fish();
//        fish.move();
        // 10. Работа с коллекциями: Университет

//        University university = new University();
//        Student student1 = new Student("Bob", "CS101", 85.0);
//        Student student2 = new Student("Alice", "CS102", 75.0);
//        Student student3 = new Student("Charlie", "CS101", 90.0);
//        university.addStudents(student1);
//        university.addStudents(student2);
//        university.addStudents(student3);
//        for(var student : university.students) {
//            System.out.println(student.name);
//        }
//        university.sortStudentsByName();
//
//        System.out.println("Студенты после сортировки по имени:");
//        for(var student : university.students) {
//            System.out.println(student.name);
//        }
//        System.out.println("Студенты с балом ваше 80:");
//        List<Student> filteredStudents = university.filterStudentsByGrade(80.0);
//        for(var student : filteredStudents) {
//            System.out.println(student.name);
//        }
        // 11. Класс "Магазин"
//        Store store = new Store();
//        Product product = new Product("Яйца", 10.0, 10);
//        store.addProduct(product);
//        Product product2 = new Product("Хлеб", 5.0, 20);
//        store.addProduct(product2);
//        store.addProduct(new Product("Молоко", 25.0, 10));
//        for (Product item : store.products) {
//            System.out.println(item.name + " " + item.price + " " + item.quantity + ".");
//        }
//        System.out.println("-------------");
//        store.removeProduct(product);
//        for (Product item : store.products) {
//            System.out.println(item.name + " " + item.price + " " + item.quantity + ".");
//        }
//        System.out.println("-------------");
//        store.searchProduct(product2);

        // 12. Интерфейс "Платежная система"
//        PaymentSystem creditCard = new CreditCard("1234-5678-9012-3456");
//        PaymentSystem payPal = new PayPal("user@example.com");
//
//        creditCard.pay(100.00);
//        creditCard.refund(50.00);
//
//        payPal.pay(150.00);
//        payPal.refund(75.00);

        // 13. Генерация уникальных идентификаторов
//        System.out.println(UniqueID.generateID());
//        System.out.println(UniqueID.generateID());

        // 14. Класс "Точка" и "Прямоугольник"
//        Point topLeft = new Point(1, 4);
//        Point bottomRight = new Point(5, 1);
//        RectangleSecond rectangleSecond = new RectangleSecond(topLeft, bottomRight);
//
//        System.out.println("Площадь прямоугольника: " + rectangleSecond.area());

        // 15. Комплексные числа
//        ComplexNumber num1 = new ComplexNumber(4, 5);
//        ComplexNumber num2 = new ComplexNumber(2, 3);
//        ComplexNumber sum = num1.add(num2);
//        System.out.println(sum.real + " " + sum.unreal);

        // 16. Перегрузка операторов: Матрица
//        Matrix matrix1 = new Matrix(2, 2);
//        matrix1.setElement(0, 0, 1);
//        matrix1.setElement(0, 1, 2);
//        matrix1.setElement(1, 0, 3);
//        matrix1.setElement(1, 1, 4);
//
//        Matrix matrix2 = new Matrix(2, 2);
//        matrix2.setElement(0, 0, 5);
//        matrix2.setElement(0, 1, 6);
//        matrix2.setElement(1, 0, 7);
//        matrix2.setElement(1, 1, 8);
//
//        Matrix sum = matrix1.add(matrix2);
//        System.out.println("Сумма матриц:");
//        sum.print();
//
//        Matrix sumWithScalar = matrix1.add(10);
//        System.out.println("Сумма матрицы и скаляра:");
//        sumWithScalar.print();
//
//        Matrix product = matrix1.multiply(matrix2);
//        System.out.println("Произведение матриц:");
//        product.print();

        // 17. Создание игры с использованием ООП
//        Weapon sword = new Weapon("Меч", 10);
//        Weapon axe = new Weapon("Топор", 15);
//
//        Player player = new Player("Игрок", 100, sword);
//
//        Enemy goblin = new Enemy("Гоблин", 30);
//        Enemy orc = new Enemy("Орк", 50);
//
//        player.attack(goblin);
//        player.attack(orc);
//
//        goblin.takeDamage(5);
//        player.takeDamage(5);


        // 19. Наследование: Электроника
//        Smartphone smartphone = new Smartphone("Samsung");
//        smartphone.turnOn();
//        smartphone.takePhoto();
//        smartphone.turnOff();
//
//        Laptop laptop = new Laptop("Dell");
//        laptop.turnOn();
//        laptop.code();
//        laptop.turnOff();


        // 20. Игра "Крестики-нолики"
        Game game = new Game();
        game.play();




    }
}
import model.User;

import java.io.PrintStream;

public class HelloWorld {
    public static void main(String[] args) {
        print(System.out);
        createAlice();
    }

    public static void print(PrintStream out) {
        out.print("Hello, World!");

        User alice = new User("Alice");
    }

    public static String createAlice() {
        User alice = new User("Alice");
        System.out.print("Hello, World!");
        return "Hello, World!";
    }
}

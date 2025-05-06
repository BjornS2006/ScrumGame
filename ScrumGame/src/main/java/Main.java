import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
       System.out.println("test test");
        Scanner scanner = new Scanner(System.in);
        Speler speler = new Speler();
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("status")) {
                speler.getStatus();
            }
        }
    }

}
//apen  __
//     /  \
//    [  T ]
//    _|  |_
//   /      \
//  /        \
// (          )
//  \________/

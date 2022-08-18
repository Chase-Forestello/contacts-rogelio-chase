// Complete - Java II - OOP Input Exercise
package util;

public class InputTest {
    public static void main(String[] args) {
        Input input = new Input();
        System.out.println(input.getString("Enter a word:"));
        System.out.println(input.yesNo("Continue? [ y , n ]"));
        System.out.println(input.getInt(1,10, "Enter an integer 1-10:"));
        System.out.println(input.getInt("Enter an integer:"));
        System.out.println(input.getDouble(1,10, "Enter a double 1-10:"));
        System.out.println(input.getDouble("Enter a double:"));
    }
}

package HW1;

//I worked on the assignment alone, using only course-provided materials.
public class PrimitiveOperations {
    public static void main(String[] args) {
        int number1 = 5;
        double number2 = 3.5;
        System.out.println(number1);
        System.out.println(number2);

        double product = number1 * number2;
        System.out.println(product);

        double convertNumber1 = (double) number1;
        System.out.println(convertNumber1);

        int convertNumber2 = (int) number2;
        System.out.println(convertNumber2);

        char letter = 'A';
        System.out.println(letter);

        letter = (char)( (int) 'A' + 32);
        System.out.println(letter);
    }
}

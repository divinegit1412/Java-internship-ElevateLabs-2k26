import java.util.Scanner;

public class consoleCalculator {

    public static void main(String[] args) {

        System.out.println("WELCOME TO MRADUL'S CALCULATOR");
        System.out.println("For Addition type       : add");
        System.out.println("For Subtraction type    : sub");
        System.out.println("For Multiplication type : mult");
        System.out.println("For Division type       : div");

        Scanner sc = new Scanner(System.in);

        String parameter = "continue";
        float previousAns = 0;

        do {

            // New Calculation
            System.out.print("\nEnter operation: ");
            String name = sc.nextLine().toLowerCase();

            System.out.print("Enter 1st value: ");
            float val1 = sc.nextFloat();

            System.out.print("Enter 2nd value: ");
            float val2 = sc.nextFloat();
            sc.nextLine();

            if (name.equals("add")) {
                previousAns = addition(val1, val2);
                System.out.println("Result: " + previousAns);

            } else if (name.equals("sub")) {
                previousAns = subtraction(val1, val2);
                System.out.println("Result: " + previousAns);

            } else if (name.equals("mult")) {
                previousAns = multiplication(val1, val2);
                System.out.println("Result: " + previousAns);

            } else if (name.equals("div")) {
                if (val2 == 0) {
                    System.out.println("Cannot divide by zero!");
                    continue;
                }

                previousAns = division(val1, val2);
                System.out.println("Result: " + previousAns);

            } else {
                System.out.println("Invalid operation!");
                continue;
            }

            // Ask what to do next
            System.out.print(
                "\nType 'yes' to continue with result, " +
                "'no' for new calculation, or 'quit' to exit: "
            );

            parameter = sc.nextLine().toLowerCase();

            // Continue with previous result
            while (parameter.equals("yes")) {

                System.out.print("\nEnter operation: ");
                String name1 = sc.nextLine().toLowerCase();

                System.out.print("Enter value: ");
                float val3 = sc.nextFloat();
                sc.nextLine();

                if (name1.equals("add")) {
                    previousAns = addition(previousAns, val3);
                    System.out.println("Result: " + previousAns);

                } else if (name1.equals("sub")) {
                    previousAns = subtraction(previousAns, val3);
                    System.out.println("Result: " + previousAns);

                } else if (name1.equals("mult")) {
                    previousAns = multiplication(previousAns, val3);
                    System.out.println("Result: " + previousAns);

                } else if (name1.equals("div")) {

                    if (val3 == 0) {
                        System.out.println("Cannot divide by zero!");
                    } else {
                        previousAns = division(previousAns, val3);
                        System.out.println("Result: " + previousAns);
                    }

                } else {
                    System.out.println("Invalid operation!");
                }

                System.out.print(
                    "\nType 'yes' to continue with result, " +
                    "'no' for new calculation, or 'quit' to exit: "
                );

                parameter = sc.nextLine().toLowerCase();
            }

        } while (!parameter.equals("quit"));

        sc.close();

        System.out.println("Calculator closed.");
    }

    static float addition(float ans, float value) {
        return ans + value;
    }

    static float subtraction(float ans, float value) {
        return ans - value;
    }

    static float multiplication(float ans, float value) {
        return ans * value;
    }

    static float division(float ans, float value) {
        return ans / value;
    }
}

import java.util.Scanner;
public class TemperatureConverter {

    private static final String DEGREE = "\u00B0";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readMenuChoice();

            if (choice == 1) {
                double celsius = readTemperature("Celsius");
                double fahrenheit = celsiusToFahrenheit(celsius);
                System.out.println("Result: " + formatTemperature(celsius, "C")
                        + " = " + formatTemperature(fahrenheit, "F"));
                running = askToContinue();

            } else if (choice == 2) {
                double fahrenheit = readTemperature("Fahrenheit");
                double celsius = fahrenheitToCelsius(fahrenheit);
                System.out.println("Result: " + formatTemperature(fahrenheit, "F")
                        + " = " + formatTemperature(celsius, "C"));
                running = askToContinue();

            } else { // choice == 3
                running = false;
            }
        }

        System.out.println("\nThank you for using the Temperature Converter. Goodbye!");
        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }

    private static void displayMenu() {
        System.out.println("\n===== TEMPERATURE CONVERTER =====\n");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Exit\n");
    }

    /** Keeps asking until the user enters 1, 2 or 3. */
    private static int readMenuChoice() {
        while (true) {
            String input = readLine("Enter your choice: ");

            if (input.equals("1") || input.equals("2") || input.equals("3")) {
                return Integer.parseInt(input);
            }
            System.out.println("Invalid choice. Please enter 1, 2 or 3.\n");
        }
    }

    private static double readTemperature(String unitName) {
        while (true) {
            String input = readLine("Enter temperature in " + unitName + ": ");

            // Accepts: 37, -5, +12, 36.6, -0.5, .5, 10.
            // Rejects: letters, empty text, "NaN", "Infinity", "1,5", "abc".
            if (input.matches("[+-]?(\\d+\\.?\\d*|\\.\\d+)")) {
                return Double.parseDouble(input);
            }
            System.out.println("Invalid input. Please enter a number such as 37, -5 or 36.6.\n");
        }
    }

    /** Asks "another conversion?" and returns true for yes, false for no. */
    private static boolean askToContinue() {
        while (true) {
            String answer = readLine("\nWould you like to perform another conversion? (y/n): ")
                    .toLowerCase();

            if (answer.equals("y") || answer.equals("yes")) {
                return true;
            }
            if (answer.equals("n") || answer.equals("no")) {
                return false;
            }
            System.out.println("Please type y for yes or n for no.");
        }
    }

    private static String readLine(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine()) {
            System.out.println("\nNo more input. Goodbye!");
            System.exit(0);
        }
        return scanner.nextLine().trim();
    }

    /** Formats a value with two decimal places and its unit, e.g. 98.60°F. */
    private static String formatTemperature(double value, String unit) {
        // "+ 0.0" turns a possible -0.0 into 0.0 so we never print "-0.00".
        return String.format("%.2f", value + 0.0) + DEGREE + unit;
    }
}

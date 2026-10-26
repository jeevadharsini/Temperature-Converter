# Temperature Converter

A beginner-friendly Java console program that converts temperatures between
**Celsius** and **Fahrenheit**.

## Features

- Menu-driven: Celsius to Fahrenheit, Fahrenheit to Celsius, or Exit
- Works with positive, negative and decimal values
- Results shown to two decimal places with the correct unit (°C / °F)
- Input validation: letters, empty input, `NaN` and `Infinity` never crash the program
- Multiple conversions without restarting
- Uses only `java.util.Scanner`, with no external libraries

## Formulas

| Conversion          | Formula            |
|---------------------|--------------------|
| Celsius to Fahrenheit | `(C × 9/5) + 32` |
| Fahrenheit to Celsius | `(F − 32) × 5/9` |

## Project Structure

```
TemperatureConverter/
├── src/
│   └── TemperatureConverter.java
├── .gitignore
└── README.md
```

## Requirements

- Java Development Kit (JDK) 8 or higher (check with `javac -version`)

## How to Compile and Run

From the project root folder:

```bash
javac -d out src/TemperatureConverter.java
java -cp out TemperatureConverter
```

## Sample Output

```
===== TEMPERATURE CONVERTER =====

1. Celsius to Fahrenheit
2. Fahrenheit to Celsius
3. Exit

Enter your choice: 1
Enter temperature in Celsius: 37
Result: 37.00°C = 98.60°F

Would you like to perform another conversion? (y/n): y

===== TEMPERATURE CONVERTER =====

1. Celsius to Fahrenheit
2. Fahrenheit to Celsius
3. Exit

Enter your choice: 2
Enter temperature in Fahrenheit: 212
Result: 212.00°F = 100.00°C

Would you like to perform another conversion? (y/n): n

Thank you for using the Temperature Converter. Goodbye!
```

## Test Cases

| Input     | Expected output |
|-----------|-----------------|
| 0 °C      | 32.00 °F        |
| 100 °C    | 212.00 °F       |
| 37 °C     | 98.60 °F        |
| -40 °C    | -40.00 °F       |
| -10.5 °C  | 13.10 °F        |
| 32 °F     | 0.00 °C         |
| 212 °F    | 100.00 °C       |
| -40 °F    | -40.00 °C       |
| 98.6 °F   | 37.00 °C        |
| `abc`     | "Invalid input" message, asks again |
| menu `9`  | "Invalid choice" message, asks again |

## How It Works

1. `main` shows the menu in a loop until the user chooses to exit.
2. The user's choice is validated (`1`, `2` or `3` only).
3. The temperature is read as text and checked against a pattern before
   being converted to a `double`, so bad input can never crash the program.
4. A conversion method (`celsiusToFahrenheit` or `fahrenheitToCelsius`) calculates the result.
5. `formatTemperature` prints it with two decimals and the unit symbol.
6. The user is asked whether to convert again (`y`/`n`).

## Author

Your Name – Internship Task 4

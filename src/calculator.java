import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите выражение (например, 2 + 3):");
            String input = scanner.nextLine();

            // Разделение строки на операнды и оператор
            String[] parts = input.split(" ");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Некорректный формат ввода. Используйте формат: a + b");
            }

            // Преобразование строк в целые числа
            int num1 = parseAndValidate(parts[0]);
            int num2 = parseAndValidate(parts[2]);

            // Выполнение операции
            int result;
            switch (parts[1]) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        throw new ArithmeticException("Ошибка: Деление на ноль не допускается.");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Некорректная операция. Используйте: +, -, *, /");
            }

            // Вывод результата
            System.out.println("Результат: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введены неподходящие числа. Используйте целые числа от 1 до 10.");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            // Закрытие сканнера
            scanner.close();
        }
    }

    private static int parseAndValidate(String str) {
        int num = Integer.parseInt(str);
        if (num < 1 || num > 10) {
            throw new IllegalArgumentException("Ошибка: Введено число вне диапазона от 1 до 10.");
        }
        return num;
    }
}

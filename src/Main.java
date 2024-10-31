import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // Бесконечный цикл, пока не получим команду "exit"
            System.out.print("Введите 'exit' для выхода или нажмите Enter для продолжения: ");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break; // Прерываем цикл, если введено "exit"
            }

            // Запрос коэффициентов с проверкой
            double a = getValidDouble(scanner, "Введите коэффициент a: ");
            double b = getValidDouble(scanner, "Введите коэффициент b: ");
            double c = getValidDouble(scanner, "Введите коэффициент c: ");

            // Вычисляем дискриминант
            double D = b * b - 4 * a * c;
            System.out.println("Дискриминант D = " + D);

            if (D > 0) {
                // Два действительных корня
                double x1 = (-b + Math.sqrt(D)) / (2 * a);
                double x2 = (-b - Math.sqrt(D)) / (2 * a);
                System.out.println("Корни уравнения:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (D == 0) {
                // Один действительный корень
                double x = -b / (2 * a);
                System.out.println("Уравнение имеет один корень:");
                System.out.println("x = " + x);
            } else {
                // Нет действительных корней
                System.out.println("Уравнение не имеет действительных корней.");
            }
        }

        scanner.close();
    }

    // Метод для запроса корректного числа с проверкой на слишком большие значения
    private static double getValidDouble(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            // Проверка, что ввод состоит только из допустимых символов (цифры, точка, знак минус)
            if (input.matches("-?\\d+(\\.\\d+)?")) {
                try {
                    double value = Double.parseDouble(input);
                    if (Math.abs(value) > Double.MAX_VALUE) {
                        System.out.println("Слишком большое значение. Попробуйте еще раз.");
                    } else {
                        return value;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Слишком большое значение. Попробуйте еще раз.");
                }
            } else {
                System.out.println("Введите числа без символов и букв. Попробуйте еще раз.");
            }
        }
    }
}
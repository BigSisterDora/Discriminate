import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите коэффициент a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите коэффициент b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите коэффициент c: ");
        double c = scanner.nextDouble();

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

        scanner.close();
    }
}
/**

Этот класс содержим метод Main.

 */

import java.util.Scanner;

public class Main {

    static {
        System.out.println("Приветствую, это простой калькулятор," +
                " калькулятор умеет выполнять операции :\n" +
                "1) Сложение\n" +
                "2) Вычитание\n" +
                "3) Умножение\n" +
                "4) Деление\n" +
                "Пример как вводить : a + b, a - b, a * b, a / b.: \n" +
                "Числа могут быть, как арабские(0-10), так и римские(I,II,V)!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваше выражение использую клавиатуру в формате указанном выше!\n" +
                "Для выхода введите команду exit");
        while (true) {
            try {
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Спасибо, что воспользовались услугами нашего калькулятора!\n" +
                            "Программа завершает свою работу!");
                    break;
                }

                CalculateService service = new CalculateService();
                String result = service.calculateValue(input);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Попробуй еще раз, прочитай условия и повтори попытку!");
                System.out.println(e.getMessage());
            }
        }
    }



}



/*

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
                String result = calculateValue(input);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Попробуй еще раз, прочитай условия и повтори попытку!");
                System.out.println(e.getMessage());
            }
        }
    }


    private static String calculateValue(String input) {
        input = input.replaceAll("\\s+", "");
        try {
            InputDataCheck IDC1 = new InputDataCheck();
            IDC1.Check(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        try {
            Arabic_Input_Calculate AIC1 = new Arabic_Input_Calculate();
            String Otvet = AIC1.SchitaemArabskieCifri(input);
            if (Otvet != null) {
                return Otvet;
            }
        } catch (Exception e) {
        }
        try {
            RomeInputCalculate RIC1 = new RomeInputCalculate();
            String Otvet = RIC1.SchitaemRimskieCifri(input);
            if (Otvet != null) {
                return Otvet;
            }
        } catch (Exception e) {
            return "Ошибка ввода: " + e.getMessage();
        }

        return "Невозможно вычислить. Проверьте формат ввода (пример: 1+2 или IV+III)";
    }
}



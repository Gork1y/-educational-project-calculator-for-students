/**

Данный класс преобразовывает входящее String выражение в арабские цифры и оператор действия.
Совершает "требуемое" действие и возвращает ответ в формате String.

 */

public class Arabic_Input_Calculate {


    public static String SchitaemArabskieCifri(String input) throws IlligalInputDataException {

        String[] SplitStringMassiv = input.split("(?<=[-+*/])|(?=[-+*/])");
        String operanda1 = SplitStringMassiv[0];
        String operator1 = SplitStringMassiv[1];
        String operanda2 = SplitStringMassiv[2];

        int FirstValue = Integer.parseInt(operanda1);
        int SecondValue = Integer.parseInt(operanda2);
        int result = 0;
        char operator = ' ';

        if ((FirstValue > 10 || FirstValue < 1) || (SecondValue > 10 || SecondValue < 1)) {
            throw new IlligalInputDataException("Число должно быть в диапазоне от 0 до 10!");
        }

        if (operator1.contains("+")) {
            operator = '+';
        } else if (operator1.contains("-")) {
            operator = '-';
        } else if (operator1.contains("*")) {
            operator = '*';
        } else if (operator1.contains("/")) {
            operator = '/';
        }

        switch (operator) {
            case '+' -> result = FirstValue + SecondValue;
            case '-' -> result = FirstValue - SecondValue;
            case '*' -> result = FirstValue * SecondValue;
            case '/' -> result = FirstValue / SecondValue;
        }

        String Otvet = ((Integer) result).toString();
        return Otvet;
    }


}

/**

Данный класс умет считать римские цифры.
Класс преобразовывает входящее String выражение в арабские цифры и оператор действия.
Совершает "требуемое" действие и возвращает римское число в формате String.

 */

public class RomeInputCalculate {


    public  String SchitaemRimskieCifri(String input) throws IlligalInputDataException, ChtoToNeTakException {
        String MassivRimscihCifor[] = {
                " ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String[] SplitStringMassiv = input.split("(?<=[-+*/])|(?=[-+*/])");

        String operanda1 = SplitStringMassiv[0];
        String operator1 = SplitStringMassiv[1];
        String operanda2 = SplitStringMassiv[2];
        int FirstValue = 0;
        int SecondValue = 0;
        int result = 0;
        char operator = ' ';

        for (int i = 1; i < MassivRimscihCifor.length; i++) {
            if (MassivRimscihCifor[i].equals(operanda1)) {
                FirstValue = i;
                break;
            }
        }

        for (int j = 1; j < MassivRimscihCifor.length; j++) {
            if (MassivRimscihCifor[j].equals(operanda2)) {
                SecondValue = j;
                break;
            }
        }

        if ((FirstValue > 10 || FirstValue < 1) || (SecondValue > 10 || SecondValue < 1)) {
            throw new IlligalInputDataException("Число должно быть в диапазоне от 0 до 10, и содержать 2 римских/арабских числа!");
        }

        operator = getOperator(operator1, operator);

        switch (operator) {
            case '+' -> result = FirstValue + SecondValue;
            case '-' -> result = FirstValue - SecondValue;
            case '*' -> result = FirstValue * SecondValue;
            case '/' -> result = FirstValue / SecondValue;
        }

        if (result < 1) {
            throw new ChtoToNeTakException("Результат не может быть отрицательным!");
        }

        return MassivRimscihCifor[result];
    }

    private static char getOperator(String operator1, char operator) {
        if (operator1.contains("+")) {
            operator = '+';
        } else if (operator1.contains("-")) {
            operator = '-';
        } else if (operator1.contains("*")) {
            operator = '*';
        } else if (operator1.contains("/")) {
            operator = '/';
        }
        return operator;
    }
}

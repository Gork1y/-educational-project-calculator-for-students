/*

Данный класс проводит первичную проверку входных данных.
Для уменьшения количества ошибок, из входных данных удаляются все лишнее (пробелы, табуляция и т.д)
Далее выражение приводится к общему виду "значение1", "знак действия", "значение2".

 */
public class InputDataCheck {
       public static void Check(String input) throws Exception {
        input = input.replaceAll("\\s+", "");
        String[] SplitStringMassiv = input.split("(?<=[-+*/])|(?=[-+*/])");
        if (SplitStringMassiv.length != 3) {
            throw new RykaLicoException("Ты реально не можешь ввести без ошибок 2 числа и знак между ними?");

        }
    }
}

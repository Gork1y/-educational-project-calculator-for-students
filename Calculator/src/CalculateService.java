public class CalculateService {

    public String calculateValue(String input) {
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

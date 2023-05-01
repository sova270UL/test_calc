import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите пример в формате 'A + B' арабскими или римскими цифрами");
        String scaner = scan.nextLine();
        String[] checkCount = scaner.split(" ");
        Roman aa;

        int ii = checkCount.length;
        if (ii != 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }


        if (checkCount[1].equals("+") ||checkCount[1].equals("-")||checkCount[1].equals("*")||checkCount[1].equals("/")) {
         try {
             try {
                 System.out.println(calc(scaner));
             } catch (Exception e) {
                 int NegVer = Integer.parseInt(RomCalc(scaner));
                 if (NegVer > 0) {
                     aa = Roman.getRegByUid(RomCalc(scaner));
                     System.out.println(aa);
                 } else {
                     System.out.println("В римской системе нет отрицательных чисел");
                 }
             }
         }
         catch (Exception no) {
             throw new Exception("Нужно использовать одну систему счисления");
         }


        }
        else {
            throw new Exception("Неверный математический оператор");
        }





        String input = checkCount[0] + " " + checkCount[1] + " " + checkCount[2];

    }
     public static String calc(String input) {
         String[] inp = input.split(" ");
         int x = Integer.parseInt(inp[0]);
         int y = Integer.parseInt(inp[2]);
         String oper = inp[1];
         int output = 0;

         switch (oper) {
             case "+" -> output = (x + y);
             case "-" -> output = (x - y);
             case "*" -> output = (x * y);
             case "/" -> output = (x / y);
         }
         String out = Integer.toString(output);

         return out;

     }

     public static String RomCalc(String input) throws Exception {
         Roman aa;
         String[] inp = input.split(" ");
         String x1 = Roman.valueOf(inp[0]).toArab();
         String x2 = Roman.valueOf(inp[2]).toArab();
         int x = Integer.parseInt(x1);
         int y = Integer.parseInt(x2);

         String oper = inp[1];
         int output = 0;
         switch (oper) {
             case "+" -> output = (x + y);
             case "-" -> output = (x - y);
             case "*" -> output = (x * y);
             case "/" -> output = (x / y);
         }
         String out = Integer.toString(output);
             return  out;
     }
}

enum Roman {
    I("1"), II("2"), III("3"), IV("4"), V("5"), VI("6"), VII("7"), VIII("8"), IX("9"), X("10"),
    XI("11"), XII("12"), XIII("13"), XIV("14"), XV("15"), XVI("16"), XVII("17"), XVIII("18"), XIX("19"),
    XX("20"), XXI("21"), XXII("22"), XXIII("23"), XXIV("24"), XXV("25"), XXVI("26"), XXVII("27"), XXVIII("28"), XXIX("29"),
    XXX("30"), XXXI("31"), XXXII("32"), XXXIII("33"), XXXIV("34"), XXXV("35"), XXXVI("36"), XXXVII("37"), XXXVIII("38"), XXXIX("39"),
    XXXX("40"), XXXXI("41"), XXXXII("42"), XXXXIII("43"), XXXXIV("44"), XXXXV("45"), XXXXVI("46"), XXXXVII("47"), XXXXVIII("48"), XXXXIX("49"),
    L("50"), LI("51"), LII("52"), LIII("53"), LIV("54"), LV("55"), LVI("56"), LVII("57"), LVIII("58"), LIX("59"),
    LX("60"), LXI("61"), LXII("62"), LXIII("63"), LXIV("64"), LXV("65"), LXVI("66"), LXVII("67"), LXVIII("68"), LXIX("69"),
    LXX("70"), LXXI("71"), LXXII("72"), LXXIII("73"), LXXIV("74"), LXXV("75"), LXXVI("76"), LXXVII("77"), LXXVIII("78"), LXXIX("79"),
    LXXX("80"), LXXXI("81"), LXXXII("82"), LXXXIII("83"), LXXXIV("84"), LXXXV("85"), LXXXVI("86"), LXXXVII("87"), LXXXVIII("88"), LXXXIX("89"),
    XC("90"), XCI("91"), XCII("92"), XCIII("93"), XCIV("94"), XCV("95"), XCVI("96"), XCVII("97"), XCVIII("98"), XCIX("99"), C("100");
    private final String value;
    private Roman(String value) {
        this.value = value;
    }

    // карта
    private static Map<String, Roman> map = new HashMap<>();
    static {
        for (Roman region : Roman.values()){
            map.put(region.value, region);
        }
    }

    // get
    public static Roman getRegByUid(String value) {
        return map.get(value);
    }
    public String toArab() {
        return value;
    }
}
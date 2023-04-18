import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите пример в формате 'A + B' арабскими или римскими цифрами");
        String scaner = scan.nextLine();
        String[] checkCount = scaner.split(" ");
            int ii = checkCount.length;
            if (ii != 3) {
                throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            String input = checkCount[0] + " " + checkCount[1] + " " + checkCount[2];
            try {
                System.out.println(calc(input));
            }
            catch (Exception e) {
                String[] romanInput = input.split(" ");
                try {
                    String x1 = Roman.valueOf(romanInput[0]).toArab();
                    String x2 = Roman.valueOf(romanInput[2]).toArab();
                    input = x1 + " " + romanInput[1] + " " + x2;
                    Roman aa = Roman.getRegByUid(calc(input));
                    System.out.println(aa);
                } catch (Exception no) {
                    throw new Exception("Нужно использовать одну систему счисления");
                }
            }
    }
     public static String calc(String input) throws Exception {
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
}

enum Roman {
    I("1"), II("2"), III("3"), IV("4"), V("5"), VI("6"), VII("7"), VIII("8"), IX("9"), X("10"),XI("11"), XII("12"), XIII("13"), XIV("14"), XV("15"), XVI("16"), XVII("17"), XVIII("18"), XIX("19"), XX("20");
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

    // get по uid
    public static Roman getRegByUid(String value) {
        return map.get(value);
    }
    public String toArab() {
        return value;
    }
}
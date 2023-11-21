import java.util.Scanner;

public class Main {

    public static String calc(String input) {
        String res = "";
        String[] str = input.split(" ");
        try {
            if (str.length == 3) {
                int arg1 = getRomeFromInt(str[0], rome);
                int arg2 = getRomeFromInt(str[2], rome);
                if ((arg1 >= 1) & (arg1 <= 10)) {
                    if ((arg2 >= 1) & (arg2 <= 10)) {
                        res = getIntFromRome(calculate(arg1, arg2, str[1], true), rome);
                    } else {
                        throw new Exception();
                    }
                } else if ((Integer.valueOf(str[0]) >= 1) & ((Integer.valueOf(str[0]) <= 10))) {
                    arg1 = Integer.valueOf(str[0]);
                    arg2 = Integer.valueOf(str[2]);
                    if ((arg2 >= 1) & (arg2 <= 10)) {
                        res = String.valueOf(calculate(arg1, arg2, str[1], false));
                    } else {
                        throw new Exception();
                    }

                } else {
                    throw new Exception();
                }

            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            res = "throws Exception";
        }
        return res;
    }

    private static String[] rome = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    private static int getRomeFromInt(String agr, String[] rome) {
        int res = 0;
        for (int i = 0; i < rome.length; i++) {
            if (agr.equals(rome[i])) res = i;
        }
        return res;
    }

    private static String getIntFromRome(int agr, String[] rome) {
        String res = "";
        for (int i = 0; i < rome.length; i++) {
            if (agr == i) res = rome[i];
        }
        return res;
    }

    private static int calculate(int arg1, int arg2, String calc, boolean rome) throws Exception {
        int res = 0;
        switch (calc) {
            case ("+"):
                res = arg1 + arg2;
                break;
            case ("-"):
                res = arg1 - arg2;
                break;
            case ("*"):
                res = arg1 * arg2;
                break;
            case ("/"):
                res = arg1 / arg2;
                break;
            default:
                throw new Exception();
        }

        if (rome) {
            if (res <= 0) {
                throw new Exception();
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println("Введите выражение - для вычисления или exit - для выхода");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String res = "";
        while(!line.equals("exit")) {
            res = calc(line);
            System.out.println(res);
            if(res.equals("throws Exception")) break;
            line = scanner.nextLine();
        }
    }
}
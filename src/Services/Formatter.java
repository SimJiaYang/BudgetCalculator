package Services;

import java.text.DecimalFormat;

public class Formatter {
    static DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    public static double formattedDecimal(double number){
        return Double.parseDouble(decimalFormat.format(number));
    }
}

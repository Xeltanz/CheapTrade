package hu.elte.alkfejl.cheaptrade.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CheapTradeUtils {
    public static String formatBigDecimal(BigDecimal bigDecimal) {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setGroupingUsed(true);
        return decimalFormat.format(bigDecimal);
    }
}

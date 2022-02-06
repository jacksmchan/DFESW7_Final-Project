package practical.project;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {
  private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance(Locale.UK);
  private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");

  public static Date parseDate(String date) {
    Date result = null;
    try {
      result = DATE_FORMATTER.parse(date);
    } catch(ParseException e) {
      e.printStackTrace();
    }
    return result;
  }

  public static String convertDateToString(Date date) {
    return null == date ? "" : DATE_FORMATTER.format(date);
  }

  public static String convertPriceToString(double price) {
    return CURRENCY_FORMATTER.format(price);
  }

  public static double formatStringToPrice(String price) throws ParseException {
    return Double.parseDouble(price);
  }
}

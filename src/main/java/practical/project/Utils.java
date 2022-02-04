package practical.project;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * The utilities for formatting data such as date and currency shared crossing this application
 *
 * @author jacksmchan
 */
public class Utils {
  private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance(Locale.UK);
  private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("MM/dd/yyyy");

  /**
   * Convert the given string into a Date object
   * 
   * @param date   the date in string form
   * @return a Date object if the string is valid; null, otherwise
   */
  public static Date parseDate(String date) {
    Date result = null;
    try {
      result = DATE_FORMATTER.parse(date);
    } catch(ParseException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Convert the given Date object into a string
   * 
   * @param date   a Date object
   * @return the string format of the given Date object
   */
  public static String convertDateToString(Date date) {
    return null == date ? "" : DATE_FORMATTER.format(date);
  }

  /**
   * Convert the given double number into the currency as a string 
   * 
   * @param price   a double value
   * @return the currency in string format of the given double value
   */
  public static String convertPriceToString(double price) {
    return CURRENCY_FORMATTER.format(price);
  }

  /**
   * Convert the given currency in string format into a double value
   * 
   * @param price   the given currency in string format
   * @return the double value of the valid given currency string
   * @throws NumberFormatException if the given currency string is invalid
   */
  public static double formatStringToPrice(String price) throws NumberFormatException {
    return Double.parseDouble(price);
  }
}

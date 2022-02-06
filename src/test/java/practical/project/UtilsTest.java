package practical.project;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

public class UtilsTest {
  @Test
  public void testParseDate() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(Utils.parseDate("02/01/2022"));
    assertTrue(cal.get(Calendar.YEAR) == 2022);
    assertTrue(cal.get(Calendar.MONTH) == 1);
    assertTrue(cal.get(Calendar.DAY_OF_MONTH) == 1);
  }

  @Test
  public void testConvertDateToString() {
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, 2022);
    cal.set(Calendar.MONTH, 1);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    String dateStr = Utils.convertDateToString(cal.getTime());
    assertTrue(dateStr.equals("02/01/2022"));
  }

  @Test
  public void testConvertPriceToString() {
    String curStr = Utils.convertPriceToString(1.1);
    assertTrue(curStr.equals("£1.10"));
  }

  @Test
  public void testFormatStringToPrice() {
    double price = Utils.formatStringToPrice("1.10");
    assertTrue(price == 1.1);
  }
}

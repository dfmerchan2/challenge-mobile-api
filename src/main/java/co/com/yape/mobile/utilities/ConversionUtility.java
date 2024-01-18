package co.com.yape.mobile.utilities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static co.com.yape.backend.utilities.Constants.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ConversionUtility {

    public static String upperCaseFirst(String value) {
        return StringUtils.capitalize(value.toLowerCase());
    }

    public static String formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_DATE_WITH_SLASH);
        LocalDate localDate = LocalDate.parse(date, formatter);
        DateTimeFormatter formatter1 =
                DateTimeFormatter.ofPattern(FORMAT_DATE_WITH_SPACES, Locale.US);
        return localDate.format(formatter1);
    }

    @SneakyThrows
    public static String formateDateCheck(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_DATE_WITH_SPACES, Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        return localDate.format(DateTimeFormatter.ofPattern("EEE MMM dd yyyy", Locale.ENGLISH));
    }

    public static String getDateCreditCard() {
        LocalDate localDate = LocalDate.now();
        LocalDate futureDate = localDate.plusYears(1);
        return futureDate.format(DateTimeFormatter.ofPattern("MMyy"));
    }

}
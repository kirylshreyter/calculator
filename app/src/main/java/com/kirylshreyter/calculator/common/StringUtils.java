package com.kirylshreyter.calculator.common;

import java.util.Locale;

/**
 * Class to provide additional functionality to extend native Java-functionality of {@link String}.
 */
public final class StringUtils {

    /**
     * Format {@link Double} for human-readable representation.
     * <p>
     * e.g. 0.0000 => 0
     * 7.95000 => 7.95
     *
     * @param formatted number to format
     * @return formatted {@link String} representation of {@code formatted}
     */
    public static String fmt(double formatted) {
        if (formatted == (long) formatted)
            return String.format(Locale.getDefault(), "%d", (long) formatted);
        else
            return String.format(Locale.getDefault(), "%s", formatted);
    }
}

package net.nllk.flywaychecksumtool;

/*
 * LATEST: https://github.com/flyway/flyway/blob/master/flyway-core/src/main/java/org/flywaydb/core/internal/util/StringUtils.java
 * USED: https://github.com/flyway/flyway/blob/b25e88d/flyway-core/src/main/java/org/flywaydb/core/internal/util/StringUtils.java
 */

public class StringUtils {

    /**
     * Trim the trailing linebreak (if any) from this string.
     *
     * @param str The string.
     * @return The string without trailing linebreak.
     */
    public static String trimLineBreak(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuilder buf = new StringBuilder(str);
        while (buf.length() > 0 && isLineBreakCharacter(buf.charAt(buf.length() - 1))) {
            buf.deleteCharAt(buf.length() - 1);
        }
        return buf.toString();
    }

    /**
     * Checks whether this string is not {@code null} and not <i>empty</i>.
     *
     * @param str The string to check.
     * @return {@code true} if it has content, {@code false} if it is {@code null} or blank.
     */
    public static boolean hasLength(String str) {
        return str != null && str.length() > 0;
    }

    /**
     * Checks whether this character is a linebreak character.
     *
     * @param ch The character
     * @return {@code true} if it is, {@code false} if not.
     */
    private static boolean isLineBreakCharacter(char ch) {
        return '\n' == ch || '\r' == ch;
    }
}

package home;

public class StringUtil {

    // utility for making correctly padded binary from integer when using Integer.toBinaryString
    public static String toBinaryString(int number) {
        final short size = 8;
        // i'm guessing there is some bit-shifting thing we could do instead but i'm not experienced with that
        final String pattern = String.format("%%0%dd", size);
        final String padding = String.format(pattern, 0);
        final String response = String.format("%s%s", padding, Integer.toBinaryString(number));

        return response.substring(response.length() - size);
    }

}

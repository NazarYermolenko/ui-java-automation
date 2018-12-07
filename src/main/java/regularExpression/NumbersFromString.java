package regularExpression;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersFromString {
    private final static String pattern = "\\d*\\.?\\d+";

    public static void main(String[] args) {
        StringBuffer data = new StringBuffer("Lorem 2.15 ipsum 5,3,45 dolor 5,7 sit 132.45 amet," +
                "3rd consectetur adipiscing 15th");

        Matcher matcher = Pattern.compile(pattern).matcher(data);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append(matcher.group() + " ");
        }
        System.out.println(result);
    }

}

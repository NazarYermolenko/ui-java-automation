package regularExpression;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneNumbers {
    private final static String pattern = "\\(?\\d{3}\\)?(\\s?\\d{3}\\s?|\\-?\\d{3}\\-|\\.\\d{3}\\.)\\d{4}";

    public static void main(String[] args) {

        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("(123) 456 7899");
        phoneNumbers.add("(123).456.7899");
        phoneNumbers.add("(123)-456-7899");
        phoneNumbers.add("123-456-7899");
        phoneNumbers.add("123-456-7899");
        phoneNumbers.add("123 456 7899");
        phoneNumbers.add("1234567899");
        phoneNumbers.add("911");
        phoneNumbers.add("067-56-5412");
        phoneNumbers.add("(123).456-7899");

        StringBuilder results = new StringBuilder();
        for (String phoneNumber : phoneNumbers) {
            Matcher matcher = Pattern.compile(pattern).matcher(phoneNumber);
            while (matcher.find()) {
                results.append(matcher.group() + "\n");
            }
        }
        System.out.println(results);
    }

}

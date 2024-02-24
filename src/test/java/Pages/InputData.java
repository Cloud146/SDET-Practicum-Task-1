package Pages;

import java.util.Random;

public class InputData {

    public String addCustomerPageURL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust";
    public String customersPageURL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list";

    public String postCode = generatePostCode();
    public String firstName = generateFirstName(postCode);
    public String lastName = "Test";
    public String Customer = firstName +", " +lastName +", " +postCode;

    private static final int POST_CODE_LENGTH = 10;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String generatePostCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < POST_CODE_LENGTH; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String generateFirstName(String postCode) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < postCode.length(); i += 2) {
            int digit = Integer.parseInt(postCode.substring(i, i + 2));
            char letter = ALPHABET.charAt(digit % ALPHABET.length());
            sb.append(letter);
        }
        return sb.toString();
    }
}

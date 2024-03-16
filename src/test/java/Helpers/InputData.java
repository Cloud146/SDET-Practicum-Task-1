package Helpers;

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

    public String validAscData = "A_firstName, LastName, postCode, , Delete \n" +
            "Albus, Dumbledore, E55656, 1010 1011 1012, Delete \n" +
            "Harry, Potter, E725JB, 1004 1005 1006, Delete \n" +
            "Hermoine, Granger, E859AB, 1001 1002 1003, Delete \n" +
            "Neville, Longbottom, E89898, 1013 1014 1015, Delete \n" +
            "Ron, Weasly, E55555, 1007 1008 1009, Delete \n" +
            "Z_firstName, LastName, postCode, , Delete";
    public String validDescData = "Z_firstName, LastName, postCode, , Delete \n" +
            "Ron, Weasly, E55555, 1007 1008 1009, Delete \n" +
            "Neville, Longbottom, E89898, 1013 1014 1015, Delete \n" +
            "Hermoine, Granger, E859AB, 1001 1002 1003, Delete \n" +
            "Harry, Potter, E725JB, 1004 1005 1006, Delete \n" +
            "Albus, Dumbledore, E55656, 1010 1011 1012, Delete \n" +
            "A_firstName, LastName, postCode, , Delete";
}

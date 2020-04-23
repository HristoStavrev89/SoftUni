package Dec_20_1018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String check = "(?<activator>\\A[\\w]+\\z)";
        Pattern pattern = Pattern.compile(check);
        String[] input = scanner.nextLine().split("&");

        StringBuilder result = new StringBuilder();
        List<String> keys = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {


            Matcher matcher = pattern.matcher(input[i]);

            if (matcher.find()) {
                String symbols = matcher.group("activator");

                int length = symbols.length();
                int count = 0;

                for (int j = 0; j < symbols.length(); j++) {
                    char current = symbols.charAt(j);

                    if (current > 47 && current < 58) {
                        int num = 9 - Character.getNumericValue(current);

                        result.append(num);

                    } else {
                        result.append(current);
                    }
                    count++;
                    if (count == symbols.length()) {


                        count=1;


                        if (result.length() == 16) {
                            String sixTeen = result.toString().toUpperCase();
                            String keys16 = "";

                            int counter = 0;
                            int lineCounter = 0;
                            for (int k = 0; k < sixTeen.length(); k++) {
                              //  System.out.print(sixTeen.charAt(k));
                                keys16 += sixTeen.charAt(k);
                                counter++;
                                if (counter % 4 == 0)  {
                                    lineCounter++;
                                    if (lineCounter > 3) {
                                        break;
                                    }
                                    keys16 += "-";

                                }

                            }


                            keys.add(keys16.toString().toUpperCase());



                        }
                        if (result.length() == 25) {
                            String sixTeen = result.toString().toUpperCase();
                            String keys25 = "";

                            int counter = 0;
                            int lineCounter = 0;
                            for (int k = 0; k < sixTeen.length(); k++) {
                              // System.out.print(sixTeen.charAt(k));
                                keys25 += sixTeen.charAt(k);
                                counter++;
                                if (counter % 5 == 0)  {
                                    lineCounter++;
                                    if (lineCounter > 4) {
                                        break;
                                    }
                                    keys25 += "-";
                                   // System.out.print("-");
                                }

                            }


                            keys.add(keys25.toUpperCase());



                        }

                        result.delete(0,result.length());



                    }


                }

            }

        }

        System.out.println(keys.toString().replaceAll("[\\]\\[]",""));


    }
}

package telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phoneNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        List<String> urls = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Callable nums = new Smartphone(phoneNumbers, urls);
        Smartphone url = new Smartphone(phoneNumbers, urls);

        nums.call();

        //todo try the same with browsableshit

//        for (int i = 0; i < phoneNumbers.size(); i++) {
//            System.out.println(nums.call() + phoneNumbers.get(i));
//        }


        for (int i = 0; i < urls.size(); i++) {
            if (isValidUrl(urls.get(i))) {
                System.out.println(url.browse() + urls.get(i) + "!");
            } else {
                System.out.println("Invalid URL!");
            }

        }
    }

    private static boolean isValidUrl(String url) {
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                return false;
            }
        }
        return true;
    }




}

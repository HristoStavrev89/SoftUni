import java.util.Scanner;

public class kaminoFactory {
    public static void main(String[] args) {
//        The clone factory in Kamino got another order to clone troops. But this time you are tasked to find the best DNA sequence to use in the production.
//                You will receive the DNA length and until you receive the command "Clone them!" you will be receiving a DNA sequences of ones and zeroes, split by "!" (one or several).
//        You should select the sequence with the longest subsequence of ones. If there are several sequences with same length of subsequence of ones, print the one with the leftmost starting index,
//        if there are several sequences with same length and starting index, select the sequence with the greater sum of its elements.
//                After you receive the last command "Clone them!" you should print the collected information in the following format:
//        "Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
//        "{DNA sequence, joined by space}"

//        Input / Constraints
//        The first line holds the length of the sequences – integer in range [1…100];
//        On the next lines until you receive "Clone them!" you will be receiving sequences (at least one) of ones and zeroes, split by "!" (one or several).

//        Output
//        The output should be printed on the console and consists of two lines in the following format:
//        "Best DNA sample {bestSequenceIndex} with sum: {bestSequenceSum}."
//        "{DNA sequence, joined by space}"
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String input = "";

        while (!"Clone them!".equals(scanner.nextLine())) {

            String[] data = scanner.nextLine().split("!+");

            int[] sequenceDNA = new int[length];
            int index = 0;

            for (int i = 0; i < data.length; i++) {
                sequenceDNA[index++] = Integer.parseInt(data[i]);
            }
            int maxCount = 0;
            int sequenceIndex = 0;
            for (int i = 0; i < sequenceDNA.length; i++) {
                int currentCount = 0;
                for (int j = i; j < sequenceDNA.length; j++) {
                    if (sequenceDNA[i] == (sequenceDNA[j])) {
                        currentCount++;
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                            sequenceIndex = i;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            System.out.println(sequenceIndex);


        }

        }
    }

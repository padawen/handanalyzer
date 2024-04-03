import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Handelemzes {
    private static final String FOUR_OF_A_KIND = ".*([2-9TJQKA])[shdc](?!.*\\1[shdc]{2}).*\\1[shdc].*\\1[shdc].*\\1[shdc].*";
    private static final String FULL_HOUSE_1 = ".*([2-9TJQKA])[shcd]\\1[shdc]++\\1.*([2-9TJQKA])[shcd].*\\2[shdc].*";
    private static final String FULL_HOUSE_2 = ".*([2-9TJQKA])[shcd]\\1[shdc].*([2-9TJQKA])[shcd]\\2\\2[shdc].*";
    private static final String THREE_OF_A_KIND = ".*([2-9TJQKA])[shdc].*\\1[shdc].*\\1[shdc].*";

    private static final String ONE_PAIR = ".*([2-9TJQKA])[shdc].*\\1[shdc].*";

    // nem birtam mukodesre birni
    //private static final String TWO_PAIR = ".*([2-9TJQKA]).*\\1.*.*([2-9TJQKA])(?!\\1).*\\2.*";


    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Kérem adja meg az input és output fájlneveket!");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        ArrayList<String> hands = readHandsFromFile(inputFile);
        ArrayList<String> results = analyzeHands(hands);
        writeResultsToFile(results, outputFile);
    }

    private static ArrayList<String> readHandsFromFile(String fileName) {
        ArrayList<String> hands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                hands.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hands;
    }

    static ArrayList<String> analyzeHands(ArrayList<String> hands) {
        ArrayList<String> results = new ArrayList<>();
        String dealerHand = hands.get(0);

        int fourOfAKindCount = 0;
        int fullHouseCount = 0;
        int threeOfAKindCount = 0;
        int twoPairCount = 0;
        int onePairCount = 0;

        for (int i = 1; i < hands.size(); i++) {
            String combinedHand = dealerHand + hands.get(i);
            String handRank;
            if (Pattern.matches(FULL_HOUSE_1, combinedHand) || Pattern.matches(FULL_HOUSE_2, combinedHand)) {
                handRank = "Full House";
                fullHouseCount++;
            } else if (Pattern.matches(FOUR_OF_A_KIND, combinedHand)) {
                handRank = "Four of a Kind";
                fourOfAKindCount++;
            } else if (Pattern.matches(THREE_OF_A_KIND, combinedHand)) {
                handRank = "Three of a Kind";
                threeOfAKindCount++;
           //} else if (Pattern.matches(TWO_PAIR, combinedHand)) {
           //    handRank = "Two Pair";
           //    twoPairCount++;
            } else if (Pattern.matches(ONE_PAIR, combinedHand)) {
                handRank = "One Pair";
                onePairCount++;
            } else {
                handRank = "High Card";
            }

            results.add(i + ". játékos kéz értékelése: " + handRank);
        }

        results.add("Four of a Kinds: " + fourOfAKindCount);
        results.add("Full Houses: " + fullHouseCount);
        results.add("Three of a Kinds: " + threeOfAKindCount);
        results.add("Two Pairs: " + twoPairCount);
        results.add("One Pairs: " + onePairCount);

        return results;
    }

    private static void writeResultsToFile(ArrayList<String> results, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String result : results) {
                writer.write(result + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

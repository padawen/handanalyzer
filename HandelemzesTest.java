import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class HandelemzesTest {

    @Test
    public void test_four_three() {

        ArrayList<String> testHands = new ArrayList<>(Arrays.asList(
                "2d3s6d9c9d",
                "9h9s",
                "6h6s"
        ));
        ArrayList<String> expectedResults = new ArrayList<>(Arrays.asList(
                "1. játékos kéz értékelése: Four of a Kind",
                "2. játékos kéz értékelése: Three of a Kind",
                "Four of a Kinds: 1",
                "Full Houses: 0",
                "Three of a Kinds: 1",
                "Two Pairs: 0",
                "One Pairs: 0"
        ));
        System.out.println(expectedResults);
        System.out.println(Handelemzes.analyzeHands(testHands));
        ArrayList<String> results = Handelemzes.analyzeHands(testHands);
        assertEquals(expectedResults, results);
    }

    @Test
    public void test_full1() {

        ArrayList<String> testHands = new ArrayList<>(Arrays.asList(
                "9d9s9h4c2d",
                "4d4s"
        ));
        ArrayList<String> expectedResults = new ArrayList<>(Arrays.asList(
                "1. játékos kéz értékelése: Full House",
                "Four of a Kinds: 0",
                "Full Houses: 1",
                "Three of a Kinds: 0",
                "Two Pairs: 0",
                "One Pairs: 0"
        ));
        System.out.println(expectedResults);
        System.out.println(Handelemzes.analyzeHands(testHands));
        ArrayList<String> results = Handelemzes.analyzeHands(testHands);
        assertEquals(expectedResults, results);
    }

    @Test
    public void test_full2() {
        ArrayList<String> testHands = new ArrayList<>(Arrays.asList(
                "6d6s2h2c2d",
                "6c6h"
        ));
        ArrayList<String> expectedResults = new ArrayList<>(Arrays.asList(
                "1. játékos kéz értékelése: Full House",
                "Four of a Kinds: 0",
                "Full Houses: 1",
                "Three of a Kinds: 0",
                "Two Pairs: 0",
                "One Pairs: 0"
        ));
        System.out.println(expectedResults);
        System.out.println(Handelemzes.analyzeHands(testHands));
        ArrayList<String> results = Handelemzes.analyzeHands(testHands);
        assertEquals(expectedResults, results);
    }


    @Test
    public void test_pair() {

        ArrayList<String> testHands = new ArrayList<>(Arrays.asList(
                "4s5d7h8c6h",
                "4dAs"
        ));
        ArrayList<String> expectedResults = new ArrayList<>(Arrays.asList(
                "1. játékos kéz értékelése: One Pair",
                "Four of a Kinds: 0",
                "Full Houses: 0",
                "Three of a Kinds: 0",
                "Two Pairs: 0",
                "One Pairs: 1"
        ));
        System.out.println(expectedResults);
        System.out.println(Handelemzes.analyzeHands(testHands));
        ArrayList<String> results = Handelemzes.analyzeHands(testHands);
        assertEquals(expectedResults, results);
    }
}



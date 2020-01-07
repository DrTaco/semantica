import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Utils {

    public boolean isPalindrome(String word) {
        return word.equals(new StringBuffer(word).reverse().toString());
    }

    public boolean isArmstrongNumber(int number) {
        String[] split = String.valueOf(number).split("");
        List<String> numbers = Arrays.asList(split);

        int total = 0;

        for (String s : numbers) {
            total += Math.pow(Integer.valueOf(s), split.length);
        }

        return total == number;
    }

    public String eachWordWithCapitalLetter(String sentence) {
        sentence.replaceAll("  ", " ");

        List<String> words = Arrays.asList(sentence.split(" "));
        StringJoiner sj = new StringJoiner(" ");

        words.forEach(w -> sj.add(StringUtils.capitalize(w)));
        return sj.toString();

    }

    public int closestNumberToZeroIfSamePositive(int[] numbers) {
        return Arrays.stream(numbers).filter(i -> i != 0)
                .reduce((a, b) -> abs(a) < abs(b) ? a : (abs(a) == abs(b) ? max(a, b) : b)).getAsInt();
    }

    public List<String> getWordsStartingWith(String[] words, String startWith) {
        List<String> stringList = Arrays.asList(words);

        return stringList.stream().filter(w -> StringUtils.startsWith(w, startWith)).collect(Collectors.toList());
    }

    public boolean elementBeforeAnother(String[] fruit, String before, String after) {

        List<String> fruitList = Arrays.asList(fruit);

        int i = fruitList.indexOf(before);
        int j = fruitList.indexOf(after);

        return i < j;
    }

    public List<Animal> sortAnimals(List<Animal> animals) {
        Collections.sort(animals);
        return animals;
    }
}

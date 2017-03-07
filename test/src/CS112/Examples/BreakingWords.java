package CS112.Examples;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by davidzhou on 3/3/17.
 */
public class BreakingWords {

    public static String space(Set<String> dict, String input){

        if (dict.contains(input)) return input;

        for (int i = 0; i < input.length(); i++) {
            String prefix = input.substring(0,i);

            if (dict.contains(prefix)) {
                String suffix = input.substring(i);
                String segSuffix = space(dict, suffix);
                if (segSuffix != null) return prefix + " " + suffix;
            }

        }
        return null;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("to");
        dict.add("day");
        dict.add("today");
        dict.add("us");
        dict.add("use");
        dict.add("at");
        dict.add("eat");
        System.out.println(space(dict, "today"));
    }
}

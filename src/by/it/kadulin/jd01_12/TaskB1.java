package by.it.kadulin.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        HashMap<String, Integer> strings = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("end")) {
                break;
            }
            stringBuilder.append(str);
        }

        String text = "The battle for gaming supremacy between Intel and AMD has never been as intense as it is now, but AMD has a new ace in the hole. AMD's $449 Ryzen 7 5800X3D uses new cutting-edge 3D-stacked SRAM technology, called 3D V-Cache, to enable a total of 96MB of L3 cache that unlocks tremendous gaming performance, unseating Intel's expensive $738 Core i9-12900KS as the fastest of the Best CPUs for gaming — but at a more forgiving price point. AMD pulled this feat off with an eight-core 16-thread chip based on the same 7nm process and Zen 3 architecture as the original Ryzen 5000 chips that debuted back in 2020, but uses an innovative hybrid bonding technology to fuse an extra slice of cache atop the processing cores, a first for desktop PCs.";
        Pattern compile = Pattern.compile("\\w+[-]?\\w*[']*\\w?\\d*");
        Matcher matcher = compile.matcher(stringBuilder.toString());
        while (matcher.find()) {
            String word = matcher.group();
            if (!strings.containsKey(word)) {
                strings.put(word, 1);
            }
            else if (strings.containsKey(word)) {
                strings.put(word, strings.get(word) + 1);
            }
        }
        System.out.println(strings.size());
        for (Map.Entry<String, Integer> map : strings.entrySet()) {
            System.out.printf("%s=%d%n", map.getKey(), map.getValue());
        }

    }
}

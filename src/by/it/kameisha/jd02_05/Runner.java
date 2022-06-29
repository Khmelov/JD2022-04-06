package by.it.kameisha.jd02_05;


import java.util.*;

public class Runner {
    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANCE;
        Locale locale = args.length == 2 ? new Locale(args[0], args[1]) : new Locale("");
        resMan.startWithLocaleConfig(locale);
        Scanner scanner = new Scanner(System.in);
        List<String> locales = new ArrayList<>(Arrays.asList("ru", "en", "be"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            } else if (locales.contains(input)) {
                locale = new Locale(input.trim());
                resMan.startWithLocaleConfig(locale);
            }
        }
    }

}
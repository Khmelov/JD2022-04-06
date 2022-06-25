package by.it.marchenko.jd02_05;

import by.it.marchenko.jd02_05.util.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TaskB implements Message {

    public static final String MESSAGE_FORMAT = "%-20s: %s %s %s %s.%n";

    public static final String END_COMMAND = "end";
    public static final String BE_COMMAND = "be";
    public static final String RU_COMMAND = "ru";
    public static final String EN_COMMAND = "en";

    private static final Set<String> availableCommands = new HashSet<>(Arrays.asList(
            END_COMMAND, EN_COMMAND, BE_COMMAND, RU_COMMAND
    ));

    public static void main(String[] args) {
        Converter.createResourceFromText();

        Scanner console = new Scanner(System.in);
        Locale locale = Locale.getDefault();
        Locale localeBe = new Locale(BE_COMMAND);
        Locale localeEn = new Locale(EN_COMMAND);
        Locale localeRu = new Locale(RU_COMMAND);
        ResourceManager resourceManager = ResourceManager.INSTANCE;

        while (Objects.nonNull(locale)) {
            System.out.println(resourceManager.getString(INSTRUCTION));
            String command = console.nextLine();
            if (availableCommands.contains(command.toLowerCase())) {
                if (command.equalsIgnoreCase(END_COMMAND)) {
                    break;
                }
                locale = switch (command) {
                    case BE_COMMAND -> localeBe;
                    case EN_COMMAND -> localeEn;
                    case RU_COMMAND -> localeRu;
                    default -> Locale.getDefault();
                };
                resourceManager.changeResource(locale);
                LocalDate currentLocalDate = LocalDate.now();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyy", locale);
                //System.out.println(dateTimeFormatter.format(currentLocalDate));

                System.out.printf(MESSAGE_FORMAT,
                        dateTimeFormatter.format(currentLocalDate),
                        resourceManager.getString(GREETING),
                        resourceManager.getString(PERSON),
                        resourceManager.getString(FIRSTNAME),
                        resourceManager.getString(LASTNAME)
                );
            } else {
                System.out.println(resourceManager.getString(INCORRECT_LANGUAGE));
                resourceManager.changeResource(Locale.getDefault());
            }
        }
    }
}

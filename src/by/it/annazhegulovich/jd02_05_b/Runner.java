package by.it.annazhegulovich.jd02_05_b;

import java.text.DateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public static final String LOCALE = "Введите язык";

    public static void main(String[] args) {
        ResMan resMan = ResMan.INSTANSE;
        //переключение языка c клавиатуры
        Scanner sc = new Scanner(System.in);
        String language;
do {
    System.out.println(LOCALE);
    language = sc.nextLine();
} while (!"ru".equals(language)^!language.equals("be")^!language.equals("en"));

        Locale locale = Locale.forLanguageTag(language);
        resMan.setLocale(locale);
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        String s = df.format(new Date());
        System.out.println(resMan.get(massage.WELCOME));
        System.out.println(resMan.get(massage.QUESTION1));
        System.out.println(resMan.get(massage.QUESTION2));
        System.out.println(resMan.get(answer.QUESTION1));
        System.out.println(resMan.get(answer.QUESTION2));
        System.out.println(s);
    }
}

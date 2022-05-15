package by.it._tasks_.jd01_12;


import by.it.HomeWork;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("all")

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Test_jd01_12 extends HomeWork {

    static final String text =
            "\n" +
                    "Nadine Gordimer \n" +
                    "\n" +
                    "\n" +
                    "Nadine Gordimer \n" +
                    "\n" +
                    "Once upon a Time \n" +
                    "\n" +
                    "Someone has written to ask me to contribute to an anthology of stories for children. I \n" +
                    "reply that I don't write children's stories; and he writes back that at a recent congress/book \n" +
                    "fair/seminar a certain novelist said every writer ought to write at least one story for \n" +
                    "children. I think of sending a postcard saying I don't accept that I \"ought\" to write anything. \n" +
                    "\n" +
                    "And then last night I woke up — or rather was awakened without knowing what had \n" +
                    "roused me. \n" +
                    "\n" +
                    "A voice in the echo-chamber of the subconscious? \n" +
                    "\n" +
                    "A sound. \n" +
                    "\n" +
                    "A creaking of the kind made by the weight carried by one foot after another along a \n" +
                    "wooden floor. I listened. I felt the apertures of my ears distend with concentration. Again: \n" +
                    "the creaking. I was waiting for it; waiting to hear if it indicated that feet were moving from \n" +
                    "room to room, coming up the passage — to my door. I have no burglar bars, no gun under the \n" +
                    "pillow, but I have the same fears as people who do take thse precautions, and my \n" +
                    "windowpanes are thin as rime, could shatter like a wineglass. A woman was murdered (how \n" +
                    "do they put it) in broad daylight in a house two blocks away, last year, and the fierce dogs \n" +
                    "who guarded an old widower and his collection of antique clocks were strangled before he \n" +
                    "was knifed by a casual laborer he had dismissed without pay. \n" +
                    "\n" +
                    "I was staring at the door, making it out in my mind rather than seeing it, in the dark. I lay quite \n" +
                    "still — a victim already — the arrhythmia of my heart was fleeing, knocking this way and that \n" +
                    "against its body-cage. How finely tuned the senses are, just out of rest, sleep! I could never listen \n" +
                    "intently as that in the distractions of the day, I was reading every faintest sound, identifying and \n" +
                    "classifying its possible threat. \n" +
                    "\n" +
                    "But I learned that I was to be neither threatened nor spared. There was no human weight \n" +
                    "pressing on the boards, the creaking was a buckling, an epicenter of stress. I was in it. The house \n" +
                    "that surrounds me while I sleep is built on undermined ground; far beneath my bed, the floor, the \n" +
                    "house's foundations, the stopes and passages of gold mines have hollowed the rock, and when some \n" +
                    "face trembles, detaches and falls, three thousand feet below, the whole house shifts slightly, \n" +
                    "bringing uneasy strain to the balance and counterbalance of brick, cement, wood and glass that hold it \n" +
                    "as a structure around me. The misbeats of my heart tailed off like the last muffled flourishes on one \n" +
                    "of the wooden xylophones made by the Chopi and T songa 1 migrant miners who might have been \n" +
                    "down there, under me in the earth at that moment. The stope where the fall was could have been \n" +
                    "disused, dripping water from its ruptured veins; or men might now be interred there in the most \n" +
                    "profound of tombs. \n" +
                    "\n" +
                    "I couldn't find a position in which my mind would let go of my body — release me to sleep \n" +
                    "again. So I began to tell myself a story, a bedtime story. \n" +
                    "\n" +
                    "In a house, in a suburb, in a city, there were a man and his wife who loved each other very much \n" +
                    "and were living happily ever after. They had a little boy, and they loved him very much. They had \n" +
                    "a cat and a dog that the little boy loved very much. They had a car and a caravan trailer for \n" +
                    "holidays, and a swimming-pool which was fenced so that the little boy and his playmates would \n" +
                    "not fall in and drown. They had a housemaid who was absolutely trustworthy and an itinerant \n" +
                    "gardener who was highly recommended by the neighbors. For when they began to live happily ever \n" +
                    "after they were warned, by that wise old witch, the husband's mother, not to take on anyone off the \n" +
                    "street. They were inscribed in a medical benefit society, their pet dog was licensed, they were \n" +
                    "insured against fire, flood damage and theft, and subscribed to the local Neighborhood Watch, \n" +
                    "which supplied them with a plaque for their gates lettered Y OU HAVE BEEN WARNED \n" +
                    "over the silhouette of a would-be intruder. He was masked; it could not be said if he was \n" +
                    "black or white, and therefore proved the property owner was no racist. \n" +
                    "\n" +
                    "It was not possible to insure the house, the swimming pool or the car against riot \n" +
                    "damage. There were riots, but these were outside the city, where people of another color \n" +
                    "were quartered. These people were not allowed into the suburb except as reliable\n" +
                    "end\n";

    @Test(timeout = 1500)
    public void testTaskA1() throws Exception {
        Class<?> aclass = findClass("TaskA1");
        Method m = findMethod(aclass, "clearBad", List.class);
        Integer[] grades = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(grades));
        Object instance = aclass.getDeclaredConstructor().newInstance();
        System.out.println("Дано: " + list);
        System.out.flush();
        m.setAccessible(true);
        m.invoke(instance, list);
        assertEquals("Метод clearBad реализован неверно", "[4, 5, 6, 7, 8, 9, 9, 8, 7, 6, 5, 4]", list.toString());
        System.out.println("Итог: " + list);
        System.out.flush();
    }

    @Test(timeout = 1500)
    public void testTaskA2() throws Exception {
        Class<?> aclass = findClass("TaskA2");
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        System.out.println("Проверка на множестве " + a + " и множестве " + b);
        System.out.flush();

        Method union = findMethod(aclass, "getUnion", Set.class, Set.class);
        union.setAccessible(true);
        assertEquals("Метод getUnion работает некорректно",
                "[1, 2, 3, 4, 5, 6, 7, 8, 9]",
                new TreeSet<Integer>((Collection<? extends Integer>) union.invoke(null, a, b)).toString());

        Method cross = findMethod(aclass, "getCross", Set.class, Set.class);
        cross.setAccessible(true);
        assertEquals("Метод getCross работает некорректно",
                "[4, 5, 6]",
                new TreeSet<Integer>((Collection<? extends Integer>) cross.invoke(null, a, b)).toString());
        System.out.println("прошла успешно.");
    }


    @Test(timeout = 1500)
    public void testTaskA3() throws Exception {
        run("-1\n2\n-3\n4\n-5\n6\n-7\n8\n-9\n0\n9\n-8\n7\n-6\n5\n-4\n3\n-2\n1\n0\nend")
                .include("2, 4, 6, 8, 9, 7, 5, 3, 1, 0, 0, -1, -3, -5, -7, -9, -8, -6, -4, -2");
    }

    @Test(timeout = 12000)
    public void testTaskB1() throws Exception {
        run(text)
                .include("been=2")
                .include("BEEN=1")
                .include("I=21")
                .include("don't=2")
                .include("year=1")
                .include("at=4")
                .include("much=3")
                .include("proved=1")
                .include("same=1")
                .include("T=1")
                .include("hollowed=1")
                .include("veins=1")
                .include("strangled=1")
                .include("laborer=1")
                .include("which=3")
                .include("pay=1")
                .include("its=3")
                .include("profound=1")
                .include("take=2")
                .include("therefore=1")
                .include("little=3")
                .include("identifying=1")
                .include("waiting=2")
                .include("rather=2")
                .include("for=5")
                .include("intently=1")
                .include("just=1")
                .include("blocks=1")
                .include("go=1")
                .include("room=2")
                .include("with=2")
                .include("there=3")
                .include("he=4")
                .include("bedtime=1")
                .include("supplied=1")
                .include("could=4")
                .include("drown=1")
                .include("that=13")
                .include("than=1")
                .include("me=6")
                .include("below=1")
                .include("my=9")
                .include("heart=2")
                .include("And=1")
                .include("were=11")
                .include("position=1")
                .include("no=4")
                .include("around=1")
                .include("boy=3")
                .include("house's=1")
                .include("and=24")
                .include("of=18")
                .include("before=1")
                .include("sound=2")
                .include("said=2")
                .include("stories=2")
                .include("reliable=1")
        ;
    }

    @Test(timeout = 1500)
    public void testTaskB2() throws Exception {
        Class<?> aclass = findClass("TaskB2");
        Method mA = findMethod(aclass, "process", ArrayList.class);
        mA.setAccessible(true);
        Method mL = findMethod(aclass, "process", LinkedList.class);
        mL.setAccessible(true);
        int[] expectedRes = {1, 1, 3, 1, 3, 5, 7, 1, 3, 5, 7, 9, 11, 13, 15, 1};
        for (int n = 1; n <= expectedRes.length; n++) {
            ArrayList<String> arra = new ArrayList<>();
            LinkedList<String> arrl = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                arra.add("n" + i);
                arrl.add("n" + i);
            }
            System.out.println("ArrayList=" + arra);
            System.out.flush();
            System.out.println("LinkedList=" + arrl);
            System.out.flush();
            assertEquals("Методы возвращают разные результаты", mA.invoke(null, arra), mL.invoke(null, arrl));
            assertEquals("Метод c ArrayList работает неверно", "n" + expectedRes[n - 1], mA.invoke(null, arra));
            System.out.println("  process(ArrayList  arr)=" + "n" + expectedRes[n - 1]);
            System.out.flush();
            assertEquals("Метод с LinkedList работает неверно", "n" + expectedRes[n - 1], mL.invoke(null, arrl));
            System.out.println("  process(LinkedList arr)=" + "n" + expectedRes[n - 1]);
            System.out.flush();
        }
        System.out.println("OK");
    }

    @Test(timeout = 1500)
    public void testTaskB3() throws Exception {
        Class<?> aclass = findClass("TaskB3");
        Method mA = findMethod(aclass, "process", ArrayList.class);
        mA.setAccessible(true);
        Method mL = findMethod(aclass, "process", LinkedList.class);
        mL.setAccessible(true);
        int[] expectedRes = new int[4096];
        expectedRes[expectedRes.length - 1] = 1;
        int n = expectedRes.length;
        ArrayList<String> arra = new ArrayList<>(n);
        LinkedList<String> arrl = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arra.add("n" + i);
            arrl.add("n" + i);
        }
        Long t = System.nanoTime();
        String rA = (String) mA.invoke(null, arra);
        Long tA = System.nanoTime() - t;

        t = System.nanoTime();
        String rL = (String) mL.invoke(null, arrl);
        Long tL = System.nanoTime() - t;

        assertEquals("Метод c ArrayList  работает неверно", "n" + expectedRes[n - 1], rA);
        assertEquals("Метод с LinkedList работает неверно", "n" + expectedRes[n - 1], rL);

        System.out.println(" Время работы для  ArrayList=" + tA / 1000 + " мкс.");
        System.out.flush();
        System.out.println(" Время работы для LinkedList=" + tL / 1000 + " мкс.");
        System.out.flush();

        assertTrue(" Время работы для  ArrayList должно быть существенно больше LinkedList", tA > tL * 12 / 10);

    }

    @Test(timeout = 1500)
    public void testTaskC1() throws Exception {
        String t = text.replaceAll("[^a-zA-Z']+", "\n");
        HomeWork app = run(t.replaceFirst("\\n", "").concat("end\n"));
        app.strOut.flush();
        System.out.println("------ Проверка начинается ------");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(app.strOut.toString().split("\\n")));
        list.removeIf(line -> !line.contains("{"));
        Assert.assertEquals("Ошибка вывода (нужны две карты через toString)", 2, list.size());
        Map<Long, String> mapC1 = mapC1(list.get(0));
        System.out.println(mapC1);
        Assert.assertEquals("Неверное число элементов на входе", 782, mapC1.size());
        Map<Long, String> mapC2 = mapC1(list.get(1));
        System.out.println(mapC2);
        Assert.assertEquals("Неверное число элементов на выходе", 400, mapC2.size());
    }

    @Test(timeout = 1500)
    public void testTaskC2() throws Exception {
        Class<?> aclass = findClass("TaskC2");
        Set<Long> a = new HashSet<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L));
        Set<Integer> b = new HashSet<Integer>(Arrays.asList(4, 3, 5, 6, 7, 8));
        Set<Double> c = new HashSet<Double>(Arrays.asList(0., 1., 2., 3., 4., 5.));
        Set<Double> d = new HashSet<Double>(Arrays.asList(2., 3., 4., 9.));

        Class[] sets = new Class[]{Set[].class};
        Method union = findMethod(aclass, "getUnion", sets);
        union.setAccessible(true);
        Set<?> result = (Set<?>) union.invoke(null, (Object) new Set[]{a, b, b, c, c, d});
        System.out.println(result);
        assertEquals("Метод getUnion работает некорректно",
                10, result.size());
        Method cross = findMethod(aclass, "getCross", sets);
        cross.setAccessible(true);
        Set<?> result2 = (Set<?>) cross.invoke(null, (Object) new Set[]{a, a, b, c, c, d});
        System.out.println(result2);
        assertEquals("Метод getCross работает некорректно",
                2, result2.size());
        System.out.println("проверка прошла успешно.");
    }

    @Test(timeout = 1500)
    public void testTaskC3() throws Exception {
        run("{[{()}][()]{()}}\n").include("true").exclude("false");
        run("{[{()}][()]{()}]\n").include("false").exclude("true");
        run("{[{()}]([)]{()}}\n").include("false").exclude("true");
        run("{[{()}][()]{()}}}\n").include("false").exclude("true");
    }

    private Map<Long, String> mapC1(String line) {
        Map<Long, String> map = new TreeMap<>();
        line = line.replace("{", "").replace("}", "");
        String[] array = line.split(",\\s*");
        for (String s : array) {
            String[] lr = s.split("=");
            long key = Long.parseLong(lr[0]);
            String value = lr.length == 2 ? lr[1] : "";
            map.put(key, value);
        }
        return map;
    }

}

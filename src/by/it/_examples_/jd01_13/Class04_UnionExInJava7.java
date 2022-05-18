package by.it._examples_.jd01_13;

@SuppressWarnings("all") //demo, too many warnings
public class Class04_UnionExInJava7 {

    private static final String CLASS_TO_LOAD = "main.java.Helper";
    public static void main(String[] args) {
            try {
                Class loadedClass = Class.forName(CLASS_TO_LOAD);
	            System.out.println("Grade " + loadedClass + " found successfully!");
                loadedClass.newInstance();

            }
                catch(NumberFormatException | ClassNotFoundException |
                        IllegalAccessException | InstantiationException e) {
                     e.printStackTrace();
            }

    }
}

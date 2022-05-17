package by.it.kameisha.jd01_12;

import java.util.Arrays;
import java.util.List;

public class TaskC2 {
    public static void main(String[] args) {
        List<Byte> byteList = Arrays.asList((byte)2,(byte)3,(byte)6,(byte)7,(byte)5,(byte)2,(byte)2,(byte)1,(byte)2);
        List<Long> longList =Arrays.asList(1L, 2L, 4L,56L,6L,4L,3L,22L,12L,1L);
        List<Float> floatList = Arrays.asList(4f,78f,3f,1.0f,45.2f,56.0f,2.0f);

        System.out.println(byteList);
        System.out.println(longList);
        System.out.println(floatList);
    }
}

package by.it.avramchuk.jd01_12;

import java.util.*;

public class TaskC2 implements Comparator<Number>{

    public static void main(String[] args) {

        List<Integer> first = Arrays.asList(1,1,2,2,3,4,5,5,6);
        List<Double> second = Arrays.asList(9.0,99.0,8.0,7.0,7.0,5.0,6.0,4.0);


        Set<Integer> one = new HashSet<>(first);
        Set<Double> two = new TreeSet<>(second);


        System.out.println("One" + one);
        System.out.println("Two" + two);


        Set<? extends Number> union = getUnion(one, two);
        System.out.println("union: "+union);



    }

    private  static Set<? extends Number> getUnion(Set<? extends Number>... args){
        int count = args.length;
        Set<Number> result = new HashSet<>(args[0]);
        TaskC2 task = new TaskC2();
        for (Number number : args[0]) {
            Iterator<? extends Number> iterator = args[1].iterator();
            for (int i = 1; i<= args[1].size(); i++){
                Number num = iterator.next();
                if (task.compare(number, num )!=0){
                    result.add(num);
                }
            }

        }
        return result;
    }
    private  static Set<? extends Number> getCross(Set<? extends Number>... args){
        Set<Number> result = new HashSet<>(args[0]);
        result.retainAll(args[1]);
        return result;
    }


    @Override
    public int compare(Number o1, Number o2) {
        if (o1.longValue()==o2.longValue()&& o1.doubleValue()== o2.doubleValue()){
            return 0;
        } else return -1;
    }
}

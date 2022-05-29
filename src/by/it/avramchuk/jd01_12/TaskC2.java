package by.it.avramchuk.jd01_12;

import java.util.*;

public class TaskC2 {

    public static void main(String[] args) {

        List<Integer> first = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 5, 6);
        List<Double> second = Arrays.asList(9.0, 99.0, 8.0, 7.0, 7.0, 5.0, 6.0, 4.0);


        Set<Integer> one = new HashSet<>(first);
        Set<Double> two = new TreeSet<>(second);


        System.out.println("One" + one);
        System.out.println("Two" + two);


    }

    @SafeVarargs
    private static Set<Number> getUnion(Set<Number>... args) {
       Set <Number> result = new HashSet<>(args[0]);
       if (args.length>1){
           for(int i=1; i<args.length;i++){
               Set<Number> nextSet = new HashSet<>(args[i]);
               for (Number el : nextSet) {
                   int counter=0;
                   for (Number leftSetValue : result) {
                       if (!(el.longValue() == leftSetValue.longValue() &&
                               el.doubleValue() == leftSetValue.doubleValue())) {
                           counter++;
                       }
                   }
                   if (counter==result.size()){
                       result.add(el);
                   }
               }
           }
       }
        return result;
    }

    private static Set<Number> getCross(Set<Number>... args) {
       Set<Number> result = new HashSet<>();
       Set<Number> leftSet = new HashSet<>(args[0]);
       if(args.length>1){
           Set<Number> secondSet = new HashSet<>(args[1]);
           for (Number el : secondSet) {
               Iterator<Number> itr = leftSet.iterator();
               while (itr.hasNext()){
                   Number secondValue = itr.next();
                   if (el.longValue()== secondValue.longValue() &&
                           el.doubleValue()== secondValue.doubleValue()){
                       result.add(el);
                       break;
                   }
               }
           }
           if (args.length>2) {
               for (int i = 1; i < args.length; i++) {
                   Set<Number> nextSet = new HashSet<>(args[i]);
                   for (Number el : nextSet) {
                       Iterator<Number> itr = result.iterator();
                       while (itr.hasNext()) {
                           Number leftSetValue = itr.next();
                           if (el.longValue() == leftSetValue.longValue() &&
                                   el.doubleValue() == leftSetValue.doubleValue()) {
                               result.add(el);
                               break;
                           }
                       }
                   }
               }
           }
       } else {return leftSet;}
        return result;
    }
}




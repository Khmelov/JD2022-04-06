package by.it.kudelko.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        StringBuffer str1 = new StringBuffer(strVector);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            int startPosition = matcher.start();
            int lastPosition = str1.length()-1;
            str1.setCharAt(startPosition, ' ');
            str1.setCharAt(lastPosition, ' ');
        }
        String str2 = str1.toString();
            str2 = str2.trim();
            String strArr[] = str2.split(",");
            double numArr[] = new double[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                numArr[i] = Double.parseDouble(strArr[i]);
                this.value = numArr;
            }
        }

        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder("{");
            String delimeter = "";
            for (double element : value) {
                sb.append(delimeter).append(element);
                delimeter = ", ";
            }
            sb.append("}");
            return sb.toString();
        }
    }

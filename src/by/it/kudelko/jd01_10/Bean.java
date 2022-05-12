package by.it.kudelko.jd01_10;

class Bean {
    static int a = 1;
    static int b = 2;

    public double sum(int a, int b) {
        double sum = a + b;
        return sum;
    }

    @Param(a = 3, b = 4)
    static double max(int a, int b) {
        double maximum = 0;
        if (a > b) {
            maximum = a;
        }
        if (a < b) {
            maximum = b;
        }
        return maximum;
    }

    @Param(a = 2, b = 5)
    static double min(int a, int b) {
        double minimum = 0;
        if (a > b) {
            minimum = b;
        }
        if (a < b) {
            minimum = a;
        }
        return minimum;
    }

    @Param(a = 6, b = 3)
    double avg(int a, int b) {
        double average = 0;
        average = (a + b) / 2d;
        return average;
    }
}


package by.it.edeborg.jd02_03.organization;

public class SomethingGood {

        private final String name;

        public SomethingGood(String name) {
            this.name = name;
        }

        public SomethingGood(SomethingGood good) {
            this.name = good.name;
        }

        @Override
        public String toString() {
            return name;
        }
    }



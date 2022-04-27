package by.it._examples_.jd01_07.abstractdemo;

class Input extends Component {

    public Input(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    void show() {
        System.out.println("Input" + getCoordinateString());
    }
}

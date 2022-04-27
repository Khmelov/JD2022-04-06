package by.it._examples_.jd01_07.abstractdemo;

class Button extends Component {

    public Button(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    void show() {
        System.out.println("Button " + getCoordinateString());
    }
}
package by.it._examples_.jd01_07.interfacedemo;

class ToolPanel implements Clickable {
    @Override
    public void doubleClick() {
        System.out.println("ToolPanel double click");
    }
}
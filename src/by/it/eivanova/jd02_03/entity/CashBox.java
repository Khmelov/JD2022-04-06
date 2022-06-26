package by.it.eivanova.jd02_03.entity;

public enum CashBox {
    CashBox1, CashBox2, CashBox3, CashBox4, CashBox5;
    private double totalCash=0;
    public void addSum(double sum){
        totalCash+=sum;
    }
    public double getTotalCash(){
        return totalCash;
    }
}

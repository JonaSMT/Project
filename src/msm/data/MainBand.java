package msm.data;

public class MainBand extends Band{
    public MainBand() {
    }

    public MainBand(int numberRehearsal, int numberPerformance, int amountPay, int totalPay) {
        super(numberRehearsal, numberPerformance, amountPay, totalPay);
        type = "MainBand";
    }

    public String toString() {
        return "Rehearsal:" + numberRehearsal + ":" + "Performance:" + numberPerformance + ":" + "Amount:"+
                amountPay + ":" + "Total:" + totalPay + ":" + "(" + "Main Band" + ")";
    }
}

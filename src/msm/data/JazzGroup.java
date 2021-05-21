package msm.data;

public class JazzGroup extends Band{
    public JazzGroup(int numberRehearsal, int numberPerformance, int amountPay, int totalPay) {
        super(numberRehearsal, numberPerformance, amountPay, totalPay);
    }

    public JazzGroup() {

    }

    public String toString() {
        return "Rehearsal:" + numberRehearsal + ":" + "Performance:" + numberPerformance + ":" + "Amount:"+
                amountPay + ":" + "Total:" + totalPay + ":" + "(" + "Jazz Group" + ")";
    }
}

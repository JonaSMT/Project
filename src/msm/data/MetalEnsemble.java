package msm.data;

public class MetalEnsemble extends Band{
    public MetalEnsemble(int numberRehearsal, int numberPerformance, int amountPay, int totalPay) {
        super(numberRehearsal, numberPerformance, amountPay, totalPay);
    }

    public MetalEnsemble() {

    }

    public String toString() {
        return "Rehearsal:" + numberRehearsal + ":" + "Performance:" + numberPerformance + ":" + "Amount:"+
                amountPay + ":" + "Total:" + totalPay + ":" + "(" + "Metal Ensemble" + ")";
    }
}

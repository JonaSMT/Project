package msm.data;

public class PercussionEnsemble extends Band{
    public PercussionEnsemble(int numberRehearsal, int numberPerformance, int amountPay, int totalPay) {
        super(numberRehearsal, numberPerformance, amountPay, totalPay);
    }

    public PercussionEnsemble() {

    }

    public String toString() {
        return "Rehearsal:" + numberRehearsal + ":" + "Performance:" + numberPerformance + ":" + "Amount:"+
                amountPay + ":" + "Total:" + totalPay + ":" + "(" + "Percussion Ensemble" + ")";
    }
}

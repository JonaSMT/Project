package msm.data;

/**
 * This class create a Clarinet Ensemble object
 */
public class ClarinetsEnsemble extends Band{
    /**
     * This constructor create a Clatinet Ensemble object with parent properties
     * @param numberRehearsal quantity rehearsal
     * @param numberPerformance quantity performance
     * @param amountPay quantity amount to pay
     * @param totalPay total to pay
     */
    public ClarinetsEnsemble(int numberRehearsal, int numberPerformance, int amountPay, int totalPay) {
        super(numberRehearsal, numberPerformance, amountPay, totalPay);
    }

    /**
     * This is a empty constructor
     */
    public ClarinetsEnsemble() {

    }

    /**
     * This method create a format to write in text, including a type of instrument
     * @return string with format
     */
    public String toString() {
        return "Rehearsal:" + numberRehearsal + ":" + "Performance:" + numberPerformance + ":" + "Amount:"+
                amountPay + ":" + "Total:" + totalPay + ":" + "(" + "Clarinets Ensemble" + ")";
    }
}

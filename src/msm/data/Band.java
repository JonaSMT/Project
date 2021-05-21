package msm.data;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create Band objects
 */
public abstract class Band{
    int numberRehearsal;
    int numberPerformance;
    int amountPay;
    int totalPay;
    String type;

    /**
     * This constructor are empty
     */
    public Band() {
    }

    /**
     * This constructor create Band objects with rehearsal, performance, amount pay and total pay
     * @param numberRehearsal a rehearsal number
     * @param numberPerformance a performance number
     * @param amountPay a amount pay
     * @param totalPay a total pay
     */
    public Band(int numberRehearsal, int numberPerformance, int amountPay, int totalPay) {
        this.numberRehearsal = numberRehearsal;
        this.numberPerformance = numberPerformance;
        this.amountPay = amountPay;
        this.totalPay = totalPay;
    }

    /**
     * Obtain a type of band
     * @return band type
     */
    public String getType() {
        return type;
    }

    /**
     * Establish a type of band
     * @param type band type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtain a rehearsal quantity
     * @return rehearsal quantity
     */
    public int getNumberRehearsal() {
        return numberRehearsal;
    }

    /**
     * Establish a rehearsal quantity
     * @param numberRehearsal rehearsal quantity
     */
    public void setNumberRehearsal(int numberRehearsal) {
        this.numberRehearsal = numberRehearsal;
    }

    /**
     * Obtain a performance quantity
     * @return performance quantity
     */
    public int getNumberPerformance() {
        return numberPerformance;
    }

    /**
     * Establish a performance quantity
     * @param numberPerformance performance quantity
     */
    public void setNumberPerformance(int numberPerformance) {
        this.numberPerformance = numberPerformance;
    }

    /**
     * Obtain a amount pay
     * @return quantity of amount pay
     */
    public int getAmountPay() {
        return amountPay;
    }

    /**
     * Establish a quantity of a amount pay
     * @param amountPay quantity of amount pay
     */
    public void setAmountPay(int amountPay) {
        this.amountPay = amountPay;
    }

    /**
     * Obtain a total pay
     * @return quantity of total pay
     */
    public int getTotalPay() {
        return totalPay;
    }

    /**
     * Establish a quantity of a total pay
     * @param totalPay quantity of total pay
     */
    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }
}

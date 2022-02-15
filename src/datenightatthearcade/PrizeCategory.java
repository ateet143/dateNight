package datenightatthearcade;

public class PrizeCategory {

    private String[] prizes;
    private int[] remainingPrizes;

    //Setting up the default data in the array when the object is created.
    public PrizeCategory() {
        this.prizes = new String[]{"Candy", "Hat", "Glasses"};
        this.remainingPrizes = new int[]{100, 100, 100};
    }

    public String[] getPrizes() {
        return prizes;
    }

    public int[] getRemainingPrizes() {
        return remainingPrizes;
    }
}

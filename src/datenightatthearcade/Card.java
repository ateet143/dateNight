package datenightatthearcade;

public class Card {

    private int creditBalance;
    private int ticketBalance;
    private final int id;
    private static int counter;

    public Card() {
        counter++;
        this.id = counter;
    }

    public int getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(int creditBalance) {
        this.creditBalance = creditBalance;
    }

    public int getTicketBalance() {
        return ticketBalance;
    }

    public void setTicketBalance(int ticketBalance) {
        this.ticketBalance = ticketBalance;
    }

    public int getId() {
        return id;
    }

}

package datenightatthearcade;

import java.util.Random;

public class Game {

    private final int creditPerPlay;

    public int getCreditPerPlay() {
        return creditPerPlay;
    }

    public Game(int creditPerPlay) {
        this.creditPerPlay = creditPerPlay;
    }

    public void play(Card card) {
        System.out.println("\n#Card Swiped to Play#");
        if (card.getCreditBalance() < this.creditPerPlay) {
            System.out.println("!Card " + card.getId() + " has Not enough credit to play...");
        } else {
            System.out.println("### GAME" + " FOR CARD " + card.getId() + " STARTING ###");
            decreaseCredit(card, this.creditPerPlay);
            int winTicket = awardTicket(card);
            System.out.println("No of tickets won:" + winTicket);
            System.out.println("Total number of Ticket:" + card.getTicketBalance());
        }
    }
    //method to decrease the credit in each play

    public void decreaseCredit(Card card, int credit) {
        int tempCredit = card.getCreditBalance() - credit;
        card.setCreditBalance(tempCredit);
        System.out.println("No of Credit deducted:" + credit);
        System.out.println("No of Credit Remained:" + card.getCreditBalance());

    }

    //method generating random number represent the ticket won
    public int awardTicket(Card card) {
        Random random = new Random();
        int winTicket = random.nextInt(100) + 1;
        int newTicket = card.getTicketBalance() + winTicket;
        card.setTicketBalance(newTicket);
        return winTicket;
    }

}

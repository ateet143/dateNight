package datenightatthearcade;

public class Terminal {

    // has a relationship 
    private PrizeCategory prize;
    private final int firstPrizeLimit = 10;
    private final int secondPrizeLimit = 20;
    private final int thirdPrizeLimit = 30;

    // Creating default constructor with creating object for PrizeCategory
    public Terminal() {
        prize = new PrizeCategory();
    }

    //Method to display balances when swiping the card to the terminal
    public void checkBalance(Card card) {
        System.out.println("\n### CARD " + card.getId() + " BALANCE ###");
        System.out.println("Total Credit balance: " + card.getCreditBalance());
        System.out.println("Total ticket balance: " + card.getTicketBalance());
    }

    //method to add credits to the card
    public boolean addCredits(double amount, Card card) {
        if (amount <= 0) {
            return false;
        }
        int temp = card.getCreditBalance() + (int) amount * 2;
        card.setCreditBalance(temp);
        return true;
    }

    //method to transfer credit between card1 and card2.
    public boolean transferCredits(Card card1, Card card2) {
        if (card1.getCreditBalance() <= 0) {
            return false;
        }
        int card2NewCredit = card2.getCreditBalance() + card1.getCreditBalance(); // to add the balance to the previous balance
        card2.setCreditBalance(card2NewCredit);
        card1.setCreditBalance(0); //whole credit from card1 is transfered to card2 thats why card1 should be zero
        return true;
    }

    public boolean transferTicket(Card card1, Card card2) {
        if (card1.getTicketBalance() <= 0) {
            return false;
        }
        int card2NewTicket = card2.getTicketBalance() + card1.getTicketBalance();
        card2.setTicketBalance(card2NewTicket);
        card1.setTicketBalance(0);
        return true;
    }

    public boolean requestPrize(String prize, Card card) {
        System.out.println(String.format("\n### Requesting '%s' for Card %d ###", prize, card.getId())); // just to add spaces between the lines
        String[] prizes = this.getPrize().getPrizes();
        int[] remainingPrizes = this.getPrize().getRemainingPrizes();
        int index = this.findPrize(prizes, prize);
        if (index < 0) {
            System.out.println("Cannot find the prize");
            return false;
        }
        switch (index) {
            case 0:
                return prizeCalculation(remainingPrizes, prizes, card, index, firstPrizeLimit);
            //call the method prizeCalculatiion, it will execute the method and also return boolean,and return will break out from the method so no break statement needed.

            case 1:
                return prizeCalculation(remainingPrizes, prizes, card, index, secondPrizeLimit);

            case 2:
                return prizeCalculation(remainingPrizes, prizes, card, index, thirdPrizeLimit);
        }
        return true;
    }

    public boolean prizeCalculation(int[] remainingPrizes, String[] prizes, Card card, int index, int prizelimit) {
        if (remainingPrizes[index] < 1) {
            System.out.println("No more prize number available");
            return false;
        }
        if (card.getCreditBalance() < prizelimit) {
            System.out.println("insufficient credit");
            return false;
        }
        int wonPrizeNumber = card.getTicketBalance() / prizelimit;
        if (wonPrizeNumber == 0) {
            System.out.println("!Try again, insuficient Ticket to claim" + " " + prizes[index]);
            return false;
        }
        System.out.println("!Congratulation you won " + wonPrizeNumber + " " + prizes[index]);
        remainingPrizes[index] -= wonPrizeNumber;
        int newTicket2 = card.getTicketBalance() - (wonPrizeNumber * prizelimit);
        card.setTicketBalance(newTicket2);
        return true;
    }

    //method to find the index of the prize in the array and return
    public int findPrize(String[] prizes, String prize) {
        for (int i = 0; i < prizes.length; i++) {
            if (prizes[i].toUpperCase().equals(prize.toUpperCase())) {
                return i;
            }
        }
        return -1;
    }

    public PrizeCategory getPrize() {
        return prize;
    }

    //method to display the remaining number of prizes
    public void checkPrizeCount() {
        System.out.println("\n### Total Remaining Prizes ###");
        System.out.println("Remaining " + this.getPrize().getPrizes()[0] + ":" + this.getPrize().getRemainingPrizes()[0]);
        System.out.println("Remaining " + this.getPrize().getPrizes()[1] + ":" + this.getPrize().getRemainingPrizes()[1]);
        System.out.println("Remaining " + this.getPrize().getPrizes()[2] + ":" + this.getPrize().getRemainingPrizes()[2]);
    }

}

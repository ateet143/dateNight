package datenightatthearcade;

public class DateNightAtTheArcade {

    public static void main(String[] args) {
        System.out.println("#WELCOME TO THE DATE NIGHT AT THE ARCADE#");
        Card card1 = new Card();
        Card card2 = new Card();
        Terminal t1 = new Terminal();
        Game g1 = new Game(5);

        t1.addCredits(20, card1);
        t1.checkBalance(card1);

        g1.play(card1);
        t1.checkBalance(card1);
        boolean transfer = t1.transferCredits(card1, card2);
        if (transfer) {
            System.out.println("\n#Sucessfully transfer the Credit.#");
        } else {
            System.out.println("\n#Credit not transfered#");
        }
        transfer = t1.transferTicket(card1, card2);
        if (transfer) {
            System.out.println("\n#Sucessfully transfer the Ticket.#");
        } else {
            System.out.println("\n#Ticket not transfered#");
        }

        t1.checkBalance(card1);
        t1.checkBalance(card2);

        g1.play(card1);

        t1.requestPrize("Candy", card2);
        t1.requestPrize("Hat", card2);
        t1.requestPrize("Glasses", card2);

        t1.checkPrizeCount();
        t1.checkBalance(card2);
    }

}

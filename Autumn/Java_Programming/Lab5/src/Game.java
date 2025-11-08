public class Game {
    public static final int WINNING_SCORE = 21;
    public static enum Command {HOLD, DRAW};

    public Game() {}

    public void play() {
        Player player = getPlayer();

        player.addCard(Util.getRandom(11));
        player.addCard(Util.getRandom(11));

        Command c;
        while (!player.isHeld()) {
            Util.out(player);
            c = getCommand();

            switch (c) {
                case DRAW: player.addCard(Util.getRandom(11)); break;
                case HOLD: player.setHold(true); break;
                default: Util.out("Unknown Command: " + c);
            }
        }

        if(player.getScore() == Game.WINNING_SCORE) {
            Util.out(player);
            Util.out(player.getName() + " won");
        } else if (player.getScore() > Game.WINNING_SCORE) {
            Util.out(player);
            Util.out(player.getName() + " lost");
        } else {
            Util.out(player);
            Util.out(player.getName() + " drew");
        }
    }

    private Command getCommand() {
        String s = Util.getInput("Would you like to DRAW another card, or HOLD your current score?");
        if (s.equalsIgnoreCase("draw")) {
            return Command.DRAW;
        } else if (s.equalsIgnoreCase("hold")) {
            return Command.HOLD;
        } else {
            throw new IllegalArgumentException("Invalid Command Entered: "  + s);
        }
    }

    private Player getPlayer() {
        return new Player(Util.getInput("Please enter your name: "));
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}

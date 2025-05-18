import java.util.Random;

public class ScissorPaperRock {
    // `{}` are used for array initialization with specific values
    private final String[] computerChoices = {"Scissor", "Paper", "Rock"};

    private String computerChoice;

    private int computerScore, playerScore;
    
    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    private Random randomValue;

    public ScissorPaperRock() {
        randomValue = new Random();
        
    }

    public String play(String playerChoice) {
        computerChoice = computerChoices[randomValue.nextInt(computerChoices.length)];
        String result;

        if (computerChoice.equals("Scissor")) {
            if (playerChoice.equals("Scissor")) {
                result = "Draw";
            } else if (playerChoice.equals("Paper")) {
                result = "Computer Win";
                computerScore++;
            } else {
                result = "Player Win";
                playerScore++;
            }
        } else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissor")) {
                result = "Player Win";
                playerScore++;
            } else if (playerChoice.equals("Paper")) {
                result = "Draw";
            } else {
                result = "Computer Win";
                computerScore++;
            }
        } else if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Scissor")) {
                result = "Computer Win";
                computerScore++;
            } else if (playerChoice.equals("Paper")) {
                result = "Player Win";
                playerScore++;
            } else {
                result = "Draw";
            }
        } else {
            result = "invalid choice";
        }
        return result;
    }

    // Advanced method to write the logic
    // public String determineWinner(String playerChoice, String computerChoice) {
    //     Map<String, String> winningMoves = new HashMap<>();
    //     winningMoves.put("Scissor", "Paper");
    //     winningMoves.put("Paper", "Rock");
    //     winningMoves.put("Rock", "Scissor");

    //     if (playerChoice.equals(computerChoice)) {
    //         return "Draw";
    //     } else if (winningMoves.containsKey(playerChoice) && winningMoves.get(playerChoice).equals(computerChoice)) {
             // if playerChoice is "Scissor", winningMoves.get("Scissor") will return "Paper".
    //         playerScore++;
    //         return "Player Win";
    //     } else {
    //         computerScore++;
    //         return "Computer Win";
    //     }
    // }

}

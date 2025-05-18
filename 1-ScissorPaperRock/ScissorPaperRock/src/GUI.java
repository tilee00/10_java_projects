import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
    JButton scissorButton, paperButton, rockButton;

    JLabel computerChoice, computerScoreLabel, playerScoreLabel;

    ScissorPaperRock scissorPaperRock;

    public GUI() {
        super("scissor paper rock");

        setSize(500, 500);

        // when layout is null, then enable absolute positioning
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // centers the frame on the entire screen
        setLocationRelativeTo(null);

        scissorPaperRock = new ScissorPaperRock();

        addComponent();
    }

    private void addComponent() {
        computerScoreLabel = new JLabel("computer score: 0");
        computerScoreLabel.setBounds(10, 20, 200, 50);
        computerScoreLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(computerScoreLabel);

        computerChoice = new JLabel("?");
        computerChoice.setBounds(200, 100, 100, 80);
        computerChoice.setFont(new Font("Verdana", Font.PLAIN, 20));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);                                                                                                                                                                                              
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        playerScoreLabel = new JLabel("player score: 0");
        playerScoreLabel.setBounds(10, 210, 200, 50);
        playerScoreLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(playerScoreLabel);

        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(50, 300, 100, 80);
        scissorButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        scissorButton.addActionListener(this);
        add(scissorButton);

        paperButton = new JButton("Paper");
        paperButton.setBounds(195, 300, 100, 80);
        paperButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        paperButton.addActionListener(this);
        add(paperButton);
        
        rockButton = new JButton("Rock");
        rockButton.setBounds(340, 300, 100, 80);
        rockButton.setFont(new Font("Verdana", Font.PLAIN, 15));
        rockButton.addActionListener(this);
        add(rockButton);
    }

    private void showDialog(String message) {
        JDialog dialog = new JDialog(this, "Game Result", true);
        dialog.setSize(300, 300);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(messageLabel, BorderLayout.CENTER);

        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computerChoice.setText("?");

                dialog.dispose();
            }
        });
        dialog.add(tryAgainButton, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(this);

        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand();
        String result = scissorPaperRock.play(playerChoice);
        
        computerChoice.setText(scissorPaperRock.getComputerChoice());
        computerScoreLabel.setText("computer score: " + String.valueOf(scissorPaperRock.getComputerScore()));
        playerScoreLabel.setText("player score: " + String.valueOf(scissorPaperRock.getPlayerScore()));

        showDialog(result);
    }
}
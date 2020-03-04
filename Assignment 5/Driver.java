/**
 * Creates a GUI and runs a game of Higher Card between 1 computer and 1 human.
 * 
 * @author Martin Mueller
 * @version 05/08/2018
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class Driver extends Application {
    Card computerCard; //the current card the computer put on the play area
    int rounds = 5; //the number of rounds the game will last
    //create instance variables (explainations found by initializations)
    private HigherCardComputerPlayer computer;
    private HigherCardHumanPlayer player;
    private HBox computerScoreboard;
    private HigherCardGame game;
    private Text computerLastMove;
    private Text computerScore;
    private HBox computerHand;
    private HBox playArea;
    private HBox playerHand;
    private HBox playerScoreboard;
    private Text playerLastMove;
    private Text playerScore;
    private Text roundWinner;
    private Text winner;
    private Text instructions;
    private VBox pane;
    private Scene scene;
    //the main method runs the program when it's executed
    public static void main(String args[]) {
        launch(args);
    }
    //overrides the start method in the Application class
    //sets up the GUI
    @Override
    public void start(Stage stage) {
        //create a computer player and human player
        computer = new HigherCardComputerPlayer("Computer", rounds);
        player = new HigherCardHumanPlayer("Player", rounds);
        //create a new game of Higher Card
        HigherCardPlayer players[] = {computer, player};
        game = new HigherCardGame(players, rounds);
        //create an HBox that shows the computer's last move and score
        computerScoreboard = new HBox(50);
        computerScoreboard.setAlignment(Pos.CENTER);
        //create text for the scoreboard
        computerLastMove = new Text(70, 20, "Computer's Last Move: -");
        computerLastMove.setFill(Color.WHITE);
        computerScore = new Text(70, 20, "Computer's Score: 0");
        computerScore.setFill(Color.WHITE);
        //add the text to the scoreboard
        computerScoreboard.getChildren().addAll(computerLastMove, computerScore);
        //create an HBox for the computer's hand
        computerHand = new HBox(10);
        computerHand.setAlignment(Pos.CENTER);
        //add the computer's hand to the HBox
        for(int i=0; i<rounds; i++) {
            computerHand.getChildren().add(new ImageView(new Image("images\\0.png")));
        }
        //create an HBox for the play area
        playArea = setupPlayArea();
        //create an HBox for the human player's hand
        playerHand = setupPlayerHand();
        //create an HBox that shows the human player's last move and score
        playerScoreboard = new HBox(50);
        playerScoreboard.setAlignment(Pos.BOTTOM_CENTER);
        //create text for the new scoreboard
        playerLastMove = new Text(20, 20, "Your Last Move: -");
        playerLastMove.setFill(Color.WHITE);
        playerScore = new Text(20, 20, "Your Score: 0");
        playerScore.setFill(Color.WHITE);
        //add the text to the scoreboard
        playerScoreboard.getChildren().addAll(playerLastMove, playerScore);
        //displays the round winner after every round
        roundWinner = new Text("Round Winner: -");
        //displays the winner after the game ends
        winner = new Text("Winner: -");
        //shows a basic set of instrctions
        instructions = new Text("Instructions: Simply click on the card you wish to play. The computer's next choice will appear in the middle.");
        //create a VBox to store all of the HBoxes in
        pane = new VBox();
        pane.setSpacing(20);
        pane.getChildren().addAll(computerScoreboard, computerHand, playArea, playerHand, playerScoreboard, roundWinner, winner, instructions);
        //create a scene and put it in the stage
        scene = new Scene(pane, 600, 600, Color.GREEN);
        stage.setTitle("Assignment 5 (Higher Card)");
        stage.setScene(scene);
        stage.show();
        //start the game
    }
    //sets up the human player's hand
    private HBox setupPlayerHand() {
        //create an HBox to hold the cards
        HBox playerHand = new HBox(10);
        playerHand.setAlignment(Pos.CENTER);
        //place each card in the player's hand
        for(int i=0; i<rounds; i++) {
            Card card = player.getCards().get(i);
            String imagePath = "images\\";
            imagePath += card.getRank();
            imagePath += card.getSuit().name().substring(0,1).toLowerCase()+".png";
            ImageView iv = new ImageView(new Image(imagePath));
            iv.setOnMouseClicked(new MouseHandler(iv, card));
            playerHand.getChildren().add(iv);
        }
        //return the player's hand
        return playerHand;
    }
    //sets up the play area in the beginning of the game
    private HBox setupPlayArea() {
        //create the play area
        HBox playArea = new HBox(20);
        playArea.setAlignment(Pos.CENTER);
        //create a placeholder to keep the width constant
        playArea.getChildren().add(new Rectangle(71, 96, Color.GREEN));
        //return the play area
        return playArea;
    }
    //plays a card when a player clicks on it
    private class MouseHandler implements EventHandler<MouseEvent> {
        //store the image of the card and the Card object
        ImageView iv;
        Card card;
        //initialize instance variables
        public MouseHandler(ImageView iv, Card card) {
            this.iv = iv;
            this.card = card;
        }
        //executes when the mouse is clicked
        @Override
        public void handle(MouseEvent e){
            //resets the computer's hand
            if(rounds > 1) {
                computerHand.getChildren().setAll();
            }
            //reset the amount of cards the player has on the table
            for(int i=0; i<rounds-1; i++) {
                computerHand.getChildren().add(new ImageView(new Image("images\\0.png")));
            }
            //display the card played by the player
            playArea.getChildren().setAll(iv);
            //display the card played by the computer
            computerCard = computer.takeTurn();
            final String PATH = "images\\"+computerCard.getRank()+computerCard.getSuit().name().substring(0,1).toLowerCase()+".png";
            playArea.getChildren().add(new ImageView(new Image(PATH)));
            //resets the images in the player's hand and playArea
            if(rounds <= 1) {
                playerHand.getChildren().setAll(new Rectangle(71, 96));
            } else {
                playerHand.getChildren().remove(iv);
            }
            //updates the round winner field
            roundWinner.setText(game.getRoundWinner());
            //adds a pause for the screen clearing
            Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1000), ev -> {
                    resetCards();
                })
            );
            timeline.setCycleCount(1);
            timeline.play();
        }
        //resets the playing area for another trick and updates the scores/winners
        private void resetCards() {
            //resets the player's last card played and score text
            playerLastMove.setText("Your Last Move: "+card);
            player.getCards().remove(card);
            //updates the last card played by the computer
            computerLastMove.setText("Computer's Last Move: "+computerCard);
            //if there aren't any rounds left, put a placeholder in the computer's hand
            if(rounds <= 1) {
                computerHand.getChildren().setAll(new Rectangle(71, 96));
            }
            //put in a placeholder object in the center
            playArea.getChildren().setAll(new Rectangle(71, 96, Color.GREEN));
            //increment the number of rounds left
            rounds--;
            //update all the back end stuff
            game.play();
            //output the appropriate scores
            computerScore.setText("Computer's Score: "+computer.getRoundsWon());
            playerScore.setText("Your Score: "+player.getRoundsWon());
            //updates winner field
            winner.setText(game.getWinner());
        }
    }
}
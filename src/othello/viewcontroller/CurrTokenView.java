/*
 ** This code is provided solely for the personal and private use of
 ** students taking the CSC207H5 course at the University of Toronto.
 ** Copying for purposes other than this use is expressly prohibited.
 ** All forms of distribution of this code, whether as given or with
 ** any changes, are expressly prohitbited.
 **
 ** Authors: Arnold Rosenbloom, Gautam Gireesh, Arjun Ganguly, Parshva, Milind Vishnoi
 **
 ** All of the files in this directory and all subdirectories are:
 ** Copyright (c) 2019 Arnold Rosenbloom.
 */

package ca.utoronto.utm.othello.viewcontroller;
import ca.utoronto.utm.othello.model.Othello;
import ca.utoronto.utm.othello.model.OthelloBoard;
import ca.utoronto.utm.util.Observer;
import ca.utoronto.utm.util.Observable;
import javafx.animation.*;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * Observer class to update the current state of the game from Starting, In progress
 * to Complete depending on how the game proceeds.
 * The actual player tokens are placed.
 *
 *
 */
public class CurrTokenView implements Observer {

    Othello othello;
    HBox currPlayer;
    TextField currentState;

    public CurrTokenView(Othello othello, HBox currPlayer, TextField currentState) {
        this.othello = othello;
        this.currPlayer = currPlayer;
        this.currentState = currentState;
    }

    @Override
    public void update(Observable o) {

        if(!this.othello.isGameOver()) {
            this.currentState.setText("Game Status: Playing");
        }if(this.othello.isGameOver()) {
            this.currentState.setText("Game Status: Game Over");
        }

        Circle currentBlack = new Circle(10, 10, 10);
        currentBlack.setStyle("-fx-fill: BLACK");
        Circle currentWhite = new Circle(10, 10, 10);
        currentWhite.setStyle("-fx-fill: WHITE");
        this.currPlayer.getChildren().remove(0);
        if(this.othello.getWhosTurn() == OthelloBoard.P1) {
            this.currPlayer.getChildren().add(currentBlack);
        } else {
            this.currPlayer.getChildren().add(currentWhite);
        }
    }
    public void updateOthello(Othello othello) {
        this.othello = othello;
        this.update(this.othello);
    }
}

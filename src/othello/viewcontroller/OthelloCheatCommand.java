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
import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 * This class contains the command implementation of Cheater mode
 */
public class OthelloCheatCommand implements OthelloCommand {
    Othello othello;
    ArrayList<Button> buttons;
    public OthelloCheatCommand(Othello othello, ArrayList<Button> buttons) {
        this.othello = othello;
        this.buttons = buttons;
    }

    /**
     * Execution function for the cheater mode
     * @throws Exception
     */
    @Override
    public void execute() throws Exception {
        if(!OthelloApplication.cheat) {
            HintEventHandler cheaterMode = new HintEventHandler(this.othello, this.buttons);
            cheaterMode.getGreedy();
            OthelloApplication.cheat = true;
        } else{
            OthelloApplication.cheat = false;
            HintEventHandler cheaterMode = new HintEventHandler(this.othello, this.buttons);
            cheaterMode.getGreedy();
            int resetCol = cheaterMode.col;
            int resetRow = cheaterMode.row;
            int index = resetCol * 8 + resetRow;
            this.buttons.get(index).setStyle("-fx-background-color:  #00cc99");


        }
    }
}

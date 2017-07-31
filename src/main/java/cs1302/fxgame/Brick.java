package cs1302.fxgame;

import com.michaelcotterell.game.Game;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

public class Brick {

    Rectangle[] brickLayout = new Rectangle[30];
    int brickX = 35, brickY = 60;

    /**
     *The constructor for the Bricks for the Brick Break game. Initializes an array of Rectangles that will hold the bricks
     *
     */
    public Brick() {
	
	for(int i = 0; i < brickLayout.length; i++){
	    
	    if(i % 6 == 0 && i != 0) {
		brickY += 15;
		brickX = 35;
	    }
	    
	    brickLayout[i] = new Rectangle(brickX, brickY, 70, 10);
	    brickLayout[i].setFill(Color.GREEN);
	    
	    brickX += 75;
	    if(i % 30 == 0 && i != 0) {
		brickX = 35;
		brickY = 60;
	    }
	}


    }

    /**
     * Returns the brick state for the brick passed to it. 
     *
     *@param brick, the brick that collided with the ball
     *@return int, the health representation of the brick
     */
    public int  getBrickState(Rectangle brick) {
	int HP = 3;
	if(brick.getFill() == Color.GREEN) HP = 3;
	else if (brick.getFill() == Color.YELLOW) HP = 2;
	else if (brick.getFill() == Color.RED) HP = 1;
	return HP;
    }



}
package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;

public class BrickBreak extends Game {

    //an enumeration for the game mode
    private enum gameMode {START, PLAY, WIN, LOSS}
    gameMode mode = gameMode.START;

    boolean newLevel = true;
    double ballSpeed = 2.0;
    int score = 0, lives = 3, bricksBroken = 0, level = 1;
    double xDirection, yDirection;
    int x = 30;

    Text startText = new Text(){{
	setFill(Color.WHITE);
	setX(180);
	setY(220);
    }};
	   
    Text scoreBoard = new Text(){{
	setFill(Color.RED);
	setX(450);
	setY(10);
	setText("Score: " + score + "\nLives: " + lives);
    }};

    Text winMessage = new Text(){{
	setText("Congratulations! You have Won this level! \n Press Space to start the next level.");
	setX(200);
	setY(220);
    }};
    Text loseMessage = new Text(){{
	setText("Sorry, you lose. Your score was: " + score + "\nPress Enter to play again");
	setX(180);
	setY(220);
	setFill(Color.WHITE);
    }};
    Rectangle topWall = new Rectangle(0,0,520,1);
    Rectangle bottomWall = new Rectangle(0,460,520,1);
    Rectangle rightWall = new Rectangle(520,0,1,460);
    Rectangle leftWall = new Rectangle(0,0,1,460);

    Rectangle background = new Rectangle(0,0,520,460){{
	setFill(Color.BLACK);
    }};

    Rectangle paddle = new Rectangle(225,400,90,15){{
	setFill(Color.CORAL);
    }};
    
    Circle ball = new Circle(260,300,5){{
	setFill(Color.WHITE);
    }};

    Brick bricks;
    
    /**Constucts a new instance of the game
     *
     * @param stage, the main stage
     */
    public BrickBreak(Stage stage) {
	super(stage, "Epic Breakout!", 60, 520,460);
    }

    /** Moves the ball by changing the center X and Y properties
     *
     *
     */
    public void moveBall() {
	ball.setCenterX(ball.getCenterX() + (xDirection * ballSpeed));
	ball.setCenterY(ball.getCenterY() + (yDirection * ballSpeed));
    }

    /** Checks for Collisions for the ball and handles the action
     *
     *
     */
    public void checkForCollision() {

	for(int i = 0; i < bricks.brickLayout.length; i++){
	    if(bricks.brickLayout[i] != null){
		if(ball.intersects(bricks.brickLayout[i].getBoundsInLocal())){
		    switch(bricks.getBrickState(bricks.brickLayout[i])){
		    case 3: 
			bricks.brickLayout[i].setFill(Color.YELLOW);
			break;
		    case 2:
			bricks.brickLayout[i].setFill(Color.RED);
			break;
		    case 1: 
			try{
			    bricks.brickLayout[i] = null;
			}catch (Exception e){}
			bricksBroken++;
			score++;
			checkWin();
			break;
		    }//switch
		    yDirection = yDirection * -1;
		}//ball intersects
	    }//brickLayout[i] != null
	}//for 
	if(ball.intersects(rightWall.getBoundsInLocal()) || ball.intersects(leftWall.getBoundsInLocal())){
		    xDirection = xDirection * -1;
	    }
	if(ball.intersects(topWall.getBoundsInLocal())){
	    yDirection = yDirection * -1;
	}
	
	if(ball.intersects(bottomWall.getBoundsInLocal())){
	    lifeLoss();
	}
	if(ball.intersects(paddle.getBoundsInLocal())){
	    if(ball.getCenterX() < (paddle.getX() + paddle.getWidth()/2)){ //left side of the paddle
		if(xDirection > 0){
		    xDirection = xDirection * -1;
		}
	    }
	    else{ //right side of the paddle
		if(xDirection < 0){
		    xDirection = xDirection * -1;
		}
	    }
	    yDirection = yDirection * -1;
	}
    }//checkForCollision

    /**
     *Handles the user losing a life and performs the necessary actions for the game
     * to continue on
     */
    public void lifeLoss() {
	lives -= 1;
	if(lives >= 0){
	    ball.setCenterX(260);
	    ball.setCenterY(300);
	    paddle.setX(225);
	    xDirection = 1.0;
	    yDirection = 1.0;
	}
	else {
	    mode = gameMode.LOSS;
	}
    }//lifeLoss

    /**
     *Is the main update method. Depending on the stage in which the game is in, determines which stage of 
     *the game loop is in.
     *
     *@param game, the brick break game
     *@param gameTime, the Timeline of the game engine
     */
    @Override
    public void update(Game game, GameTime gameTime) {
	switch (mode) {
	case START: 
	    updateStart(game, gameTime);
	    break;
	case PLAY:
	    updatePlay(game,gameTime);
	    break;
	case WIN:
	    updateWin(game, gameTime);
	    break;
	case LOSS:
	    updateLoss(game, gameTime);
	    break;
	    
	}
	
    }

    /** The game mode for winning the game, displays the winning messaged.
     *
     *@param Game game, the brick breaker game
     *@param GameTime gameTime, the timeline for the game
     */
    public void updateWin(Game game, GameTime gameTime) {
	getSceneNodes().getChildren().setAll(winMessage, background);
	if(game.getKeyManager().isKeyPressed(KeyCode.SPACE)){
	    mode = gameMode.PLAY;
	}
    }

    /**
     *Checks to see if the user has won the game and sets the stage appropiately if that is the case
     */
    public void checkWin() {
	if(bricksBroken == 90 && level == 3){
	    mode = gameMode.WIN;
	}
	else if(bricksBroken % 30 == 0 && bricksBroken != 0){
	    level++;
	    ballSpeed += 1.0;
	    newLevel = true;
	    ball.setCenterX(260);
	    ball.setCenterY(300);
	}
    }
    /**
     *The update method for when the user loses. Allows the user to start a new game
     *or end it.
     *
     *@param Game, the brick break game
     *@param GameTime, the Timeline for the game engine
     */
    public void updateLoss(Game game, GameTime gameTime) {

	getSceneNodes().getChildren().setAll(background, loseMessage);
	
	if(game.getKeyManager().isKeyPressed(KeyCode.ENTER)){
	    mode = gameMode.START;
	}
	else{
	    stop();
	}
    }

    /**
     *The update method for the running of the game loop when it is in the play stage. Handles the logic for playing the game
     *@param Game, the brick break game
     *@param GameTime, the Timeline for the game engine
     */
    public void updatePlay(Game game, GameTime gameTime) {
	
	getSceneNodes().getChildren().setAll(background, paddle, ball, scoreBoard);
	if(newLevel){
	    bricks = new Brick();
	    newLevel = false;
	}
	try{
	    for(int i = x - 30; i < x; i++){
		if(bricks.brickLayout[i] != null){
		    getSceneNodes().getChildren().addAll(bricks.brickLayout[i]);
		}
	    }
	}catch(Exception e) {}

	//starts moving the ball
	if(gameTime.getTotalGameTime().getSeconds() <= 10 && game.getKeyManager().isKeyPressed(KeyCode.SPACE)){
	    ballSpeed = 2.0;
	    xDirection = 1.0;
	    yDirection = 1.0;
	    bricksBroken = 0;
	    
	}
	//moves the paddle to the right
	if(game.getKeyManager().isKeyPressed(KeyCode.RIGHT)){
	    paddle.setX(paddle.getX() + 4.5);
	    
	}
	//moves the paddle to the left
	if(game.getKeyManager().isKeyPressed(KeyCode.LEFT)){
	    paddle.setX(paddle.getX() - 4);
	}
	//allows the user to start a new game
	if(game.getKeyManager().isKeyPressed(KeyCode.ESCAPE)){
	    newLevel = true;
	    score = 0;
	    lives = 3;
	    mode = gameMode.START;
	    bricksBroken = 0;
	    level = 1;
	}
	scoreBoard.setText("Score: " + score + "\nLives: " + lives);
	checkForCollision();
	moveBall();
    }


    /**
     *The update method that handles the starting of a new game. Initializes everything in the game
     *@param Game, the brick break game
     *@param GameTime, the Timeline for the game engine
     */
    public void updateStart(Game game, GameTime gameTime) {

	getSceneNodes().getChildren().setAll(background, scoreBoard, startText);
	getSceneNodes().getChildren().addAll(rightWall, leftWall, topWall, bottomWall);
	if(game.getKeyManager().isKeyPressed(KeyCode.ENTER)){
	    mode = gameMode.PLAY;
	    score = 0;
	    lives = 3;
	    ball.setCenterX(260);
	    ball.setCenterY(300);
	    bricksBroken = 0;
	    level = 1;
	}

	if(gameTime.getTotalGameTime().getSeconds() % 2 == 1){
	    startText.setText("Press Enter to start a new game");
	}
	else {
	    startText.setText("");
	}
    }

}


# CSCI 1302 - FXGame (cs1302-fxgame)

This repository contains skeleton code for a project or assignment in Michael E. 
Cotterell's CSCI 1302 class at the University of Georgia. Please read the 
entirety of this file before beginning your project.

This project is due on Monday 2014-04-21 @ 11:55 PM.

## Academic Honesty

You implicitly agree to Academic Honesty policy as outlined in the course 
syllabus and course website (available at: http://cs.uga.edu/~mec/cs1302/).

In accordance with the notice above, I must caution you to **not** fork this
repository on GitHub if you have an account. Doing so will more than likely make
your copy of the project publicly visible. Please follow the instructions 
contained in the Resources section below in order to do your development on
<code>nike</code>.

## Assignment Description

Your goal is to develop one of a selection of games in Java powered by JavaFX. 
You will be responsible for designing and implementing the user interface for 
your project (following a few guidelines). 

The games you can choose from are the following:

 - [Tetris](http://en.wikipedia.org/wiki/Tetris)
 - [Breakout](http://en.wikipedia.org/wiki/Breakout_clone)

## Option 1 - Tetris

Tetriminos are game pieces shaped like tetrominoes, geometric shapes composed of
four square blocks each. A random sequence of Tetriminos fall down the playing 
field (a rectangular vertical shaft, called the "well" or "matrix"). The 
objective of the Tetris game is to manipulate these Tetriminos, by moving each 
one sideways and rotating it by 90 degree units, with the aim of creating a 
horizontal line of ten blocks without gaps. When such a line is created, it 
disappears, and any block above the deleted line will fall. Here are the seven 
one-sided Tetriminos in their Tetris Worlds colors. Top row, left to right: I,
 J, L, O. Bottom row: S, T, Z.

![Tetriminos](http://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Tetrominoes_IJLO_STZ_Worlds.svg/360px-Tetrominoes_IJLO_STZ_Worlds.svg.png "Tetriminos")

The game ends when blocks are stacked to the top of the "well" and there is is 
no room for a new Tetrimino to fall.

When a line is cleared the user earns 1 point. In general, when more than one 
line is cleared by a single Tetrimino, the user earns 2^(x-1) points where x 
is the number of lines cleared.

## Option 2 - Breakout

A Breakout game is a sub-class of the "bat-and-ball" game genre. The genre gets 
its name by the games being based around the dynamics of a player-controlled 
paddle which hits a ball towards a wall of blocks or similar objects, that the 
player chips away at with the ball as part of the main gameplay. In this version
of Breakout, the bricks will have three different states: untouched, broken,
and dead. When a brick is first placed on the screen, it will be in the
"untouched" state. The first time the ball hits the brick, it will go into the 
"broken" state. This state should be visually different from the "untouched"
state. The second time the ball hits the brick, it will go into the "dead"
state and should be removed from the screen. 

![Breakout](http://imgur.com/uZGP1DF.jpg "Breakout")

The game will start with a number of rows of bricks being displayed. The
game continues until either the player clears all the bricks (causes all them
to enter the "dead" state) and wins or the player misses the ball with
his or her paddle more than 3 times and loses.

Scoring is based on the number of bricks that have entered the "dead" state.
Every time a brick enters the "dead" state, the player earns 1 point.

## Project Tasks

This project is due on Monday 2014-04-21 @ 11:55 PM.
Before you submit your project, you need to perform the following tasks:

1. (20 points) Design your game's GUI interface. You can use 
   a mock-up tool such as [Creatively](http://creately.com/Online-UI-Mockups-and-Wireframes) 
   or [Pencil](http://pencil.evolus.vn/) (or similar) to make this 
   easier. You will include your mockups in a file called <code>MOCKUP.md</code> (a 
   blank version of this file is already created for you).
   Here is the point breakdown:
  * (8 points) Four mock-up images that show the game in different scenarios (e.g., 
    before game starts, durring game, game over, and one other).
  * (8 points) Include explanations for the design of each image.
  * (4 points) Provide a paragraph on how you think the design will differ from
    what you've described in your mock-ups. 
2. (60 points) Implement the GUI and the game logic. Here is the point breakdown:
  * (20 points) The UI looks similar to the mock-ups and is functional.
  * (20 points) The game keeps score as described by this README file.
  * (20 points) Game does not crash. If any errors occur, a dialog box or similar 
    should appear to indicates what the problem was.
3. (20 points) Document Everything. Here is the breakdown:
  * (10 points) Include Javadoc comments for every new class and method that you create.
  * (10 points) Include inline comments where appropriate to make your code clear.
4. Update the <code>README.md</code> in your project directory to contain the 
   following information at the top of the file (updating it with your own 
   information:

   ```markdown
   # Project Submission

   Author: YOUR NAME (LAST 3 DIGITS OF 810 NUMBER HERE)

   [If you did any of the exra credit then please indicate that here.]
   ```

## Resources

The files for this project are hosted Github using <code>git</code>. They can be
retrieved by cloning the repository found at 
<code>git://github.com/mepcotterell-cs1302/cs1302-fxgame.git</code>. 

Although I usually suggest developing directly on <code>nike.cs.uga.edu</code> 
since that is where your project will be run and tested when graded, this
project is a little more graphics-intensive than the previous project. 
Because of this, you will more than likely encounter a lot of lag when trying to
run and debug your program over SSH. Therefore, you may develop your game
on your own computer so long as you make sure that the final product
compiles on Nike using SBT.

If any changes are made to the project description or skeleton code, they will
be announced in class. In order to incorporate such changes into your code, you 
need only do a <code>git pull</code>.

## JavaFX Game Engine

Building a game in JavaFX is pretty simple. That being said, your instructor has
gone ahead and written a small game engine that you can utilize, if you choose
to do so, in order to make your game. Using the engine relies on the programmer
extending the abstract 
[<code>Game</code>](http://cobweb.cs.uga.edu/~mec/fxgame/com/michaelcotterell/game/Game.html)
class and implemeting the [<code>update</code>](http://cobweb.cs.uga.edu/~mec/fxgame/com/michaelcotterell/game/Updateable.html#update-com.michaelcotterell.game.Game-com.michaelcotterell.game.GameTime-) 
method. The engine abstracts all the details of running the game loop.
Anything that is put in the <code>update</code> method is automatically
executed once per iteration of the game loop after the game starts.
Here is an example of a small game that is written using the engine:

```java
import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestGame extends Game {

    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{ 
         setFill(Color.BLACK); 
    }};

    private Text text = new Text() {{
         setTranslateX(10);
         setTranslateY(20);
         setFill(Color.YELLOWGREEN);
    }};

    public TestGame(Stage stage) {
        super(stage, "TestGame", 60, 640, 480);
        getSceneNodes().getChildren().addAll(bg, text);
    } // TestGame

    @Override
    public void update(Game game, GameTime gameTime) {
        text.setText("Hello " + gameTime.getTotalGameTime());
        if (game.getKeyManager().isKeyPressed(KeyCode.UP)) text.setTranslateY(text.getTranslateY() - 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.DOWN)) text.setTranslateY(text.getTranslateY() + 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.LEFT)) text.setTranslateX(text.getTranslateX() - 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT)) text.setTranslateX(text.getTranslateX() + 4);
    } // update

} // TestGame
```

To launch the game, you just need to setup a driver for your JavaFX application.
Here is an example of a driver for the <code>TestGame</code> class provided
above:

```java
import com.michaelcotterell.game.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception { 
        Game game = new TestGame(primaryStage);
        primaryStage.setTitle(game.getTitle());
        primaryStage.setScene(game.getScene());
        primaryStage.show();
        game.run();
    } // start
    
    public static void main(String[] args) {
        launch(args);
    } // main
    
} // Driver
```

### API Documentation

The API documentation for this game engine can be found 
[here](http://cobweb.cs.uga.edu/~mec/fxgame/). In particular, pay attention
to the methods that are available to you in the <code>Game</code>
class. 

## Build System

For this project, we will be using the Simple Build System (sbt). If you clone 
the project from the GitHub repository then everything will be setup for you. In 
order to compile your project, you can use the following command:

    $ ./sbt compile

To run your project, use the following command:

    $ ./sbt run

In order to clean your project (remove compiled code), use the following command:

    $ ./sbt clean

## Submission Instructions

You will be submitting your project via <code>nike</code>. Make sure your 
work is on <code>nike.cs.uga.edu</code> in a directory called 
<code>FirstName-LastName-fxgame</code>, and, from within the parent directory, 
execute the following command:

    $ submit FirstName-LastName-fxgame cs1302b

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:

    $ tar zcvf FirstName-LastName-fxgame.tar.gz FirstName-LastName-fxgame
    $ mutt -s "[cs1302] fxgame" -a FirstName-LastName-fxgame.tar.gz -- your@email.com < /dev/null

## Questions

If you have any questions, please email them to Michael E. Cotterell at 
<code>mepcotterell+1302@gmail.com</code>

## Frequently Asked Questions

 1. What do I do if the <code>sbt</code> command does not execute?

    You probably need to make the file executable. To do this, simply make sure 
    you are in the same directory as <code>sbt</code> and issue the following
    command:

        $ chmod +x sbt

    This command updates the permissions on the file, making it executable for the
    current user.

 2. When I execute the <code>sbt run</code> command on <code>nike</code>, I get 
    a <code>java.awt.HeadlessException</code> that tells me no X11 DISPLAY 
    variable was set, but this program performed an operation which requires it.
    What is going on and how do I fix it?

    This exception is thrown if you are not running an X server on your computer
    or you are not telling your SSH client how to connect to the X server on
    your computer.

    If you are connecting to <code>nike</code> using a Linux or MacOS X machine
    then you probably already have an X server installed. If that is the case
    then you need to login using the following command:

        $ ssh -X username@nike.cs.uga.edu

    If you are using MacOS X and are unable to resolve your problem simply by
    issuing the above command then follow the directions [here](http://tutorialgenius.blogspot.com/2012/03/how-to-enable-x11-forwarding-with-ssh.html).
    After following the steps on that website, try logging into nike using the 
    SSH command above.

    If you are connecting to <code>nike</code> using PuTTY on Windows then you 
    need to download and install Xming. For information about how to setup Xming
    with Putty, please follow the directions [here](http://blog.nth-design.com/2010/05/19/x11-putty-xming/).
    You may skip some of the steps on that website (e.g., the section on 
    downloading and installing PuTTY), however, please read all of the sections
    related to Xming as wells the sections related to configuring PuTTY.\


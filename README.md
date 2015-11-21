# CSCI 1302 - FXGame (cs1302-fxgame)

This repository contains skeleton code for a project or assignment in  
the CSCI 1302 class at the University of Georgia. Please read the 
entirety of this file before beginning your project.

**This project is due on Tuesday 2015-12-08 @ 11:55 PM. Since this is
the day before Reading Day; there will be no extensions for this
project.**

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

 - [Space Invaders](http://en.wikipedia.org/wiki/Space_Invaders)
 - [Breakout](http://en.wikipedia.org/wiki/Breakout_clone)

The pictures presented in this README file are just examples. Your game
does not have to look exactly like the pictures. In fact, you get to
design what the GUI and game components look like.

## Option 1 - Space Invaders

Space Invaders is a two-dimensional fixed shooter game in which the player
controls a laser cannon by moving it horizontally across the bottom of the
screen and firing at descending aliens (space invaders). The aim is to defeat
the rows of aliens. The player defeats an alien, and earns points, by shooting
it with the laser cannon.

The aliens attempt to destroy the cannon by firing at it while they approach
the bottom of the screen. If they reach the bottom, the alien invasion
is successful and the game ends. Also, if the cannon is destroyed, the player
loses a life. If the player is out of lives, the game ends.

Occasionally, a mystery ship will appear and move across the top of
the screen (usually right-to-left). Once it makes it to the other side,
it usually dissapears.

The laser cannon is partially protected by several stationary defense
bunkers that are gradually destroyed by a numerous amount of blasts from the
aliens or player.

![Space Invaders](http://imgur.com/sXBK1Dk.png)

### Game Setup

The game must start with five rows of eleven aliens. The number of defense
bunkers should be eight. The player starts off with three lives.

### Scoring

Destroying a regular space invader should award 10 points.
Destroying a mystery ship should award 100 points.

### Level Mechanism

Your implementation of this game should have a mechanism whereby the game
increases in difficulty over time. The reccommended way of doing this is
to have levels. The level of the game increases after a certain number
of enemies are cleared. Each level should cause the space invaders to move
at a faster rate than at the previous level. If all enemies are cleared,
a new wave should appear, optionally restoring the defense bunkers.

## Option 2 - Breakout

A Breakout game is a sub-class of the "bat-and-ball" game genre. The genre gets 
its name by the games being based around the dynamics of a player-controlled 
paddle which hits a ball towards a wall of blocks or similar objects, that the 
player chips away at with the ball as part of the main gameplay. In this version
of Breakout, the bricks will have four different states: untouched, broken, really
broken, and dead. When a brick is first placed on the screen, it will be in the
"untouched" state. The first time the ball hits the brick, it will go into the 
"broken" state. This state should be visually different from the "untouched"
state. The second time the ball hits the brick, it will go into the "really broken"
state and should be visibly different from the "broken" state. Finally, the
third time the ball hits the brick, it will go into the "dead"
state and should be removed from the screen. 

![Breakout](http://imgur.com/uZGP1DF.jpg "Breakout")

### Game Setup

The game will start with at least 4 rows equilly spaced bricks being displayed
in atleast 6 columns. 
The game continues until either the player clears all the bricks (causes all them
to enter the "dead" state) and continues to the next level 
or the player misses the ball with
his or her paddle more than 3 times and loses. That is, the player
starts out with three lives.

### Scoring

Scoring is based on the number of bricks that have entered the "dead" state.
Every time a brick enters the "dead" state, the player earns 1 point.

### Level Mechanism

Your implementation of this game should have a mechanism whereby the game
increases in difficulty over time. The reccommended way of doing this is
to have levels. The level of the game increases after all of the bricks
of bricks are cleared. Each level should redraw the bricks, 
grant the player an additional life and should cause the speed of the ball 
to increase.

## Either Option

Whichever game you choose, you need to incorporate gameplay instructions
into your GUI. Be creative about how to do this. Also, be sure to
document what the instructions for your game are. In particular,
please include information on what buttons to press in order to play
your game.

## Project Tasks

This project is due on Tuesday 2014-12-09 @ 11:55 PM.
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
  * (20 points) The game keeps score as described by this <code>README.md</code> file.
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

   Author: YOUR NAME (LAST 3 DIGITS OF 810/811 NUMBER HERE)

   [If you did any of the exra credit then please indicate that here.]

   # Gameplay Instructions

   [Provide gameplay instructions here. This is important.]
   ```

### Extra Credit Tasks

 1. (10 points) Add an animated intro to your game (animated using the game loop).
    When your application starts, you should display some cool graphics, the 
    title of your game, your name, and some blinking "Press Enter" text. One way
    to accomplish this might be to place your scene nodes into different
    [<code>Group</code>](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Group.html) objects,
    then switch out which group is in the scene, depending on the state of your game.

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
execute the following command, depending on which section you are in:

### Supa' Mike's (Cotterell's) Section

    $ submit LastName-FirstName-p2 cs1302a

### Alothman's Section

    $ submit LastName-FirstName-p2 cs1302b

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:

    $ tar zcvf FirstName-LastName-fxgame.tar.gz FirstName-LastName-fxgame
    $ mutt -s "[cs1302] fxgame" -a FirstName-LastName-fxgame.tar.gz -- your@email.com < /dev/null

## Questions

If you have any questions, please email them to Michael E. Cotterell at 
<code>mepcott@uga.edu</code>

## Frequently Asked Questions

 1. What do I do if the <code>sbt</code> command does not execute?

    You probably need to make the file executable. To do this, simply make sure 
    you are in the same directory as <code>sbt</code> and issue the following
    command:

        $ chmod +x sbt

    This command updates the permissions on the file, making it executable for the
    current user.

# Frequently Asked Questions (FAQ)

Below is a collection of frequently asked questions related to this project.

## Questions Related to the FXGame Library

### What is the ```QuadTree``` class in the FXGame Library?

The [```QuadTree```](http://cobweb.cs.uga.edu/%7Emec/fxgame/com/michaelcotterell/game/util/QuadTree.html) class
in the [FXGame Library](http://cobweb.cs.uga.edu/%7Emec/fxgame/) is an
experimental and untested implementation of a [Quadtree](http://en.wikipedia.org/wiki/Quadtree)
data structure. **You should ignore it and not use it.**

### What are the ```Variate``` classes in the FXGame Library?

The [```com.michaelcotterell.random```](http://cobweb.cs.uga.edu/%7Emec/fxgame/com/michaelcotterell/random/package-summary.html) package
contains classes for random variate generation.
**You probably won't need to use these classes for your project.**
However, here's some information on random variate generation, just in case
you're interested.

Usually when someone wants to generate a random number, they want it to be
uniformly chosen between 0 and 1. The idea being that any value in the range
(0,1) should appear with equal probability. Sometimes you may want to generate
a random number in a particular range but have the probabilities not be
uniform. This is where variate generation comes into play. Variates
allow you to generate random numbers that are distributed according to a
specified probability distribution (e.g., Normal, Bernoulli, Exponential, etc.).

### How do you check for a key press once and not once per call to ```update```?

We know that we can use the [```getKeyManager```](http://cobweb.cs.uga.edu/%7Emec/fxgame/com/michaelcotterell/game/Game.html#getKeyManager--) method
inside of the ```update``` method to check if a key is pressed. However, since
that is being done inside the ```update``` method, the check occurs many
times per second. This effect is not desirable for handling some things like
in game menus.

To get around this, you need to add a custom ```EventHandler``` to the
game's scene. First, you should create a handler method in your ```Game```
subclass for whatever you're trying to do:

```java
public void handler(KeyEvent event) {
    // do stuff, for example:
    if (event.getCode() == KeyCode.SPACE) {
       // we know the space bar has been pressed
    } // if
} // handler
```
Then, in the constructor of your ```Game``` subclass, you might
do something like the following:

```java
public MyGame(Stage stage) {
    super(stage, "MyGame", 60, 640, 480);
    getScene().addEventHandler(KeyEvent.KEY_PRESSED, this::handler);
    // rest of constructor code
} // MyGame
```


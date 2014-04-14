package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestGame extends Game {

    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, 640, 480) {{ 
         setFill(Color.BLACK); 
    }};

    // some text to display the time
    private Text text = new Text() {{
         setTranslateX(10);
         setTranslateY(20);
         setFill(Color.YELLOWGREEN);
    }};

    /**
     * Constructs a new test game.
     * @param stage the primary stage
     */
    public TestGame(Stage stage) {
        super(stage, "TestGame", 60, 640, 480);
        getSceneNodes().getChildren().addAll(bg, text);
    } // TestGame

    @Override
    public void update(Game game, GameTime gameTime) {
        text.setText("The time is " + gameTime.getTotalGameTime());
        if (game.getKeyManager().isKeyPressed(KeyCode.UP)) text.setTranslateY(text.getTranslateY() - 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.DOWN)) text.setTranslateY(text.getTranslateY() + 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.LEFT)) text.setTranslateX(text.getTranslateX() - 4);
        if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT)) text.setTranslateX(text.getTranslateX() + 4);
    } // update

} // TestGame


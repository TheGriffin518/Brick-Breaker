
package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.pong.PongGame;
import javafx.application.Application;
import javafx.stage.Stage;

public class Driver extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception { 
        Game game = new PongGame(primaryStage);
        primaryStage.setTitle(game.getTitle());
        primaryStage.setScene(game.getScene());
        primaryStage.show();
        game.run();
    } // start
    
    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver


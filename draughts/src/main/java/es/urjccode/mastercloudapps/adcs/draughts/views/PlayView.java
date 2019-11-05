package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class PlayView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};

    private static final String MESSAGE = "Derrota!!! No puedes mover tus fichas!!!";

    public PlayView(){
        super();
    }

    public void interact(PlayController playController) {
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            String[] numbers = command.split("\\.|\\n");
            error = playController.move(
                new Coordinate(numbers[0]), 
                new Coordinate(numbers[1]));
            if (error != null){
                console.writeln("Error!!!" + error.name());
                gameView.write(playController);
            }
        } while (error != null); 
        if (playController.isBlocked()){
            this.console.write(PlayView.MESSAGE);
        }
    }

}
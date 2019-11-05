package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

enum MessageView {

    TITTLE("Draughts");

    private String message;
    
    private static Console console = new Console();

    private MessageView(String message) {
        this.message = message;
    }

    public void write(){
        MessageView.console.write(this.message);
    }

    public void writeln(){
        MessageView.console.writeln(this.message);
    }

}
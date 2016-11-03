/**
 * Created by brynjarolafsson on 03/11/16.
 */

public class Player {

    public String playerName;
    Race race;

    public Player(String playerName,Races races){
        this.playerName = playerName;
        this.race = new Race(races);
    }

    public static void main(String[] args) {
        Player player = new Player("Johnny", Races.Orc);
    }
}

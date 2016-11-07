import java.util.ArrayList;
import java.util.List;

/**
 * Created by brynjarolafsson on 03/11/16.
 */
import java.util.*;

public class Player {

    public String playerName;
    Race race;

    public Player(String playerName,Races races){
        this.playerName = playerName;
        this.race = new Race(races);
    }

    public static void main(String[] args) {

        Player player = new Player("Johnny", Races.Orc);
        Map playerActions = new HashMap();
        playerActions.put("Steal", "-4");
        playerActions.put("Buy", "3");

        System.out.println(player.race.features.getFeatures());

    }

}

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
        Map playerActions = new HashMap<>();
        playerActions.put("Steal","-4");
        playerActions.put("Buy","3")

    }
}


/*

public class CollectionsDemo {

   public static void main(String[] args) {
      Map m1 = new HashMap();
      m1.put("Zara", "8");
      m1.put("Mahnaz", "31");
      m1.put("Ayan", "12");
      m1.put("Daisy", "14");

      System.out.println();
      System.out.println(" Map Elements");
      System.out.print("\t" + m1);
   }
}
 */
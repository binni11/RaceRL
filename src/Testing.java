import java.util.HashMap;
import java.util.Map;

/**
 * Created by hordurh15 on 11.11.2016.
 */
public class Testing {

    public static void main(String[] args) {

        Player player = new Player("Johnny", Races.Orc);
        Player player2 = new Player("Eldur", Races.Goblin);

        MerchantMemory newMem = new MerchantMemory(player, PlayerActions.Leave, 30);
        MerchantMemory newMem2 = new MerchantMemory(player2, PlayerActions.Buy, 50);
        System.out.println(newMem.toString());

        State state = new State();
        state.meetPlayer(newMem);
        state.meetPlayer(newMem2);
        state.meetPlayer(newMem2);

        state.listAllMemories(); 

    }
}

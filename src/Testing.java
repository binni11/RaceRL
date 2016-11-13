import java.util.HashMap;
import java.util.Map;

/**
 * Created by hordurh15 on 11.11.2016.
 */
public class Testing {

    public static void main(String[] args) {

        Player player = new Player("Johnny", Races.Orc);
        Player player2 = new Player("Eldur", Races.Goblin);
        Player player3 = new Player("Vatn", Races.Human);
        Player player4 = new Player("Earth", Races.Elf);

        MerchantMemory newMem = new MerchantMemory(player, PlayerActions.Leave, 30);
        MerchantMemory newMem2 = new MerchantMemory(player2, PlayerActions.Buy, 50);
        MerchantMemory newMem3 = new MerchantMemory(player3, PlayerActions.Steal, -40);
        MerchantMemory newMem4 = new MerchantMemory(player4, PlayerActions.Buy, 60);
        MerchantMemory newMem5 = new MerchantMemory(player3, PlayerActions.Steal, -100);
        MerchantMemory newMem6 = new MerchantMemory(player4, PlayerActions.Buy, 35);

        State state = new State();
        state.meetPlayer(newMem);
        state.meetPlayer(newMem3);
        state.meetPlayer(newMem4);
        state.meetPlayer(newMem5);
        state.meetPlayer(newMem6);

        state.listAllMemories();

        state.calculatePlayerScore(newMem2);

    }
}

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
        Player player4 = new Player("Hillary", Races.Elf);
        Player player5 = new Player("Trump", Races.Troll);

        MerchantMemory newMem = new MerchantMemory(player, PlayerActions.Leave, 30.0);
        MerchantMemory newMem2 = new MerchantMemory(player2, PlayerActions.Buy, 50.0);
        MerchantMemory newMem3 = new MerchantMemory(player3, PlayerActions.Steal, -40.0);
        MerchantMemory newMem4 = new MerchantMemory(player4, PlayerActions.Buy, 60.0);
        MerchantMemory newMem5 = new MerchantMemory(player5, PlayerActions.Steal, -100.0);

        State state = new State();
        state.meetPlayer(newMem, true);
        state.meetPlayer(newMem2, true);
        state.meetPlayer(newMem3, true);
        state.meetPlayer(newMem4, true);
        state.meetPlayer(newMem5, true);


    }
}

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hordurh15 on 11.11.2016.
 */

public class MerchantMemory {

    public ArrayList<String> features;
    public PlayerActions playerAction;
    public double playerScore;

    public MerchantMemory(Player player, PlayerActions actions, double score) {

        this.features = new ArrayList<>(player.race.features.getFeatures());
        this.playerAction = actions;
        this.playerScore = score;
    }

    public void UpdateScore(double score) {
        this.playerScore = score;
    }

    @Override
    public String toString() {

        return features + " " + playerAction + " " + playerScore;
    }


}

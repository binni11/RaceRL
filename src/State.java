import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hordurh15 on 11.11.2016.
 */
public class State {

    public Collection<MerchantMemory> memoryCollection;

    public State() {

        memoryCollection = new ArrayList<>();
    }

    public void meetPlayer(MerchantMemory memory) {

        if (!memoryCollection.contains(memory)) {
            System.out.println("I haven't met you before, adding to memory and calculating score");
            memoryCollection.add(memory);
        }
        else {
            System.out.println("I have met you before, looking up score");
        }
    }

    public void listAllMemories() {
        for (MerchantMemory mem : memoryCollection) {
            System.out.println(mem.features);
        }
    }

}

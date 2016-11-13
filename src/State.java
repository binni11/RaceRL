import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hordurh15 on 11.11.2016.
 */
public class State {

    public ArrayList<MerchantMemory> memoryCollection;

    public State() {

        memoryCollection = new ArrayList<>();
    }

    public void meetPlayer(MerchantMemory memory) {

        if (memoryCollection.isEmpty()) {
            memoryCollection.add(memory);
            System.out.println("First time meeting");
            return;
        }
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
            System.out.println(mem);
        }
    }

    public double calculatePlayerScore(MerchantMemory memory) {

        ArrayList<Double> list = new ArrayList<>();
        int counter = 0;
        double contribution = 0;
        double playerScore = 0;

        System.out.println("Comparing this: \n" + memory.toString());
        System.out.println("To the current list:");
        listAllMemories();

        // iterate the memory list.
        for (int i = 0; i < memoryCollection.size(); i++) {
            counter = 0;
            contribution = 0;
            System.out.println("Going over memory list item nr: " + i);
            // iterate the features in the current memory list.
            for (int k = 0; k < memoryCollection.get(i).features.size(); k++) {
                // compare the new memory to the features in the memory list.
                for (int l = 0; l < memory.features.size(); l++) {
                    if (memory.features.get(l).equals(memoryCollection.get(i).features.get(k))) {
                        System.out.println("Found match: " + memory.features.get(l));
                        counter += 1;
                        int size = memoryCollection.get(i).features.size();
                        double score = memoryCollection.get(i).playerScore;
                        contribution += (1D/size)*score;
                    }
                }
            }
            System.out.println("Found Matches: " + counter + " PlayerScore: " + memoryCollection.get(i).playerScore);
            System.out.println("Adding to list: " + "i: " + i + " contribution: " + contribution);
            list.add(i, contribution);
        }

        for (int i = 0; i < list.size(); i++) {
            playerScore += list.get(i);
        }

        System.out.println("Resulting playerScore: " + playerScore);
        return playerScore;
    }

}

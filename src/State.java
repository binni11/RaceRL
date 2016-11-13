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

    // adjust a players score depending of previous players met with similar attributes.
    public void meetPlayer(MerchantMemory memory, boolean details) {

        if (memoryCollection.isEmpty()) {
            memoryCollection.add(memory);
        }
        else if (!memoryCollection.contains(memory)) {
            double score = calculatePlayerScore(memory,false);
            memory.UpdateScore(score);
            memoryCollection.add(memory);
            if (details) {
                System.out.println("I haven't met you before, adding to memory and calculating score");
                System.out.println("Score is : " + score);
                listAllMemories();
                System.out.println("\n");
            }
        }
        else {
            System.out.println("I have met you before");
        }
    }

    public void listAllMemories() {
        for (MerchantMemory mem : memoryCollection) {
            System.out.println(mem);
        }
    }

    public double calculatePlayerScore(MerchantMemory memory, boolean details) {

        ArrayList<Double> list = new ArrayList<>();
        int counter = 0;
        double contribution = 0;
        double playerScore = 0;

        if (details) {
            System.out.println("\nComparing this: \n" + memory.toString());
            System.out.println("\nTo the current list:");
            listAllMemories();
        }

        // iterate the memory list.
        for (int i = 0; i < memoryCollection.size(); i++) {
            counter = 0;
            contribution = 0;
            if (details) {
                System.out.println("\nGoing over memory list item nr: " + i);
                System.out.println(memoryCollection.get(i));
            }
            // iterate the features in the current memory list.
            for (int k = 0; k < memoryCollection.get(i).features.size(); k++) {
                // compare the new memory to the features in the memory list.
                for (int l = 0; l < memory.features.size(); l++) {
                    if (memory.features.get(l).equals(memoryCollection.get(i).features.get(k))) {
                        if (details) {
                            System.out.println("Found match: " + memory.features.get(l));
                        }
                        counter += 1;
                        int size = memoryCollection.get(i).features.size();
                        double score = memoryCollection.get(i).playerScore;
                        contribution += (1D/size)*score;
                    }
                }
            }
            if (details) {
                System.out.println("Found Matches: " + counter + " PlayerScore: " + memoryCollection.get(i).playerScore);
                System.out.println("Calculating contribution: " + contribution + "\n");
            }
            list.add(i, contribution);
        }

        for (int i = 0; i < list.size(); i++) {
            playerScore += list.get(i);
        }

        if (details) {
            System.out.println("Resulting playerScore: " + playerScore);
        }
        return playerScore;
    }

}

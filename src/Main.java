import burlap.behavior.singleagent.Episode;
import burlap.behavior.singleagent.auxiliary.EpisodeSequenceVisualizer;
import burlap.behavior.singleagent.learning.LearningAgent;
import burlap.behavior.singleagent.learning.tdmethods.QLearning;
import burlap.behavior.singleagent.learning.tdmethods.SarsaLam;
import burlap.domain.singleagent.gridworld.GridWorldDomain;
import burlap.domain.singleagent.gridworld.GridWorldTerminalFunction;
import burlap.domain.singleagent.gridworld.GridWorldVisualizer;
import burlap.domain.singleagent.gridworld.state.GridAgent;
import burlap.domain.singleagent.gridworld.state.GridLocation;
import burlap.domain.singleagent.gridworld.state.GridWorldState;
import burlap.mdp.auxiliary.stateconditiontest.StateConditionTest;
import burlap.mdp.auxiliary.stateconditiontest.TFGoalCondition;
import burlap.mdp.core.TerminalFunction;
import burlap.mdp.core.state.State;
import burlap.mdp.singleagent.environment.SimulatedEnvironment;
import burlap.mdp.singleagent.model.RewardFunction;
import burlap.mdp.singleagent.oo.OOSADomain;
import burlap.statehashing.HashableStateFactory;
import burlap.statehashing.simple.SimpleHashableStateFactory;
import burlap.visualizer.Visualizer;

/**
 * Created by brynjarolafsson on 28/10/16.
 */
public class Main {

    GridWorldDomain gridWorldDomain;
    OOSADomain domain;
    RewardFunction rewardFunction;
    TerminalFunction terminalFunction;
    StateConditionTest goalCondition;
    State initialState;
    HashableStateFactory hashingFactory;
    SimulatedEnvironment environment;

    public Main() {
        gridWorldDomain = new GridWorldDomain(11,11);
        gridWorldDomain.setMapToFourRooms();
        terminalFunction = new GridWorldTerminalFunction(10,10);
        gridWorldDomain.setTf(terminalFunction);
        goalCondition = new TFGoalCondition(terminalFunction);
        domain = gridWorldDomain.generateDomain();

        initialState = new GridWorldState(new GridAgent(0,0), new GridLocation(10,10,"loc0"));
        hashingFactory = new SimpleHashableStateFactory();

        environment = new SimulatedEnvironment(domain, initialState);
    }

    public void Visualize(String outputPath) {
        Visualizer v = GridWorldVisualizer.getVisualizer(gridWorldDomain.getMap());
        new EpisodeSequenceVisualizer(v, domain, outputPath);
    }

    public void QLearningExample(String outputPath) {
        LearningAgent agent = new QLearning(domain, 0.99, hashingFactory, 0., 1.);

        for (int i = 0; i < 50; i++) {
            Episode e = agent.runLearningEpisode(environment);

            e.write(outputPath + "ql_" + i);
            System.out.println(i + ": " + e.maxTimeStep());

            environment.resetEnvironment();
        }
    }

    public void SarsaLearningExample(String outputPath){

        LearningAgent agent = new SarsaLam(domain, 0.99, hashingFactory, 0., 0.5, 0.3);

        //run learning for 50 episodes
        for(int i = 0; i < 50; i++){
            Episode e = agent.runLearningEpisode(environment);

            e.write(outputPath + "sarsa_" + i);
            System.out.println(i + ": " + e.maxTimeStep());

            //reset environment for next learning episode
            environment.resetEnvironment();
        }

    }

    public static void main(String[] args) {
        Main example = new Main();
        String outputPath = "output/";


        example.SarsaLearningExample(outputPath);


        example.Visualize(outputPath);
    }
}

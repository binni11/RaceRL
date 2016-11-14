/**
 * Created by hoddi84 on 14.11.2016.
 */

// þessi hluti er aðeins til þess gerður að hjálpa mér að sjá þetta betur fyrir mér.
public class Qlearn {

    enum PlayerActions {
        Buy, // positive action.
        Steal // negative action.
    }

    enum MerchantActions {
        LetIn, // positive action.
        KickOut // neutral action.
    }

    enum Races {
        Orc,
        Troll,
    }

    int[][] R = new int[2][2];
    double[][] Q = new double[2][2];

    // immediate reward values.
    void InitR() {
        R[1][1] = 1; // orc let in.
        R[1][2] = 0; // orc kick out.
        R[2][1] = 1; // troll let in.
        R[2][2] = 0; // troll kick out.
    }

    // pre-initialized the merchants memory.
    void InitQ() {
        Q[1][1] = 30; // orc walks in i let in.
        Q[1][2] = -15; // orc walks in i kick out.
        Q[2][1] = 20; // troll walks in i let in.
        Q[2][2] = 10; // troll walks in i kick out.
    }

    public static void main(String args[]) {

        // alpha = 0.1 gamma = 0.9
        // troll walks in.
        // choose actions that gives a = maxQ(s,a)  where s = troll/orc and action is letin/kickout.
        // look at InitQ table, [troll][let in] = 20 is the highest value. => choose that action.
        // do action ---> let in (troll)
        // receive immediate reward, which is R[troll][let in] = 1, receive reward --> 1.
        // Maybe immediate reward will be affected by what action the player will perform, e.g.
        // we receive 1 immediate reward for letting in, and +2 if the player buys or -3 if he steals......
        // therefore the immediate reward will be 1+2=3(buy), or 1-3=-2(steal)

        // now troll will either BUY or STEAL, how should that affect....

        // THERE IS NO NEW STATE YET, UNTIL ANOTHER PLAYER WALKS IN.
        // (or we can wait to update until another player enters)!!!!!!
        // ORC WALKS IN NEXT SO NOW WE UPDATE Q(s,a).
        // so we update Q[troll][let in] = Q[troll][let in] + alpha(1 + gamma*Q[orc][let in] - Q[troll][let in]))
        // which becomes Q[troll][let in] = 20 + 0.1(1 + 0.9*30 - 20)

        // so for changes in immediate reward the new Q(s,a) value would become:
        // Q(s,a) = 21 (troll comes, let him in, he buys)
        // Q(s,a) = 20.5 (troll comes, let him in, he steals)

        // update Q(s,a) now => Q(s,a) = Q(s,a) + alpha(R + gamma*maxQ(s',a') - Q(s,a))
        // s = s'.

        // lets try it this way
        // Q(s,a) is the state where Q[troll][let in] as previously, buy we will rethink the
        // next state/action pair Q(s',a') as the same Q[troll][let in] but -/+ the player action.
        // so we get:
        // Q[troll][let in] = 20 + 0.1(1 + 0.9*(20+2) - 20) for buy action
        // Q[troll][let in] = 20 + 0.1(1 + 0.9*(20-3) - 20) for steal actions
        // Q(s,a) = 20.08 (buy)
        // Q(s,a) = 19.63 (steal)
    }
}

package Bank;

import User.State;

import java.util.LinkedList;
import java.util.List;

public class BankManager {
    private List<State> usersState = new LinkedList<State>();
    public void subscribe(State user) {
        usersState.add(user);
    }

    public void unsubscribe(State user) {
        usersState.remove(user);
    }

    public void notifyBanks(NotifyMessage notify) {
        for (int listener = 0; listener < usersState.size(); listener++) {
            usersState.get(listener).update(notify);
        }
    }
}

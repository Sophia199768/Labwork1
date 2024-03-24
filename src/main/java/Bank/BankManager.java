package Bank;

import User.State;

import java.util.LinkedList;
import java.util.List;

public class BankManager {
    private List<State> usersState = new LinkedList<>();

    /**
     * <p>
     *   Subscribe
     *   Function to subscribe users
     * </p>
     */
    public void subscribe(State user) {
        usersState.add(user);
    }

    /**
     * <p>
     *   Unsubscribe
     *   Function to unsubscribe user from notifies
     * </p>
     */
    public void unsubscribe(State user) {
        usersState.remove(user);
    }

    /**
     * <p>
     *   NotifyBanks
     *   Function to notify every banks about new event
     * </p>
     */
    public void notifyBanks(NotifyMessage notify) {
        usersState.forEach(user -> user.update(notify));
    }
}

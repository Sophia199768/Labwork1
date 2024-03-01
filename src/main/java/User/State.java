package User;

import Bank.NotifyMessage;

public abstract class State {
    protected User user;

    public State(User user) {
        this.user = user;
    }

    abstract State addMissingData(String _address, Integer _passport);

    /**
     * <p>
     *   Update
     *   Function to notify user about some events.
     * </p>
     */
    public void update(NotifyMessage notify) {
        user.update(notify);
    }
}

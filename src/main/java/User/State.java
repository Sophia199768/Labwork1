package User;

import Bank.NotifyMessage;

public abstract class State {
    protected User user;

    public State(User user) {
        this.user = user;
    }

    abstract State addMissingData(String _address, Integer _passport);
    public void update(NotifyMessage notify) {
        user.update(notify);
    }
}

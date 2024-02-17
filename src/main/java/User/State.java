package User;

import Bank.NotifyMessage;

public abstract class State {
    protected User user;

    public State(User _user) {
        user = _user;
    }

    abstract State addMissingData(String _address, int _passport);
    public void update(NotifyMessage notify) {
        user.update(notify);
    }
}

package User;

public class FullAccessUser extends State {
    public FullAccessUser(User _user) {
        super(_user);
    }

    @Override
    State addMissingData(String _address, int _passport) {
        return this;
    }
}

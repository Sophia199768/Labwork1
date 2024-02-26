package User;

public class FullAccessUser extends State {
    public FullAccessUser(User user) {
        super(user);
    }

    @Override
    State addMissingData(String address, Integer passport) {
        return this;
    }
}

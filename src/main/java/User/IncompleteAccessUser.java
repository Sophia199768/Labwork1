package User;

public class IncompleteAccessUser extends State {
    public IncompleteAccessUser(User user) {
        super(user);
    }

    @Override
    State addMissingData(String address, Integer passport) {
        super.user.addMissingData(address, passport);
        return new FullAccessUser(this.user);
    }
}

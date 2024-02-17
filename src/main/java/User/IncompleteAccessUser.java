package User;

public class IncompleteAccessUser extends State {
    public IncompleteAccessUser(User _user) {
        super(_user);
    }

    @Override
    State addMissingData(String _address, int _passport) {
        super.user.addMissingData(_address, _passport);
        return new FullAccessUser(this.user);
    }
}

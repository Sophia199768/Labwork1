package User;

public class IncompleteAccessUser extends State {
    public IncompleteAccessUser(User user) {
        super(user);
    }

    /**
     * <p>
     *   AddMissingData
     *   Function for user who wants to hava a full acess account
     *   Enter address and passport
     * </p>
     * @param address to update information of user and give him an address
     * @param passport to update information of user and give him a passport
     * @return State
     */
    @Override
    State addMissingData(String address, Integer passport) {
        super.user.addMissingData(address, passport);
        return new FullAccessUser(this.user);
    }
}

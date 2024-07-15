package User;

public class FullAccessUser extends State {
    public FullAccessUser(User user) {
        super(user);
    }

    /**
     * <p>
     *   AddMissingData
     *   Function to watch all account intforamation
     * </p>
     * @return State
     */
    @Override
    State addMissingData(String address, Integer passport) {
        return this;
    }
}

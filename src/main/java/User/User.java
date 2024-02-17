package User;

import Bank.NotifyMessage;

public class User {
    /**
     * <p>This is a simple description of the method. . .
     * </p>
     * @param name the name of User
     *
     */
    private String name;
    private String surname;
    private String address;
    private int passport;


    public User(String _name, String _surname, String _address, int _passport) {
        name = _name;
        surname = _surname;
        address = _address;
        passport = _passport;
    }
    /**
     * <p>This is a description of the method update
     * </p>
     * @param notify the name of User
     */
    public void update(NotifyMessage notify) {
    }

    /**
     * <p>This is a description of the method getPassport
     * </p>
     * @return passport
     */
    public int getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public void addMissingData(String _address, int _passport) {
        address = _address;
        passport = _passport;
    }
}

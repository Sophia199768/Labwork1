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
    private Integer passport;


    public User(String name, String surname, String address, Integer passport) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.passport = passport;
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

    public void addMissingData(String address, Integer passport) {
        this.address = address;
        this.passport = passport;
    }
}

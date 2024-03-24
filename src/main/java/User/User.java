package User;

import Bank.NotifyMessage;

import java.util.LinkedList;
import java.util.List;

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
    private List<NotifyMessage> notifyHistory = new LinkedList<>();


    public User(String name, String surname, String address, Integer passport) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.passport = passport;
    }
    /**
     * <p>This is a description of the method update
     *  Function to save all notifies if something happens with account
     * </p>
     * @param notify the name of User
     */
    public void update(NotifyMessage notify) {
        notifyHistory.add(notify);
    }

    /**
     * <p>This is a description of the method getPassport
     * This function return number of user passport
     * </p>
     * @return passport
     */
    public int getPassport() {
        return passport;
    }

    /**
     * <p>This is a description of the method getAddress
     * This function return number of user address
     * </p>
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * <p>This is a description of the method getAddress
     * Function to complete registration in user account and have unlimited version.
     * </p>
     */
    public void addMissingData(String address, Integer passport) {
        this.address = address;
        this.passport = passport;
    }
}

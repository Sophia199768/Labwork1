package User;

import java.util.Objects;

public class MatchingUserState {

    /**
     * <p>
     *   Match
     *   Function to give unlimited account if user enter all information about themselves.
     *   If user did not give such information as passport or address then his account recognized as limited in functionality.
     * </p>
     * @return State
     */
    public State Match(User user) {
        if (Objects.equals(user.getAddress(), "") || user.getPassport() == 0) {
            return new IncompleteAccessUser(user);
        }
        return new FullAccessUser(user);
    }
}

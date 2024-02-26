package User;

import java.util.Objects;

public class MatchingUserState {
    public State Match(User user) {
        if (Objects.equals(user.getAddress(), "") || user.getPassport() == 0) {
            return new IncompleteAccessUser(user);
        }
        return new FullAccessUser(user);
    }
}

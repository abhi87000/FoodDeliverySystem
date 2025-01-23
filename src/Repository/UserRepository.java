package Repository;

import Model.User;

import java.util.Map;

public class UserRepository {
    public static Map<String, User> userMap;

    public UserRepository(Map<String, User> userMap) {
        UserRepository.userMap = userMap;
    }

}

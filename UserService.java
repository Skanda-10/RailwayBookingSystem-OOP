import java.util.ArrayList;
import java.util.List;

class UserService {
    private final List<User> users = new ArrayList<>();

    public void signup(String name, String mobile, String username, String password) {
        users.add(new User(name, mobile, username, password));
        System.out.println("Signup successful!");
    }

    public User login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("Welcome, " + u.getName());
                return u;
            }
        }
        return null;
    }
}
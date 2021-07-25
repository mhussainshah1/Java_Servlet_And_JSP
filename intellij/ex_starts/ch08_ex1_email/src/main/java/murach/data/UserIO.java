package murach.data;

import murach.business.User;

import java.io.*;
import java.util.*;

public class UserIO {

    public static void addRecord(User user, String filename) throws IOException {
        var file = new File(filename);
        PrintWriter out = new PrintWriter(new FileWriter(file, true));
        out.println(user.getEmail() + "|" + user.getFirstName() + "|" + user.getLastName());
        out.close();
    }

    public static User getUser(String emailAddress, String filename) throws IOException {
        var file = new File(filename);
        var in = new BufferedReader(new FileReader(file));
        var user = new User();
        var line = in.readLine();
        while (line != null) {
            var token = new StringTokenizer(line, "|");
            var email = token.nextToken();
            if (email.equalsIgnoreCase(emailAddress)) {
                var firstName = token.nextToken();
                var lastName = token.nextToken();
                user.setEmail(emailAddress);
                user.setFirstName(firstName);
                user.setLastName(lastName);
            }
            line = in.readLine();
        }
        in.close();
        return user;
    }

    public static List<User> getUsers(String filename) throws IOException {
        List<User> users = new ArrayList<>();
        var in = new BufferedReader(new FileReader(filename));
        var line = in.readLine();
        while (line != null) {
            try {
                var token = new StringTokenizer(line, "|");
                var emailAddress = token.nextToken();
                var firstName = token.nextToken();
                var lastName = token.nextToken();
                var user = new User(firstName, lastName, emailAddress);
                users.add(user);
                line = in.readLine();
            } catch (NoSuchElementException e) {
                line = in.readLine();
            }
        }
        in.close();
        return users;
    }

    public static Map<String, User> getUsersMap(String filename) throws IOException {
        Map<String, User> users = new HashMap<>();
        var in = new BufferedReader(new FileReader(filename));
        var line = in.readLine();
        while (line != null) {
            try {
                var token = new StringTokenizer(line, "|");
                var emailAddress = token.nextToken();
                var firstName = token.nextToken();
                var lastName = token.nextToken();
                var user = new User(firstName, lastName, emailAddress);
                users.put(emailAddress, user);
                line = in.readLine();
            } catch (NoSuchElementException e) {
                line = in.readLine();
            }
        }
        in.close();
        return users;
    }
}

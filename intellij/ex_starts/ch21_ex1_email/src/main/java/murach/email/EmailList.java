package murach.email;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import murach.business.User;
import murach.data.UserDB;
//import jakarta.faces.bean.ManagedBean;
//import jakarta.faces.bean.RequestScoped;
//@ManagedBean
@Named
@RequestScoped
public class EmailList {
    private User user;
    private String message;
    
    public EmailList() {
    }
    
    @PostConstruct
    public void init() {
        user = new User();
    }
    
    public String addToEmailList() {
        if (UserDB.emailExists(user.getEmail())) {
            message = "This email address already exists. " +
                    "Please enter another email address";
            return "index";
        } else {
            UserDB.insert(user);
            return "thanks";
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }
}
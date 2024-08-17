package Interface;

import Constants.AccountStatus;
import models.Person;

public abstract class Account {
    private String username;
    private String pwd;
    private Person person;
    private AccountStatus status;

    public abstract boolean resetPassword();
}
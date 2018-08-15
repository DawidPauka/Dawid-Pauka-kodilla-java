package com.kodilla.good.patterns.allegro;

public class MailService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Thank You " + user.getUserName() + " for your order!");
    }
}
package dto;

import com.github.javafaker.Faker;

public class AccountFactory {

    public static Account getAccount(String rating, String type, String ownership, String industry, String client, String skills) {
        Faker faker = new Faker();
        return new Account(
                rating, // фиксированное значение
                faker.company().name(),               // name
                faker.phoneNumber().phoneNumber(),    // phone
                faker.phoneNumber().phoneNumber(),    // fax
                faker.number().digits(6),      // number
                faker.internet().url(),               // website
                faker.internet().url(),               // site
                faker.finance().bic(),               // symbol
                type,
                ownership,
                industry,
                String.valueOf(faker.number().numberBetween(10, 500)), // employees
                faker.commerce().price(),             // revenue
                faker.number().digits(4),       // code
                client,                                 // client
                skills,                                 // skills
                faker.address().streetAddress(),      // street
                faker.address().secondaryAddress());   // shipping
    }
}

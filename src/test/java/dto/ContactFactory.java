package dto;

import com.github.javafaker.Faker;

public class ContactFactory {

    public static Contact getContact(String salutation, String leadsource, String email) {
    Faker faker = new Faker();
    return new Contact(
                salutation,                              // salutation (Mr., Ms. и т.д.)
                faker.phoneNumber().phoneNumber(),       // phone
                faker.phoneNumber().phoneNumber(),       // home phone
                faker.name().firstName(),                // first name
                faker.name().lastName(),                 // last name
                faker.phoneNumber().cellPhone(),         // mobile
                faker.job().title(),                     // title
                faker.phoneNumber().phoneNumber(),       // other phone
                leadsource,                              // lead source (fixed/dropdown)
                faker.company().name(),                  // department
                faker.phoneNumber().phoneNumber(),       // fax
                email,                                    // email
                faker.name().firstName(),                // assistant
                faker.phoneNumber().phoneNumber(),       // assistant phone
                faker.address().streetAddress(),         // mailing street
                faker.address().secondaryAddress());    // other street
    }
}


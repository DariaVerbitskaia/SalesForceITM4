package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import wrappers.Picklist;

@Data
@AllArgsConstructor
public class Contact {
    String salutation;
    String phone;
    String homephone;
    String firstname;
    String lastname;
    String mobile;
    String title;
    String otherphone;
    String leadsource;
    String department;
    String fax;
    String email;
    String assistant;
    String asstphone;
    String mailingstreet;
    String otherstreet;
}
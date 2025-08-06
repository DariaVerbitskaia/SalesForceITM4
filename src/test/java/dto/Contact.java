package dto;

import wrappers.Picklist;

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

    public Contact(String salutation, String phone, String homephone, String firstname, String lastname, String mobile, String title, String otherphone, String leadsource, String department, String fax, String email, String assistant, String asstphone, String mailingstreet, String otherstreet) {
        this.salutation = salutation;
        this.phone = phone;
        this.homephone = homephone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.title = title;
        this.otherphone = otherphone;
        this.leadsource = leadsource;
        this.department = department;
        this.fax = fax;
        this.email = email;
        this.assistant = assistant;
        this.asstphone = asstphone;
        this.mailingstreet = mailingstreet;
        this.otherstreet = otherstreet;
    }

    public String getSalutation() {
        return salutation;
    }

    public String getPhone() {
        return phone;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getTitle() {
        return title;
    }

    public String getOtherphone() {
        return otherphone;
    }

    public String getLeadsource() {
        return leadsource;
    }

    public String getDepartment() {
        return department;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getAssistant() {
        return assistant;
    }

    public String getAsstphone() {
        return asstphone;
    }

    public String getMailingstreet() {
        return mailingstreet;
    }

    public String getOtherstreet() {
        return otherstreet;
    }
}

package dto;

public class Account {
    String rating;
    String name;
    String phone;
    String fax;
    String number;
    String website;
    String site;
    String symbol;
    String type;
    String ownership;
    String industry;
    String employees;
    String revenue;
    String code;
    String client;
    String skills;
    String street;
    String shipping;


    public Account(String rating, String name, String phone, String fax, String number, String website, String site, String symbol, String type, String ownership, String industry, String employees, String revenue, String code, String client, String skills, String street, String shipping) {
        this.rating = rating;
        this.name = name;
        this.phone = phone;
        this.fax = fax;
        this.number = number;
        this.website = website;
        this.site = site;
        this.symbol = symbol;
        this.type = type;
        this.ownership = ownership;
        this.industry = industry;
        this.employees = employees;
        this.revenue = revenue;
        this.code = code;
        this.client = client;
        this.skills = skills;
        this.street = street;
        this.shipping = shipping;
    }

    public String getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getNumber() {
        return number;
    }

    public String getWebsite() {
        return website;
    }

    public String getSite() {
        return site;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }

    public String getOwnership() {
        return ownership;
    }

    public String getIndustry() {
        return industry;
    }

    public String getEmployees() {
        return employees;
    }

    public String getRevenue() {
        return revenue;
    }

    public String getCode() {
        return code;
    }

    public String getClient() {
        return client;
    }

    public String getSkills() {
        return skills;
    }

    public String getStreet() {
        return street;
    }

    public String getShipping() {
        return shipping;
    }
}

package model;

public class User {

    private Long id;
    private String name;
    private String email;
    private String country;

    private Province province;

    public User(Long id, String name, String email, String country, Province province) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.province = province;
    }
    public User(Long id, String name, String email, String country){
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
    }

    public User(String name, String email, String country, Province province) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}

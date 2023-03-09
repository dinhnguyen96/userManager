package model;

public class Province {

    private Long id;

    private String name_province;

    public Province(Long id, String name_province) {
        this.id = id;
        this.name_province = name_province;
    }

    public Province(String name_province)
    {
        this.name_province = name_province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_province() {
        return name_province;
    }

    public void setName_province(String name_province) {
        this.name_province = name_province;
    }
}

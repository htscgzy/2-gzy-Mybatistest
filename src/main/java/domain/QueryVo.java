package domain;

public class QueryVo {
    private String name;
    private String address;

    public void setUsername(String username) {
        this.name = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

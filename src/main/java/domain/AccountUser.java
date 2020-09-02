package domain;

import java.util.Date;

public class AccountUser {
    private Integer id;
    private Account account;
    private User user;

    public AccountUser(){
        this.account = new Account();
        this.user = new User();
    }

    public Integer getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getUid(){
        return account.getUid();
    }

    public Double getMoney(){
        return account.getMoney();
    }

    public String getUsername(){
        return user.getUsername();
    }

    public String getAddress(){
        return user.getAddress();
    }

    public Date getBirthday(){
        return user.getBirthday();
    }

    public String getSex(){
        return user.getSex();
    }

    public void setUid(Integer uid){
        account.setUid(uid);
    }

    public void setMoney(Double money){
        account.setMoney(money);
    }

    public void setUsername(String username){
        user.setUsername(username);
    }

    public void setAddress(String address){
        user.setAddress(address);
    }

    public void setBirthday(Date birthday){
        user.setBirthday(birthday);
    }

    public void setSex(String sex){
        user.setSex(sex);
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + id +
                ", account=" + account +
                ", user=" + user +
                '}';
    }
}

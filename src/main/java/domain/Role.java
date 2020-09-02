package domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {

    private Integer roleId;
    private String roleName;
    private String roleDesc;

    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }

    public List<User> getUsers() {
        return users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}

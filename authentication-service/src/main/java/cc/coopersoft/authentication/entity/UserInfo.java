package cc.coopersoft.authentication.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public class UserInfo {

    @Id
    @Column(nullable = false, unique = true)
    @NotBlank
    @Size(max = 32)
    private String username;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 64)
    private String password;

    @Column(nullable = false)
    @NotBlank
    @Size(max = 32)
    private String name;

    @Column(nullable = false)
    private boolean enabled;

    @Email
    @Size(max = 32)
    private String email;

    @Size(max = 16)
    @NotBlank
    private String phone;

    @Size(max = 32)
    private String org;

    public UserInfo() {
    }

    public UserInfo(UserInfo userInfo) {
        this.username = userInfo.getUsername();
        this.password = userInfo.getPassword();
        this.name = userInfo.getName();
        this.enabled = userInfo.isEnabled();
        this.email = userInfo.getEmail();
        this.phone = userInfo.getPhone();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


    public boolean isAccountNonExpired() {
        return true;
    }


    public boolean isAccountNonLocked() {
        return true;
    }


    public boolean isCredentialsNonExpired() {
        return true;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public boolean isEnabled() {
        return this.enabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}

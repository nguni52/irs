package com.irs.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author nguni52
 */
@Entity
@Table(name="authorities")
public class Authority implements Serializable {
    @Id
    @Column(name="username", unique=true, nullable=false)
    private String username; 
    @Column(name="authority", nullable=false)
    private String authority;
    @OneToOne
    @PrimaryKeyJoinColumn
    User user;

    public Authority() {}
    
    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Authority{" + "username=" + username + ", authority=" + authority + ", user=" + user + '}';
    }
    
}
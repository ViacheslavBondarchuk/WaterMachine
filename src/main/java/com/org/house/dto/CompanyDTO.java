package com.org.house.dto;

import com.org.house.entity.Automatic;
import com.org.house.entity.User;

import java.util.Set;

public interface CompanyDTO {

    public int getId();

    public void setId(int id);

    public String getName();

    public void setName(String name);

    public String getEmail();

    public void setEmail(String email);

    public String getPassword();

    public void setPassword(String password);

    public Set<Automatic> getAutomatics();

    public void setAutomatics(Set<Automatic> automatics);

    public User getUser();

    public void setUser(User user);
}

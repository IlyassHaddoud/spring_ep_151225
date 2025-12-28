package org.inetum.episode_151225.dto;

public class UserResponse {
    private String name;
    private String email;

    public String getEmail()
    {
        return this.email;
    }
    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}

package com.apps.szpansky.gitsearch.dataStructure;

import java.util.Objects;

public class Owner extends DataStructure {

    private String login;
    private String avatar_url;


    public Owner(long id, String login, String avatarUrl) {
        this.login = login;
        this.avatar_url = avatarUrl;
        super.setId(id);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatar_url = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equals(login, owner.login) &&
                Objects.equals(avatar_url, owner.avatar_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, avatar_url);
    }
}

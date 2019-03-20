package com.apps.szpansky.gitsearch.dataStructure;

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
}

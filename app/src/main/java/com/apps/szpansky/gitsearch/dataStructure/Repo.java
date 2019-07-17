package com.apps.szpansky.gitsearch.dataStructure;

import java.util.Objects;

public class Repo extends DataStructure {

    private String name;
    private String html_url;
    private Owner owner;
    private String stargazers_count;
    private String language;


    public String getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(String stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Repo(int id, String name) {
        this.name = name;
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Repo repo = (Repo) o;
        return Objects.equals(name, repo.name) &&
                Objects.equals(html_url, repo.html_url) &&
                Objects.equals(owner, repo.owner) &&
                Objects.equals(stargazers_count, repo.stargazers_count) &&
                Objects.equals(language, repo.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, html_url, owner, stargazers_count, language);
    }
}

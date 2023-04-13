package com.store.store.model;
import javax.persistence.*;

@Entity
@Table(name = "AuthorInfo")
public class AuthorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autId")
    private Integer autId;
@Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
    @Column(name = "bio")
    private String bio;
    @Column(name = "autPublisher")
    private String autPublisher;

    public AuthorInfo(String firstName, String lastName, String bio, String autPublisher){
        this.firstName =firstName;
        this.lastName = lastName;
        this.bio =bio;
        this.autPublisher =autPublisher;
    }

    public AuthorInfo() {

    }

    public Integer getAutId(){
        return autId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAutPublisher() {
        return autPublisher;
    }

    public void setAutPublisher(String autPublisher) {
        this.autPublisher = autPublisher;
    }
}
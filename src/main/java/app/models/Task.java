package app.models;

import javax.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private Integer timer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    public Task(Long id, String text, Integer timer, User author) {
        this.id = id;
        this.text = text;
        this.timer = timer;
        this.author = author;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getTimer() {
        return timer;
    }

    public void setTimer(Integer timer) {
        this.timer = timer;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAuthorName(){
        return author!=null ? author.getUsername() :"<none>";
    }
}

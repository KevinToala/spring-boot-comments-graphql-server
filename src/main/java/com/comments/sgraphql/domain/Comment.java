package com.comments.sgraphql.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "comments")
public class Comment {
    private UUID id;
    private String content;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    @Column(name = "content", nullable = false)
    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}

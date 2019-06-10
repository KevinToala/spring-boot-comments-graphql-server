package com.comments.sgraphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.comments.sgraphql.domain.Comment;
import com.comments.sgraphql.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Query implements GraphQLQueryResolver {
    private final CommentRepository commentRepository;

    @Autowired
    public Query(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Iterable<Comment> allComments(){
        return commentRepository.findAll();
    }

    public Comment getComment(UUID id){
        return commentRepository.findById(id)
                .orElse(null);
    }
}
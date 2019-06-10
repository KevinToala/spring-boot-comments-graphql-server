package com.comments.sgraphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.comments.sgraphql.domain.Comment;
import com.comments.sgraphql.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private final CommentService commentService;

    @Autowired
    public Mutation(CommentService commentService){
        this.commentService = commentService;
    }

    public Comment saveComment(String content){
        Comment comment = new Comment();
        comment.setContent(content);

        commentService.save(comment);

        return comment;
    }
}
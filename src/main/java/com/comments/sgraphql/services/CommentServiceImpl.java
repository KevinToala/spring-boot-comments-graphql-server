package com.comments.sgraphql.services;

import com.comments.sgraphql.domain.Comment;
import com.comments.sgraphql.repositories.CommentRepository;
import com.comments.sgraphql.resolvers.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final Subscription subscription;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, Subscription subscription){
        this.commentRepository = commentRepository;
        this.subscription = subscription;
    }

    @Override
    public Comment save(Comment comment){
        commentRepository.save(comment);
        subscription.onNextSaveComment(comment);

        return comment;
    }
}

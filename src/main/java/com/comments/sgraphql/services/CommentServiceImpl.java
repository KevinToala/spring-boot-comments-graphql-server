package com.comments.sgraphql.services;

import com.comments.sgraphql.domain.Comment;
import com.comments.sgraphql.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment comment){
        commentRepository.save(comment);

        return comment;
    }
}

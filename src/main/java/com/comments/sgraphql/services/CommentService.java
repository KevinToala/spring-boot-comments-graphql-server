package com.comments.sgraphql.services;

import com.comments.sgraphql.domain.Comment;

public interface CommentService {
    Comment save(Comment comment);
}

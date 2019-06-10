package com.comments.sgraphql.repositories;

import com.comments.sgraphql.domain.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CommentRepository extends CrudRepository<Comment, UUID> {
}

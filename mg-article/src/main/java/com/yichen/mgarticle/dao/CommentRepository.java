package com.yichen.mgarticle.dao;

import com.yichen.mgarticle.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
    Page<Comment> findCommentByParentid(String parentid, Pageable pageable);
}

package com.yichen.mgarticle;

import com.yichen.mgarticle.Service.CommentService;
import com.yichen.mgarticle.po.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;


@SpringBootTest
class MgArticleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private CommentService service;

    @Test
    public void testFindAll(){
        Comment commentById = service.findCommentById("2");
        System.out.println(commentById);
    }

    @Test
    void findCommentListByParentid(){
        Page<Comment> page = service.findCommentListByParentid("3", 1, 2);
        System.out.println(page.getContent());
    }

    @Test
    void findupdateCommentLicknum(){
        service.updateCommentLicknum("2");
    }

}

package com.projectagile.webprojectagile.service.impl;

import com.projectagile.webprojectagile.dao.ForumCommentDao;
import com.projectagile.webprojectagile.entity.ForumComment;
import com.projectagile.webprojectagile.service.ForumCommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForumCommentServiceImpl implements ForumCommentService {

    ForumCommentDao forumCommentDao;

    @Override
    public List<ForumComment> findCommentBySubjectId(int id) {
        return this.forumCommentDao.findCommentBySubjectId(id);
    }

    @Override
    public ForumComment findForumCommentById(int id) {
        return this.forumCommentDao.findById(id).get();
    }

    @Override
    public ForumComment insertForumComment(ForumComment forumComment) {
        forumComment.setDateComment(new Date());
        return this.forumCommentDao.save(forumComment);
    }

    @Override
    public ForumComment updateForumComment(ForumComment forumComment) {
        ForumComment forumComment1 = this.forumCommentDao.findById(forumComment.getId()).get();
        forumComment1.setText(forumComment.getText());
        return this.forumCommentDao.save(forumComment1);
    }

    @Override
    public void deleteForumCommentById(int id) {
        this.forumCommentDao.deleteById(id);
    }
}

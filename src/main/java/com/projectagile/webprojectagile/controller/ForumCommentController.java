package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Enterprise;
import com.projectagile.webprojectagile.entity.ForumComment;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.ForumCommentServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.ForumCommentReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controleur recoit les requetes du front et renvoie des réponses
 * Ici : reception des requetes relatives aux commentaires sur les sujets du forum
 */

@RestController
@RequestMapping("/forum/comment")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ForumCommentController {

    ForumCommentServiceImpl forumCommentService;

    @PostMapping("/find-all-comments-by-subject/{subjectId}")
    public BaseResVO findAllCommentsBySubject(@PathVariable int subjectId){
        List<ForumComment> commentList = this.forumCommentService.findCommentBySubjectId(subjectId);
        if(commentList != null){
            return ResultVOUtils.success(commentList);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/add-forum-comment")
    public BaseResVO addComments(@RequestBody ForumCommentReqVO forumCommentReqVO){
        ForumComment forumComment = this.forumCommentService.insertForumComment(forumCommentReqVO.getForumComment());
        if(forumComment != null){
            return ResultVOUtils.success(forumComment);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/update-comment")
    public BaseResVO updateComments(@RequestBody ForumCommentReqVO forumCommentReqVO){
        ForumComment forumComment = this.forumCommentService.updateForumComment(forumCommentReqVO.getForumComment());
        if(forumComment != null){
            return ResultVOUtils.success(forumComment);
        } else {
            return ResultVOUtils.error();
        }
    }

    @PostMapping("/delete-forum-comment/{id}")
    public BaseResVO deleteCommentsById(@PathVariable int id){
        this.forumCommentService.deleteForumCommentById(id);
        return ResultVOUtils.success(null);
    }

}

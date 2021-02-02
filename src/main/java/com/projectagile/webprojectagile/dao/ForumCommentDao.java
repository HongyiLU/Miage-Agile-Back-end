package com.projectagile.webprojectagile.dao;

import com.projectagile.webprojectagile.entity.ForumComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Le Data Access Object sert à gérer la communication (CRUD) avec la BDD
 * CrudRepository est une interface qui prédéfinit des fonctions basique pour le CRUD
 * On lui passe la classe de l'entité et le type de la PK de l'entité
 */

public interface ForumCommentDao extends CrudRepository<ForumComment, Integer> {

    //Requete générée automatiquement par Hibernate
    //Equivalent à : @Query(value = "Select * from forum_comment as fc where fc.subject_id = ?1", nativeQuery = true)
    List<ForumComment> findCommentBySubjectId(int subjectId);
}

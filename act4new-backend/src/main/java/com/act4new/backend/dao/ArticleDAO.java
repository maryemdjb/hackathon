package com.act4new.backend.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.act4new.backend.model.Article;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleDAO extends JpaRepository<Article,Long>{

    public List<Article> findAll ();
    @Query("select u from Article u where u.location = ?1 and u.dispo = true ")
    public List<Article> findbyLocation (String location);

}

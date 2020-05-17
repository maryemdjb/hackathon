package com.act4new.backend.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.act4new.backend.model.Image;

public interface ImageDAO extends JpaRepository<Image,Long>{

}

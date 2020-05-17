package com.act4new.backend.service;

import java.io.*;
import java.util.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.act4new.backend.dao.ArticleDAO;
import com.act4new.backend.dao.ImageDAO;
import com.act4new.backend.dto.ArticleDTO;
import com.act4new.backend.model.Article;
import com.act4new.backend.model.Image;

@Service
public class ArticleService {
	
	private ArticleDAO articleDAO;
    private ImageDAO imageDAO;
	private byte[] capture_;
	//private Map<Long, Image> list_images;
	private List<Image> list_images;
	
	@Autowired
	public ArticleService(ArticleDAO articleDAO, ImageDAO imageDAO, byte[] capture_, List<Image> list_images) {
		super();
		this.articleDAO = articleDAO;
       this.imageDAO= imageDAO;
		this.list_images = list_images;
		this.capture_=capture_;
	}
	
	public String addArticle(Article article) {
		article.setDispo(false);
		article.setImages(list_images);
		articleDAO.save(article);
		list_images.clear();
		return "article added!";
	}

	public byte[] addCapture(MultipartFile file) throws IOException {
		byte[] byteObjects = new byte[file.getBytes().length];
        int i = 0;
        for (byte b : file.getBytes()){
            byteObjects[i++] = b;
        }
        capture_ =byteObjects ;
        System.out.println(capture_);
        Image image = new Image(capture_);
        System.out.println(image.getCapture());
        imageDAO.save(image);
        list_images.add(image);
//        list_images.put(image.getId(), image);
        return byteObjects;
	}

	public List<Article> getAll (){
        return articleDAO.findAll();

    }

    public List<Article> getbyLocation(String loc){
        return  articleDAO.findbyLocation(loc);
    }

    @Transactional
    public void renderImage(Long id, HttpServletResponse response) throws IOException {
        Image image = imageDAO.getOne(id);

        response.setHeader("Content-Disposition", "inline;filename=image");

        if(image == null) {
            // if this ticket doesn't have any photo
            System.out.println("no capture found");
        } else {

            // else display the photo by writing the byte array to the response.
            OutputStream out = response.getOutputStream();
            response.setContentLength(image.getCapture().length);
            IOUtils.copy( new ByteArrayInputStream(image.getCapture()), out);
            out.flush();
            out.close();
        }
    }
    
    public String updateArticle(Long id, ArticleDTO new_article) {
    	if (articleDAO.findById(id).isPresent()){
            Article existing = articleDAO.findById(id).get();
            existing.setDescription(new_article.getDescription());
            existing.setPrix(new_article.getPrix());
            existing.setLocation(new_article.getLocation());
            existing.setImages(list_images);
            articleDAO.save(existing);
            list_images.clear();
            return "updated!";
        }else {
            return "not found!";
        }
    }

    @Transactional
    public void deleteCapture(Long idA, Long idImg) throws IOException {
    	if (articleDAO.existsById(idA)) {
    		Article existingArticle = articleDAO.findById(idA).get();
    		List<Image> images = existingArticle.getImages();
    		System.out.println(images.size());
    		for (int i=0; i<images.size(); i++) {
    			if (images.get(i).getId() == idImg) {
    				existingArticle.getImages().remove(images.get(i));
    				articleDAO.save(existingArticle);
    				imageDAO.deleteById(idImg);
    			}
    		}
    	}
	}
    
    @Transactional
	public Optional<Article> getArticleById(Long id) {
		return articleDAO.findById(id);
	}
    
//  @Transactional
//	 public void renderImage(Long id, HttpServletResponse response) throws IOException {
//	      Article article = articleDAO.getOne(id);
//	      response.setHeader("Content-Disposition", "inline;filename=" +article.getNom()+ "");
//	      
//	      if(article.getImages().size() == 0) {
//	          // if this ticket doesn't have any photo
//	          System.out.println("no images found");
//	      } else {
//	          // else display the photo by writing the byte array to the response.
//	          for (Image image : article.getImages()) {
//	          	OutputStream out = response.getOutputStream();
//	              response.setContentLength(image.getCapture().length);
//	          	IOUtils.copy(new ByteArrayInputStream(image.getCapture()), out);
//	              out.flush();
//	              out.close();
//	          }
//	      }
//	  }
}

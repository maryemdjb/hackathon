package com.act4new.backend.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
import com.act4new.backend.dto.ArticleDTO;
import com.act4new.backend.model.Article;
import com.act4new.backend.service.ArticleService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("article")
public class ArticleController {

	private ArticleService articleService;
	
	@Autowired
	public ArticleController(ArticleService articleService, byte[] capture_) {
		super();
		this.articleService = articleService;
	}
	
	@PostMapping("/deposer")
	public String addArticle(@Valid @NotNull @RequestBody Article article) {
		return articleService.addArticle(article);
	}
	
	@PostMapping("/deposer/image")
	public byte[] addCapture(@RequestParam("file") MultipartFile file) throws IOException {
		return articleService.addCapture(file);
	}
	
	@GetMapping("/renderImages/{id}")
    public void renderImages(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
		articleService.renderImage(id, response);
	}
	
	@GetMapping(path ="/{id}")
	public Optional<Article> getArticleBYid(@PathVariable("id")Long id){
		return articleService.getArticleById(id);
	}

	@GetMapping("/all")
    public String getAll(){

       List<Article> a = articleService.getAll();
       System.out.println(a.get(0).getLocation()+"ccccccccccc");
       String json = new Gson().toJson(a );
       return  json;
    }

    @GetMapping("/location/{location}")
    public List<Article> getlocation(@PathVariable("location") String location){

        return articleService.getbyLocation(location);
    }
    
    @PutMapping("/update/{id}")
    public void updateArticle(@PathVariable("id") Long id, @Valid @NotNull @RequestBody ArticleDTO new_article) {
    	articleService.updateArticle(id, new_article);
    }
    
    @DeleteMapping("/delete/image/{idArticle}/{idImg}")
	public void updateCapture(@PathVariable("idArticle") Long idA,
			@PathVariable("idImg") Long idImg) throws IOException {
		articleService.deleteCapture(idA, idImg);
	}



}

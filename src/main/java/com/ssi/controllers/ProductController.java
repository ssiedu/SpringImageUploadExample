package com.ssi.controllers;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.dao.ProductDAO;
import com.ssi.entities.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping("viewall")
	public ModelAndView showAllProducts(){
		
		List<Product> products=productDAO.getAllProducts();
		ModelAndView mv=new ModelAndView("productlist");
		mv.addObject("products",products);
		return mv;
	}
	
	@RequestMapping("loadImage")
	public void showImage(@RequestParam("pcode") int pcode, HttpServletResponse response ){
		
		Product product=productDAO.searchById(pcode);
		Blob blob=product.getPhoto();
		try{
		byte b[]=blob.getBytes(1, (int)blob.length());
		ServletOutputStream out=response.getOutputStream();
		out.write(b);
		out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	

	@RequestMapping("searchproduct")
	public ModelAndView showProductDetails(@RequestParam("pcode") int pcode){
		
		Product product=productDAO.searchById(pcode);
		ModelAndView mv=new ModelAndView("productdetails");
		mv.addObject("product", product);
		return mv;
		
	}
	@RequestMapping("search")
	public String searchProduct(){
		return "searchform";
	}
	@RequestMapping("saveproduct")
	public ModelAndView saveProductData(@ModelAttribute("product") Product product, @RequestParam("f1") MultipartFile file){
		
		try {
			byte b[]=file.getBytes();
			Blob blob=BlobProxy.generateProxy(b);
			product.setPhoto(blob);
			productDAO.saveProduct(product);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ModelAndView mv=new ModelAndView("success");
		return mv;
	}
	
	@RequestMapping("newproduct")
	public String showProductEntryForm(){
		return "productentry";
	}
}

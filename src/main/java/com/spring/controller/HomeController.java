package com.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.dao.WishDAO;
import com.spring.entities.WishEntity;

@Controller
public class HomeController {

//	@Autowired
//	ServletContext context;

	@Autowired
	WishDAO wishDao;

	@RequestMapping("/home")
	public String home(Model m) {
		m.addAttribute("page", "home");
		return "home";
	}

	@RequestMapping("/add")
	public String add(Model m) {
		WishEntity wishEntity = new WishEntity();
		m.addAttribute("page", "add");
		m.addAttribute("wishEntity", wishEntity);
		return "home";
	}

	@RequestMapping(value = "/savewish", method = RequestMethod.POST)
	public String saveWish(@ModelAttribute("wishEntity") WishEntity wishEntity, Model m) {
		wishEntity.setWishDate(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

//		@SuppressWarnings("unchecked")
//		List<WishEntity> allWishArrayList = (ArrayList<WishEntity>) context.getAttribute("allWish");
//		allWishArrayList.add(wishEntity);
//		context.setAttribute("allWish", allWishArrayList);
		wishDao.addWish(wishEntity);
		List<WishEntity> allWishArrayList = wishDao.getAllWish();
		m.addAttribute("allWishes", allWishArrayList);
		System.out.println(allWishArrayList);
		m.addAttribute("page", "viewwishes");
		return "home";
	}

	@RequestMapping(value = "/savewish", method = RequestMethod.GET)
	public String viewWishes(Model m) {
		m.addAttribute("page", "viewwishes");
//		@SuppressWarnings("unchecked")
//		List<WishEntity> allWishArrayList = (ArrayList<WishEntity>) context.getAttribute("allWish");
		List<WishEntity> allWishArrayList = wishDao.getAllWish();
		m.addAttribute("allWishes", allWishArrayList);
		return "home";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public RedirectView deleteWish(@PathVariable("id") int id,HttpServletRequest req) {
		wishDao.deleteWish(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(req.getContextPath() + "/savewish");
		return redirectView;
	}
}

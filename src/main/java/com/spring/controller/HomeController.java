package com.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.entities.WishEntity;

@Controller
public class HomeController {

	@Autowired
	ServletContext context;

	@RequestMapping("/home")
	public String home(Model m) {
		String pageString = "home";
		m.addAttribute("page", pageString);
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

		@SuppressWarnings("unchecked")
		List<WishEntity> allWishArrayList = (ArrayList<WishEntity>) context.getAttribute("allWish");
		if (allWishArrayList == null) {
			allWishArrayList = new ArrayList<WishEntity>();
		}
		allWishArrayList.add(wishEntity);
		context.setAttribute("allWish", allWishArrayList);
		m.addAttribute("allWishes", allWishArrayList);
		System.out.println(allWishArrayList);
		m.addAttribute("page", "viewwishes");
		return "home";
	}

	@RequestMapping(value = "/savewish", method = RequestMethod.GET)
	public String viewWishes(Model m) {
		m.addAttribute("page", "viewwishes");
		@SuppressWarnings("unchecked")
		List<WishEntity> allWishArrayList = (ArrayList<WishEntity>) context.getAttribute("allWish");
		m.addAttribute("allWishes", allWishArrayList);
		return "home";
	}
}

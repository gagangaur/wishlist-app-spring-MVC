package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.spring.entities.WishEntity;

@Component
public class WishDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addWish(WishEntity wishEntity) {
		this.hibernateTemplate.save(wishEntity);
	}
	
	public List<WishEntity> getAllWish() {
		List<WishEntity> wishes = this.hibernateTemplate.loadAll(WishEntity.class);
		return wishes;
	}
	
	@Transactional
	public void deleteWish(int id) {
		WishEntity wish = this.hibernateTemplate.get(WishEntity.class, id);
		this.hibernateTemplate.delete(wish);
	}
	
}

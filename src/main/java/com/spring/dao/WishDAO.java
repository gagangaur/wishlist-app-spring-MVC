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

//	adding wish to db
	@Transactional
	public void addWish(WishEntity wishEntity) {
		this.hibernateTemplate.save(wishEntity);
	}

//	retrieving all wishes from db
	public List<WishEntity> getAllWish() {
		List<WishEntity> wishes = this.hibernateTemplate.loadAll(WishEntity.class);
		return wishes;
	}

//	deleting a wish from db
	@Transactional
	public void deleteWish(int id) {
		WishEntity wish = this.hibernateTemplate.get(WishEntity.class, id);
		this.hibernateTemplate.delete(wish);
	}

//	retrieving a wish from db
	public WishEntity getWish(int id) {
		WishEntity wishEntity = this.hibernateTemplate.get(WishEntity.class, id);
		return wishEntity;
	}

//	updating a wish in db
	@Transactional
	public void updateWish(WishEntity wish) {
		this.hibernateTemplate.saveOrUpdate(wish);
	}
}

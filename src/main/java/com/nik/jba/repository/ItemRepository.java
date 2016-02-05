package com.nik.jba.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nik.jba.entity.Blog;
import com.nik.jba.entity.Item;

@Repository
@Qualifier("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog,Pageable page);

}

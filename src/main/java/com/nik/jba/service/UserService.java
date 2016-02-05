package com.nik.jba.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nik.jba.entity.Blog;
import com.nik.jba.entity.Item;
import com.nik.jba.entity.User;
import com.nik.jba.repository.BlogRepository;
import com.nik.jba.repository.ItemRepository;
import com.nik.jba.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository; 
	
	public List<User> findAll(){
	List<User> users=userRepository.findAll();
	User u=	users.get(0);
		System.out.print(u.getName());
	
return users;		
	}


	public User save(User user){
		return userRepository.save(user);
		
		
		
	}

	public User findById(int id) {
		return userRepository.findOne(id);
	
	}
	@Transactional
	public User findOneWithBlog(int id){
		User u=findById(id);
		List<Blog> blogs=blogRepository.findByUser(u);
		System.out.println(blogs.get(0).getName());
		for(Blog blog:blogs){
			List<Item> items= itemRepository.findByBlog(blog,new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		u.setBlogs(blogs);
		return u;
		
	}


	public User findBlogByUsername(String username) {
		User u=(User)userRepository.findByName(username);
		return findOneWithBlog(u.getId());
	}
	
}

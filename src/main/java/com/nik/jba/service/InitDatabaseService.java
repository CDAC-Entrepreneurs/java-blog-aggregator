package com.nik.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nik.jba.entity.Blog;
import com.nik.jba.entity.Item;
import com.nik.jba.entity.Role;
import com.nik.jba.entity.User;
import com.nik.jba.repository.BlogRepository;
import com.nik.jba.repository.ItemRepository;
import com.nik.jba.repository.RoleRepository;
import com.nik.jba.repository.UserRepository;

@Transactional
@Service
public class InitDatabaseService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private BlogRepository blogRepository; 
	
	@Autowired 
	private ItemRepository itemRepository; 

	

@PostConstruct
public void init(){

	
	Role roleUser=new Role();
	roleUser.setName("user");
	roleRepository.save(roleUser);

	Role roleAdmin=new Role();
	roleAdmin.setName("admin");
	roleRepository.save(roleAdmin);
	
	User userAdmin=new User();
	userAdmin.setName("admin");
	userAdmin.setEmail("nik.neal91@gmail.com");
	userAdmin.setPassword("admin");
	

	User userUser=new User();
	userUser.setName("user");
	userUser.setEmail("nik.neal911@gmail.com");
	userUser.setPassword("user");
	
	
	
	
	List<Role> roles=new ArrayList<Role>();
	roles.add(roleAdmin);
	roles.add(roleUser);
	userAdmin.setRoles(roles);
		userUser.setRoles(roles);
	userRepository.save(userAdmin);	
	
	
	Blog blogJavavids=new Blog();
	blogJavavids.setName("JavaVids");
	blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
	blogJavavids.setUser(userAdmin);
	blogRepository.save(blogJavavids);
	
	
	
	
	Item item1=new Item();
item1.setTitle("First");
item1.setLink("www.javavids.com");
item1.setDescription("some big description should go here");
item1.setPublishedDate(new Date());
item1.setBlog(blogJavavids);

Item item2=new Item();
item2.setTitle("Second");
item2.setLink("www.pgpacking.com");
item2.setDescription("Rise up dont fall again !!");
item2.setPublishedDate(new Date());
item2.setBlog(blogJavavids);

itemRepository.save(item1);
itemRepository.save(item2);

}
	
	
}

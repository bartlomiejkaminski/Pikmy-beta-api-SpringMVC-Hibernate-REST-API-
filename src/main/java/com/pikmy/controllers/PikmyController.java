package com.pikmy.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pikmy.hibernate.model.Avatar;
import com.pikmy.hibernate.model.Channel;
import com.pikmy.hibernate.model.Pik;
import com.pikmy.hibernate.model.User;
import com.pikmy.hibernate.util.HibernateUtil;

@RestController
public class PikmyController {
	
	public PikmyController(){
		super();
	}
	
	
		SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	    Session session;
	
	    @RequestMapping(value = "/pikmy/user/create", method = RequestMethod.POST)
	    public ResponseEntity<User> createUser(@RequestBody User user) throws MalformedURLException {
		 
	    	session = sessionFactory.getCurrentSession();
	    	try {
	    		session.beginTransaction();
	    		
	        User newUser = new User();
	        newUser.setId(user.getId());
	        newUser.setFirst_name(user.getFirst_name());
	        newUser.setLast_name(user.getLast_name());
	        newUser.setEmail(user.getEmail());
	        newUser.setGender(user.getGender());
	        if(user.getBirthday() != null){
	        newUser.setBirthday(user.getBirthday());
	        }
	        else{
	        	newUser.setBirthday("xxx");
	        }
	        
//	        newUser.setDate(new Date());
	        
	        	session.save(newUser);
	        	session.getTransaction().commit();
	    	}
	    	catch (RuntimeException e) {
	    		session.getTransaction().rollback();
	    	    throw e;
	    	}
	        
	        return new ResponseEntity<User>(user, HttpStatus.CREATED);
	    }
	 
	 @RequestMapping(value = "/pikmy/channel/create", method = RequestMethod.POST)
	    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) throws MalformedURLException {
		       	    
		 session = sessionFactory.getCurrentSession();
	    	try {
	    		session.beginTransaction();
	    		
	    		// Odebranie nazwy i daty kanału wpisanego przez użytkownika
	    		Channel newChannel = new Channel();
		        newChannel.setName_channel(channel.getName_channel());
		        newChannel.setChannel_date(channel.getChannel_date());
	    		
	    		// Sprawdzenie czy kanał istnieje w bazie 
		        List<Channel> listChannel = new ArrayList<Channel>();
		        listChannel = session.createCriteria(Channel.class).list();	        
		        boolean isExsistChannel = false;
		        Integer id_channel = null;
		        Channel channelExist = new Channel();
		        for(Channel ch : listChannel){
		        	if(ch.getName_channel().equals(channel.getName_channel())){
		        		isExsistChannel = true;
		        		id_channel = ch.getId();
		        		channelExist = ch;
		        		break;
		        	}
		        }
		        
		        // Pobranie ID dla uzytkownika w akcji
		        String id_user = channel.getList_users().get(0).getId();
		        
		        // Pobranie użytkownika User znając jego id_user
		        List<User> listUsersAll = new ArrayList<User>();
		        listUsersAll = session.createCriteria(User.class).list();
		        User newUser = new User();
		        for(User us : listUsersAll){
		        	if(us.getId().equals(id_user)){
		        		newUser = us;
		        	}
		        }
		        
		        // Działanie funkcji z warunkami
		        if(isExsistChannel){
		        	List<User> listUsersInChannelExist = new ArrayList<User>();
		        	listUsersInChannelExist = channelExist.getList_users();
		        	listUsersInChannelExist.add(newUser);
		        	channelExist.setList_users(listUsersInChannelExist);
		        	session.update(channelExist);
		        }else{
		        	List<User> newListUsers = new ArrayList<User>();
		        	newListUsers.add(newUser);
		        	newChannel.setList_users(newListUsers);
		        	session.save(newChannel);
		        }
	    		
	        	session.getTransaction().commit();
	    	}
	    	catch (RuntimeException e) {
	    		session.getTransaction().rollback();
	    	    throw e;
	    	}
	        
	        return new ResponseEntity<Channel>(channel, HttpStatus.CREATED);
	    }
	
	 
	    @RequestMapping(value = "/pikmy/pik/add", method = RequestMethod.POST)
	    public ResponseEntity<Pik> createPik(@RequestBody Pik pik) throws MalformedURLException {
		 
	    	session = sessionFactory.getCurrentSession();
	    	try {
	    		session.beginTransaction();
	    		
	    		Pik newPik = new Pik();
	    		newPik.setContent(pik.getContent());
	    		newPik.setPik_date(new Date().toString());
	    		newPik.setId_user(pik.getId_user());
	    		newPik.setId_channel(pik.getId_channel());
	    			        
	        	session.save(newPik);
	        	session.getTransaction().commit();
	    	}
	    	catch (RuntimeException e) {
	    		session.getTransaction().rollback();
	    	    throw e;
	    	}
	        
	        return new ResponseEntity<Pik>(pik, HttpStatus.CREATED);
	    }
	    
		@MessageMapping("/hello")
	    @SendTo("/topic/greetings")
	    public String greeting(String message) throws Exception {
	        Thread.sleep(1000); // simulated delay
	        return "Hello" + message;
	    }
	
}

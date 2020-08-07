package com.SobreMesa.Campus.Riddles.Services;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SobreMesa.Campus.Riddles.entity.Hunter;
import com.SobreMesa.Campus.Riddles.repo.HunterRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final HunterRepository hunterRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("in user details" + username);
		 //Optional<Hunter> userOptional = hunterRepo.findByUsername(username);
		Hunter userOptional = hunterRepo.findByUsername(username);
		 System.out.println("thisis error");
	        //Hunter user = userOptional
	          //      .orElseThrow(() -> new UsernameNotFoundException("No user " +
	            //            "Found with username : " + username));
		 Hunter user;
		 	if (userOptional == null) {
		 		System.out.println("is null");
		 		//user = userOptional
		          //      .orElseThrow(() -> new UsernameNotFoundException("No user " +
		            //            "Found with username : " + username));
		 	}
		 	else
		 	{
		 		System.out.println("is not null");
		 		//user = userOptional
		          //      .orElseThrow(() -> new UsernameNotFoundException("No user " +
		            //            "Found with username : " + username));
		 	}
		 	
	        //System.out.println("this is the user we found: " + userOptional.isPresent());
	        
//	        return new org.springframework.security
//	                .core.userdetails.User(user.getUsername(), user.getPassword(),
//	                user.isEnabled(), true, true,
//	                true, getAuthorities("USER"));
	        
	        return new org.springframework.security
	                .core.userdetails.User(userOptional.getUsername(), userOptional.getPassword(),
	                userOptional.isEnabled(), true, true,
	                true, getAuthorities("USER"));
	}
	
	  private Collection<? extends GrantedAuthority> getAuthorities(String role) {
	        //return Collections.singletonList(new SimpleGrantedAuthority(role));
		  return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	    }

}

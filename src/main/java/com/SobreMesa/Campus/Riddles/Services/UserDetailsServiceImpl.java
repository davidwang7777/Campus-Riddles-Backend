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

import com.SobreMesa.Campus.Riddles.Security.HunterUserDetails;
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
		System.out.println("check 2: " + username);
		Optional<Hunter> userOptional = hunterRepo.findByUsername(username);

		System.out.println("check 3, is value present?" + userOptional.isPresent());
		
		Hunter hunter = userOptional
			.orElseThrow(() -> new UsernameNotFoundException("No user " +
	                        "Found with username : " + username));
	        
	        return new org.springframework.security
	                .core.userdetails.User(hunter.getUsername(), hunter.getPassword(),
	                hunter.isEnabled(), true, true,
	                true, getAuthorities("USER"));
	}
	
	  private Collection<? extends GrantedAuthority> getAuthorities(String role) {
	        //return Collections.singletonList(new SimpleGrantedAuthority(role));
		  return Arrays.asList(new SimpleGrantedAuthority(role));
	    }

}

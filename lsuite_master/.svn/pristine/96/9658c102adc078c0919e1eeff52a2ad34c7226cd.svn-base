package com.lonar.vendor.vendorportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lonar.vendor.vendorportal.model.LtMastUsers;



@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;
    
    public MyUserDetailsService() {
        super();
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Preconditions.checkNotNull(username);

	        final LtMastUsers user = userService.findByUserName(username);
	        user.setEmail(null);
	        //final LtMastUsers user = userDaoImpl.findByUserNameForOauth(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("Username was not found: " + username);
	        }

	        List<String> roleNames = new ArrayList<String>();
	        roleNames.add("ADMIN");
	        
	        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true, true, true,
					getGrantedAuthorities(roleNames.toArray(new String[roleNames.size()])));
		}

		private List<GrantedAuthority> getGrantedAuthorities(String[] roleNames) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (String roleName : roleNames) {
				authorities.add(new SimpleGrantedAuthority(roleName));
			}
			return authorities;
		}
}

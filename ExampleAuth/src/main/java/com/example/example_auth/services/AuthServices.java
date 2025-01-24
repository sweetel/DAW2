package com.example.example_auth.services;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.example_auth.model.entities.UserEntity;
import com.example.example_auth.model.respositories.IUserRepository;
import com.example.example_auth.utils.security.JwtUtil;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class AuthServices implements IAuthServices {
	
	@Autowired
	JwtUtil jwtUtils;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public String login(String name, String password) throws Exception {
		// Comprobamos que con el lombok se genera el getter correctamente
		
		Optional<UserEntity> optionalEntity = userRepository.findByName(name);
		
		if(optionalEntity.isEmpty()) {
			throw new Exception("usuario o contraseña incorrecta");
		}
		
		UserEntity entity = optionalEntity.get();
		
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), entity.getPassword());

		if(!result.verified) {
			throw new Exception("usuario o contraseña incorrecta");
		}
		
		 UserDetails userDetails = loadUserDetails(name);
		
		String token = jwtUtils.generateToken(userDetails.getUsername());
		return token;
	}

	@Override
	public String register(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserDetails(String name) {
	    Optional<UserEntity> optionalUser = userRepository.findByName(name);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User Not Found with username: " + name);
        }
        UserEntity user = optionalUser.get();
        return new org.springframework.security.core.userdetails.User(
                user.getName(),
                user.getPassword(),
                Collections.emptyList()
        );
    }

}

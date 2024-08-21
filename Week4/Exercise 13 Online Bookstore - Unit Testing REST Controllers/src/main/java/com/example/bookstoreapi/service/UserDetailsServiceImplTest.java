package com.example.bookstoreapi.service;

import com.example.bookstoreapi.model.User;
import com.example.bookstoreapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    public UserDetailsServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLoadUserByUsername() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpass");

        Mockito.when(userRepository.findByUsername("testuser")).thenReturn(java.util.Optional.of(user));

        UserDetails userDetails = userDetailsService.loadUserByUsername("testuser");

        assertEquals("testuser", userDetails.getUsername());
    }

    @Test
    public void testLoadUserByUsernameNotFound() {
        Mockito.when(userRepository.findByUsername("unknownuser")).thenReturn(java.util.Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("unknownuser");
        });
    }
}

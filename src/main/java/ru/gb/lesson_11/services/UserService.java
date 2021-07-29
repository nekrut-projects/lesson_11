package ru.gb.lesson_11.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.lesson_11.models.Authority;
import ru.gb.lesson_11.models.User;
import ru.gb.lesson_11.repositories.UserRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public Optional<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUserByName(s).orElseThrow(()-> new UsernameNotFoundException("User with name: " + s + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getName(),
                                                                        user.getPassword(),
                                                                        mapRolesToAuthorities(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities (Collection<Authority> authorities){
        return authorities.stream().map((a)-> new SimpleGrantedAuthority(a.getName())).collect(Collectors.toList());
    }
}

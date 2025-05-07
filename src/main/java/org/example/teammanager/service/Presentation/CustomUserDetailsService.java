package org.example.teammanager.service.Presentation;

import org.example.teammanager.model.membre.Membre;
import org.example.teammanager.model.membreRoleMembre.MembreRoleMembre;
import org.example.teammanager.repository.membre.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MembreRepository membreRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Membre> membreOptional = membreRepository.findByEmail(email);
        if (membreOptional.isEmpty()) {
            throw new UsernameNotFoundException("Email non trouvé : " + email);
        }

        Membre membre = membreOptional.get();
        Collection<GrantedAuthority> authorities = getAuthorities(membre);

        return new User(membre.getEmail(), membre.getPassword(), authorities);
    }

    private Collection<GrantedAuthority> getAuthorities(Membre membre) {
        List<MembreRoleMembre> roles = membre.getMembreRoleMembres();
        if (roles == null || roles.isEmpty()) {
            return AuthorityUtils.NO_AUTHORITIES; // Aucun rôle
        }
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleMembre().getNomRole()))
                .collect(Collectors.toList());
    }
}
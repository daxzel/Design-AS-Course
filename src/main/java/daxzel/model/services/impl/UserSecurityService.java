package daxzel.model.services.impl;

import daxzel.model.DAO.UserDAO;
import daxzel.model.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: daxzel
 * Date: 4/11/12
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @SuppressWarnings("deprecation")
    public UserDetails loadUserByUsername(String username){

        User user = userDAO.getUserByName(username);

        Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), true, true, true, true,authList);

        }

}

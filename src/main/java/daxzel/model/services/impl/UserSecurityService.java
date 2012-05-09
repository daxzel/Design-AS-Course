package daxzel.model.services.impl;

import daxzel.model.DAO.RoleDAO;
import daxzel.model.DAO.UserDAO;
import daxzel.model.domains.Role;
import daxzel.model.domains.User;
import daxzel.model.services.UserService;
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
    private UserService userService;


    @SuppressWarnings("deprecation")
    public UserDetails loadUserByUsername(String username){

        User user = userService.getUserByName(username);

        String permission = getRolePermissionByName(user.getRole().getName());

        //String roleName = user.getRole().getName();

        user.getRole().getName();

        //String permission = "ROLE_ADMIN";

        Collection<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new GrantedAuthorityImpl(permission));
        
        String password = user.getPassword();

        return new org.springframework.security.core.userdetails.User(user.getName(), password, true, true, true, true,authList);

        }
    
    private String getRolePermissionByName(String name)
    {
        if (name.equals("Администратор")){
            return "ROLE_ADMIN";
        }
        else{
            if (name.equals("Менеджер по продажам")){
                return "ROLE_MANAGER";
            }
            else
            {
                if (name.equals("Директор")){
                    return "ROLE_DIRECTOR";
                }
                else{
                    if (name.equals("Главный бухгалтер")){
                        return "ROLE_ACCOUNTANT";
                    }
                    else
                    {
                        if (name.equals("Экономист")){
                            return "ROLE_ECONOMIST";
                        }
                        else
                        {
                            throw new RuntimeException(name);
                        }
                    }
                }
            }
        }
    }

}

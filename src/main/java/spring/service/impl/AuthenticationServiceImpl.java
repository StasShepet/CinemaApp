package spring.service.impl;

import java.util.HashSet;
import org.springframework.stereotype.Service;
import spring.model.Role;
import spring.model.RoleName;
import spring.model.User;
import spring.service.AuthenticationService;
import spring.service.RoleService;
import spring.service.ShoppingCartService;
import spring.service.UserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        Role role = roleService.getRoleByName(RoleName.USER.name());
        HashSet<Role> rolesSet = new HashSet<>();
        rolesSet.add(role);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(rolesSet);
        userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}

package spring.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import spring.model.Role;
import spring.model.RoleName;
import spring.model.User;
import spring.service.RoleService;
import spring.service.UserService;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(RoleName.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("anna@gmail.com");
        user.setPassword("12345678");
        user.setRoles(Set.of(adminRole));
        userService.add(user);
        User user2 = new User();
        user2.setEmail("bohdan@gmail.com");
        user2.setPassword("87654321");
        user2.setRoles(Set.of(userRole));
        userService.add(user2);
    }
}

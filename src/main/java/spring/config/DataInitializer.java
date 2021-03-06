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
        User firstUser = new User();
        firstUser.setEmail("anna@gmail.com");
        firstUser.setPassword("12345678");
        firstUser.setRoles(Set.of(adminRole));
        userService.add(firstUser);
        User secondUser = new User();
        secondUser.setEmail("bohdan@gmail.com");
        secondUser.setPassword("87654321");
        secondUser.setRoles(Set.of(userRole));
        userService.add(secondUser);
    }
}

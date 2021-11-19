package spring.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import spring.dao.AbstractDao;
import spring.dao.RoleDao;
import spring.exception.DataProcessingException;
import spring.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Role add(Role role) {
        return super.add(role);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> query =
                    session.createQuery("from Role r where r.roleName = :roleName", Role.class);
            return query.setParameter("roleName", roleName).uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can`t get role with name: " + roleName, e);
        }
    }
}

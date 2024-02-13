package com.example.DAO;

import com.example.exeptions.NotFoundException;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        User existingUser = getUserById(user.getId()).orElseThrow(() -> new NotFoundException("User not found"));
        entityManager.detach(existingUser);
        existingUser.setName(user.getName());
        entityManager.merge(existingUser);
    }

    @Override
    public void removeUserById(Long id) {
//        entityManager.remove(getUserById(id));
        getUserById(id).ifPresent(entityManager::remove);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public Optional<User> getUserById(final Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }
}

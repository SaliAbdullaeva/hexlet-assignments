package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> findById(long id) {
        return userRepository.findById(id);
    }

    public Mono<User> createUser(User userData) {
        return userRepository.save(userData);
    }

    public Mono<User> updateUser(long id, User userData) {
        return userRepository.findById(id).flatMap(user -> {
            user.setFirstName(userData.getFirstName());
            user.setLastName(userData.getLastName());
            user.setEmail(userData.getEmail());
            return userRepository.save(user);
        });
    }

    public Mono<Void> deleteUser(long id) {
        return userRepository.deleteById(id);
    }
    // END
}

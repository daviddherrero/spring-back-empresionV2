package tfg.backend.empresion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tfg.backend.empresion.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

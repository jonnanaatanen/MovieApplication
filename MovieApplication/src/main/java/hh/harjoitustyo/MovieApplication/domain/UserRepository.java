package hh.harjoitustyo.MovieApplication.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>  {
	User findByUsername(String username);
	long deleteByUsername(String username);
}

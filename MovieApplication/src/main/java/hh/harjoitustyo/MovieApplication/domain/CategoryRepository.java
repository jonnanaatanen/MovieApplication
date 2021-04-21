package hh.harjoitustyo.MovieApplication.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository <Category, Long>{
	List<Category> findByCname(String cname);
	long deleteByCname(String cname);
}

package test.repository;

import org.springframework.data.repository.CrudRepository;
import test.model.Branch;

public interface BranchRepo extends CrudRepository <Branch, Integer> {

}

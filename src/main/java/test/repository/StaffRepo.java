package test.repository;

import org.springframework.data.repository.CrudRepository;
import test.model.Staff;

public interface StaffRepo extends CrudRepository <Staff, Integer> {

}

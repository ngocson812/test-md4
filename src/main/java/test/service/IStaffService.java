package test.service;

import test.model.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffService {
    public List<Staff> findAll();
    public void save(Staff staff);
    public void delete(int id);
    public Optional<Staff> findById(int id);
    List<Staff> sort();
    List<Staff> reverse();
}

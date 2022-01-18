package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Staff;
import test.repository.StaffRepo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService implements IStaffService{

    @Autowired
    StaffRepo staffRepo;

    @Override
    public List<Staff> findAll() {
        return (List<Staff>) staffRepo.findAll();
    }

    @Override
    public void save(Staff staff) {
        staffRepo.save(staff);
    }

    @Override
    public void delete(int id) {
        staffRepo.deleteById(id);
    }

    @Override
    public Optional<Staff> findById(int id) {
        return staffRepo.findById(id);
    }

    @Override
    public List<Staff> sort() {
        List<Staff> list = findAll();
        list.sort(Comparator.comparing(Staff::getAge));
        return list;
    }

    @Override
    public List<Staff> reverse() {
        List<Staff> list = findAll();
        list.sort(Comparator.comparing(Staff::getAge));
        Collections.reverse(list);
        return list;
    }
}

package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Staff;
import test.repository.StaffRepo;

import java.util.*;

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
    public Staff findByName(String name) {
        for (Staff s : staffRepo.findAll()) {
            if (s.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))) {
                return s;
            }
        }
        return null;
    }

    @Override
    public List<Staff> sortsalary() {
        List<Staff> list = findAll();
        list.sort(Comparator.comparing(Staff::getSalary));
        return list;
    }
    @Override
    public List<Staff> sortage() {
        List<Staff> list = findAll();
        list.sort(Comparator.comparing(Staff::getAge));
        return list;
    }

}

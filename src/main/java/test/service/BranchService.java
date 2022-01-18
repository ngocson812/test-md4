package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.Branch;
import test.repository.BranchRepo;

import java.util.List;

@Service
public class BranchService implements IBranchService{

    @Autowired
    BranchRepo branchRepo;

    @Override
    public List<Branch> findAll() {
        return (List<Branch>) branchRepo.findAll();
    }
}

package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.model.Branch;
import test.model.Staff;
import test.service.IBranchService;
import test.service.IStaffService;

import java.util.List;
import java.util.Optional;

@Controller
public class StaffController {

    @Autowired
    IStaffService staffService;

    @Autowired
    IBranchService branchService;


    @GetMapping("/staff")
    public ModelAndView showAll(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("staff",staffService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("createstaff", new Staff());
        modelAndView.addObject("createbranch",branchService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute(value = "staff") Staff staff, @RequestParam long idBranch){
        Branch newbranch = new Branch();
        newbranch.setIdbranch(idBranch);
        staff.setBranch(newbranch);
        staffService.save(staff);
        return "redirect:/staff";
    }

    @GetMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        Optional<Staff> staff = staffService.findById(id);
        List<Branch> list = branchService.findAll();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("editstaff", staff);
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    @PostMapping("edit/{id}")
    public ModelAndView edit(@ModelAttribute(value = "staff") Staff staff,@RequestParam Long idBranch){
        Branch branch = new Branch();
        branch.setIdbranch(idBranch);
        staff.setBranch(branch);
        staffService.save(staff);
        return new ModelAndView("redirect:/staff");
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteForm(@PathVariable int id){
        Optional<Staff> staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("deletestaff", staff);
        return modelAndView;
    }

    @PostMapping("delete/{id}")
    public ModelAndView delete(@PathVariable int id,@ModelAttribute Staff staff){
        staffService.delete(id);
        return new ModelAndView("redirect:/staff");
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id){
        Optional<Staff> staff = staffService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("detailstaff",staff);
        return modelAndView;
    }

    @PostMapping ("/search")
    public ModelAndView searchByName (@RequestParam String search){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("staff" , staffService.findByName(search));
        return modelAndView;
    }
    @GetMapping ("/sortsalary")
    public ModelAndView sortsalary(){
        ModelAndView modelAndView = new ModelAndView("show");
        List<Staff> sortSalary = staffService.sortsalary();
        modelAndView.addObject("staff",sortSalary);
        return modelAndView;

    }
    @GetMapping ("/sortage")
    public ModelAndView sortage(){
        ModelAndView modelAndView = new ModelAndView("show");
        List<Staff> sortAge = staffService.sortage();
        modelAndView.addObject("staff",sortAge);
        return modelAndView;
    }
}

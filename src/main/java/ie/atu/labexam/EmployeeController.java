package ie.atu.labexam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private List<Employee> myList = new ArrayList<>();

    @GetMapping("/findEmployee/{employeeCode}")
    public List<Employee> getEmployee(){
        return myList;
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee, @PathVariable String email){
        if(myList.contains(email)){
            throw new DuplicateEmailException("Email" + email + "Already exists");
        }
        myList.add(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{employeeCode}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        for(int i = 0; i <employee.size(); i++){
            if(employee.get(i).getId() == id){
                employee.set(i, employee);
            }
        }
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/deleteEmployee/{employeeCode}")
    public ResponseEntity<Employee>removeEmployee(@PathVariable int id, @RequestBody Employee employee){
        for(int count = 0; count <employee.size(); count++){
            if(employee.get(count).getId() == id){
                employee.remove(count);
            }
        }
        return ResponseEntity.ok(employee);
    }

}

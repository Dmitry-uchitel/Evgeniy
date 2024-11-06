package ru.dimas.taskevgeniy.task1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.dimas.taskevgeniy.task1.model.Man;
import ru.dimas.taskevgeniy.task1.repository.ManList;

import java.util.List;

@RestController
@RequestMapping("/man")
public class ManController {

    public ManList manList = new ManList();
    @GetMapping("/{id}")
    public Man showId(@PathVariable int id){
        System.out.println(manList.getMan(id));
        return manList.getMan(id);
    }

    @GetMapping()
    public List<Man> showAllMan(){
        //System.out.println(manList.getMan(id));
        return manList.getManList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addOneMan(@RequestBody Man man){
        manList.addMan(man.getAge(),man.getName());
    }
    @DeleteMapping("/{id}")
    public void deleteOneMan(@PathVariable int id){
        manList.deleteMan(id-1);
    }

    @PutMapping()
    public void updateOneMan(@RequestBody Man man){
        manList.updateMan(man);
    }


}

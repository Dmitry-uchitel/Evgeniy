package ru.dimas.taskevgeniy.task1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.dimas.taskevgeniy.task1.model.Man;
import ru.dimas.taskevgeniy.task1.repository.ManList;

import java.util.List;

@RestController
@RequestMapping("/mans")
public class MansController {

    private final ManList manList;
    public MansController(ManList manList) {
        this.manList = manList;
    }

    @GetMapping("/{id}")
    public Man getMan(@PathVariable int id){
        System.out.println(manList.getMan(id));
        return manList.getMan(id);
    }

    @GetMapping()
    public List<Man> getManList(){
        //System.out.println(manList.getMan(id));
        return manList.getManList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMan(@RequestBody Man man){
        manList.addMan(man);
    }
    @DeleteMapping("/{id}")
    public void deleteMan(@PathVariable int id){
        manList.deleteMan(id-1);
    }

    @PatchMapping("/{id}")
    public void updateMan(@PathVariable int id, @RequestBody Man man){
        manList.updateMan(id, man);
    }


}

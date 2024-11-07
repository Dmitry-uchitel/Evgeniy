package ru.dimas.taskevgeniy.task1.repository;

import org.springframework.stereotype.Component;
import ru.dimas.taskevgeniy.task1.model.Man;

import java.util.ArrayList;
import java.util.List;
@Component
public class ManList {
    private int countMan;
    private List<Man> manList = new ArrayList<>();
    {
        manList.add(new Man(++countMan, 25, "Stas"));
        manList.add(new Man(++countMan, 10, "Anton"));
        manList.add(new Man(++countMan, 16, "Petr"));
        manList.add(new Man(++countMan, 12, "Maxim"));
    }

    public Man getMan(int id){
        return this.manList.stream().filter(man->man.getId()==id).findAny().orElse(null);
    }

    public void addMan(int age, String name){
        manList.add(new Man(++countMan, age, name));
    }

    public List<Man> getManList(){
        return manList;
    }

    public void deleteMan(int id){
        manList.remove(id);
    }
    public void updateMan(int id, Man man){
        id = id-1;
        if (id>=manList.size() || id<0){
            return;
        }
        manList.get(id).setAge(man.getAge());
        manList.get(id).setName(man.getName());
    }


}

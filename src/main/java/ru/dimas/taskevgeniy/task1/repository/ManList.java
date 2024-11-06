package ru.dimas.taskevgeniy.task1.repository;

import ru.dimas.taskevgeniy.task1.model.Man;

import java.util.ArrayList;
import java.util.List;

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
        return this.manList.get(id);
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
    public void updateMan(Man man){
        int id = man.getId()-1;
        if (id>=manList.size() || id<0){
            return;
        }
        manList.get(id).setAge(man.getAge());
        manList.get(id).setName(man.getName());
    }


}

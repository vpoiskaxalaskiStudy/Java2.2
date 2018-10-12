package com.devcolibri.database;

public class Users {
    private int id;
    private String name;
    private int age;

    public Users(){

    }

    public Users(String name,int age){
        this.name=name;
        this.age=age;
    }

    public Users(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

     public int getId(){return id;}

     public void setId(int id) {this.id=id;}

     public String getName() {return name;}

     public void setName(String name) {this.name=name;}

     public int getAge() {return age;}

     public void setAge(int age) {this.age=age;}

     @Override
    public String toString(){
        return getClass().getSimpleName()+"{id:"+id
                +",name:" +name
                +",age:"+age+"}";
     }
}

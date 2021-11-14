package com.zzh.mybatis.DailyStudy.Text;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetStu {
    public static void main(String[] args) {
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate m1 = e1.getBirthday();
                    MyDate m2 = e2.getBirthday();
                    if(m1.getYear() != m2.getYear()){
                        return Integer.compare(m1.getYear(),m2.getYear());
                    }else if(m1.getMonth() != m2.getMonth()){
                        return Integer.compare(m1.getMonth(),m2.getMonth());
                    }else{
                        return Integer.compare(m1.getDay(),m2.getDay());
                    }
                }throw new RuntimeException("输入的数据类型不匹配");
            }
        };
        TreeSet tree = new TreeSet(com);
        tree.add(new Employee("Tom",15,new MyDate(1990,5,20)));
        tree.add (new Employee("Jack",10,new MyDate(1937,7,21)));
        tree.add(new Employee("Candi",25,new MyDate(2000,1,21)));
        tree.add(new Employee("MIKE",5,new MyDate(2021,9,10)));
        tree.add(new Employee("Lebron",38,new MyDate(2000,3,15)));

        System.out.println(tree);
    }
}
class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;
    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee) o;
            if((this.name.compareTo(e.name)) != 0){
                return this.name.compareTo(e.name);
            }else{
                return Integer.compare(this.age,e.age);
            }
        }throw new RuntimeException("输入的数据类型不匹配");
    }
}
class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

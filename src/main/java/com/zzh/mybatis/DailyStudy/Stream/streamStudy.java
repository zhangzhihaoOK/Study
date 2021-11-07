package com.zzh.mybatis.DailyStudy.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streamStudy {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,5,6,9,4,3,7,8);
        //遍历list
        list.stream().forEach(System.out::println);
        //遍历list中 x > 6 的数
        list.stream().filter(x -> x > 4).forEach(System.out::println);
        //找到list中第一个 >6 的值
        Optional<Integer> first = list.stream().filter(x -> x > 4).findFirst();
        System.out.println("匹配的第一个值为  " + first.get());
        //找到list中任意一个 >6 的值
        Optional<Integer> any = list.parallelStream().filter(x -> x > 4).findAny();
        System.out.println("匹配的任意一个值为  " + any.get());
        //是否存在大于10的数
        boolean istrue = list.stream().anyMatch(x -> x > 10);
        System.out.println(istrue);

        String[] arr = {"张三","人称","法外狂徒"};

        Stream arrstream = Arrays.stream(arr);

        arrstream.forEach(System.out::println);


        List<Person> plist = new ArrayList<>();

        plist.add(new Person("张三",26,7800));
        plist.add(new Person("李四",80,8000));
        plist.add(new Person("王五",22,7600));
        plist.add(new Person("赵六",30,8100));
        plist.add(new Person("孙七",18,8900));
        //工资高于7850的员工姓名
        List<String> collect = plist.stream().filter(x -> x.getSalary() > 7850).map(Person::getName).collect(Collectors.toList());
        System.out.println("工资高于7850的员工姓名  " + collect);
        //年龄大于28岁的员工姓名
        List<String> collect1 = plist.stream().filter(x -> x.getAge() > 28).map(Person::getName).collect(Collectors.toList());
        System.out.println("年龄大于28岁的员工姓名  " + collect1);
        //员工工资的最大值
        Optional<Person> maxSl = plist.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资的最大值  " + maxSl.get().getSalary());
        //寻找最长的字符串
        List<String> slist = Arrays.asList("admn","qweasd","asdfqwe","dasdf","qwerts","法外狂徒");

        Optional<String> maxS = slist.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串  " + maxS.get());

        //获取Integer集合中的max
        List<Integer> ilist = Arrays.asList(1,7,5,6,9,8,55,10);
        Optional<Integer> maxI1 = ilist.stream().max(Comparator.naturalOrder());
        System.out.println("Integer集合中最大的值为  " + maxI1.get());
//        Optional<Integer> maxI3 = list.stream().max(Integer::compareTo);
//        System.out.println("自然排序Integer集合中最大的值为  " + maxI3.get());
//        //自定义排序
//        Optional<Integer> maxI2 = ilist.stream().max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//        System.out.println("自定义排序Integer集合中最大的值为  " + maxI2.get());


        //计算员工中年龄大于25的员工个数
        long perNum = plist.stream().filter(x -> x.getAge() > 25).count();
        System.out.println("工中年龄大于25的员工个数  " + perNum);

        //英文字符串数组的元素全部改为大写。
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> UpStr = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(UpStr);

        //整数数组每个元素+3。
        List<Integer> intlist = Arrays.asList(1,3,5,7,9);
//        intlist.stream().map(x -> x + 3).forEach(System.out::println);
        List<Integer> int3 = intlist.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println(int3);

        //将员工的薪资全部增加1000。
        // 不改变原来员工集合的方式
        List<Person> PerAddSa = plist.stream().map(person -> {
                    Person personNew = new Person(person.getName(), 0, 0);
                    personNew.setSalary(person.getSalary() + 1000);
                    return personNew;
                }
        ).collect(Collectors.toList());
        for (int i = 0; i < 5; i++) {
            System.out.println(PerAddSa.get(i).getName() + "加薪前 " + plist.get(i).getSalary() + "加薪后" + PerAddSa.get(i).getSalary());
        }
        // 改变原来员工集合的方式
//        List<Person> PerAddSA = plist.stream().map(person -> {
//            Person personNew = new Person(person.getName(), 0, 0);
//            person.setSalary(person.getSalary() + 1000);
//            return personNew;
//        }).collect(Collectors.toList());
//        for (int i = 0; i < 5; i++) {
//            System.out.println(PerAddSA.get(i).getName() + "  加薪后 " + plist.get(i).getSalary());
//        }

//        将两个字符数组合并成一个新的字符数组。
        List<String> llist = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> NewStr = llist.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> ss = Arrays.stream(split);
            return ss;
        }).collect(Collectors.toList());
        System.out.println(NewStr);

//        求Integer集合的元素之和、乘积和最大值。
        List<Integer> lllist = Arrays.asList(1, 3, 2, 8, 11, 4);
        //求和公式
        Optional<Integer> sum1 = lllist.stream().reduce(Integer::sum);
        System.out.println("lllist的和为 " + sum1.get());

        Optional<Integer> sum2 = lllist.stream().reduce((x, y) -> x + y);
        System.out.println("lllist的和为 " + sum2.get());

        //求乘积
        Optional<Integer> chengji = lllist.stream().reduce((x, y) -> x * y);
        System.out.println("lllist的乘积为 " + chengji.get());

        //求最大值
        Optional<Integer> max2 = lllist.stream().max(Comparator.naturalOrder());
        System.out.println("lllist的最大值为 " + max2.get());

        Integer max3 = lllist.stream().reduce(1, Integer::max);
        System.out.println("lllist的最大值为 " + max3);

        //求所有员工的工资之和
        Optional<Integer> sumSA = plist.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("所有员工的工资之和为  " + sumSA.get());

        //求员工的最大工资
        //方法一
        Integer max4 = plist.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), Integer::max);
        System.out.println("员工的最大工资为  " + max4);
        //方法二
        Integer max8 = plist.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(), (max6, max7) -> max6 > max7 ? max6 : max7);
        System.out.println("员工的最大工资为  " + max8);

        //归集  collect
        List<Integer> llllist = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        //将偶数弄到一个集合中  toList  toSet
        List<Integer> ouList = llllist.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(ouList);
        Set<Integer> setList = llllist.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        System.out.println(setList);

//        plist.add(new Person("张三",26,7800));
//        plist.add(new Person("李四",80,8000));
//        plist.add(new Person("王五",22,7600));
//        plist.add(new Person("赵六",30,8100));
//        plist.add(new Person("孙七",18,8900));
        //将工资大于8000的分到一个集合中
        Map<?,Integer> perMap = plist.stream().filter(p -> p.getSalary() > 8000).collect(Collectors.toMap(Person::getName,p -> p.getSalary()));
        System.out.println("工资大于8000的人为  " + perMap);

        //统计  collect
        //plist中共有多少人
        Long count = plist.stream().collect(Collectors.counting());
        System.out.println("plist中共有" + count + "人");

        //求平均工资
        Double AvgSa = plist.stream().collect(Collectors.averagingDouble(Person::getSalary));
        System.out.println("平均工资为  " + AvgSa);

        //求最高工资
        Optional<Integer> maxSA = plist.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compareTo));
        System.out.println("最高工资为  " + maxSA.get());

        //求工资之和
        Integer sumSa = plist.stream().collect(Collectors.summingInt(Person::getSalary));
        System.out.println("工资之和为  " + sumSa);

        // 一次性统计信息  有关工资的最大最小值 平均值 综合 个数
        DoubleSummaryStatistics all = plist.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println(all);

        System.out.println();
//        分组  collect
//        分区：将stream按条件分为两个Map
//        分组：将集合分为多个Map，比如员工按性别分组。有单级分组和多级分组。
//        员工按薪资是否高于8000分为两部分
        System.out.println("员工薪资是否高于8000");
        Map<Boolean, List<Person>> isUp8 = plist.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        isUp8.forEach((k,v) ->System.out.println( k + " " + v.stream().map(p -> p.getName()).collect(Collectors.joining(","))));//false 张三,李四,王五   true 赵六,孙七
//        isUp8.forEach((k,v) ->System.out.println( k + " " + v.stream().map(p -> p.getName()).collect(Collectors.toList())));//false [张三, 李四, 王五]  true [赵六, 孙七]

        System.out.println();

        //员工年龄是否大于25
        System.out.println("员工年龄是否大于25");
        Map<Boolean, List<Person>> isUp25 = plist.stream().collect(Collectors.groupingBy(x -> x.getAge() > 25));
        isUp25.forEach((k,v) -> System.out.println(k + "  " + v.stream().map(Person::getName).collect(Collectors.joining(","))));

        // 将员工先按年龄分组，再按工资分组
        Map<Boolean, Map<Boolean, List<Person>>> AgeSa = plist.stream().collect(Collectors.partitioningBy(p -> p.getAge() > 25, Collectors.groupingBy(p -> p.getSalary() > 8000)));
        System.out.println(AgeSa);

        //归约(reducing)
        //Collectors类提供的reducing方法，相比于stream本身的reduce方法，增加了对自定义归约的支持。
        //每个员工减去起征点后的薪资之和  起征点为5000
        Integer sa5k = plist.stream().collect(Collectors.reducing(0, Person::getSalary, (x, y) -> (x + y - 5000)));
        //Integer sa5k = plist.stream().map(Person::getSalary).reduce(0, (x, y) -> (x + y - 5000));
        System.out.println("每个员工减去起征点后的薪资之和  " + sa5k);

        //排序(sorted)
        //sorted()：自然排序，流中元素需实现Comparable接口
        //sorted(Comparator com)：Comparator排序器自定义排序
        //将员工按工资由低到高（工资一样则按年龄由大到小）排序
        List<String> SaSort = plist.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        System.out.println("按工资升序排序：" +SaSort);
        //将员工按工资由高到低排序
        List<String> reSaSort = plist.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(Person::getName).collect(Collectors.toList());
        System.out.println("按工资降序排序：" +reSaSort);

        List<Person> pplist = new ArrayList<>();
        pplist.add(new Person("张三",26,7800));
        pplist.add(new Person("李四",80,8000));
        pplist.add(new Person("王五",22,7600));
        pplist.add(new Person("赵六",30,8100));
        pplist.add(new Person("孙七",18,8900));
        pplist.add(new Person("小二",20,7800));
        pplist.add(new Person("周九",21,7600));
        // 先按工资再按年龄升序排序
        List<String> SaAge = pplist.stream().sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName).collect(Collectors.toList());
        System.out.println("先按工资再按年龄升序排序：" + SaAge);

        // 先按工资再按年龄自定义排序（降序）
//        List<String> reSaAge = pplist.stream().sorted((p1, p2) -> {
//            if (p1.getSalary() == p2.getSalary()) {
//                return p2.getAge() - p1.getAge();
//            } else {
//                return p2.getSalary() - p1.getSalary();
//            }
//        }).map(Person::getName).collect(Collectors.toList());
//        System.out.println("先按工资再按年龄自定义降序排序：" + reSaAge);


    //流也可以进行合并、去重、限制、跳过等操作。
    String[] arr1 = { "a", "b", "c", "d" };
    String[] arr2 = { "d", "e", "f", "g" };
    Stream<String> stream1 = Stream.of(arr1);
    Stream<String> stream2 = Stream.of(arr2);
    // concat:合并两个流 distinct：去重
    List<String> DistinctList = Stream.concat(stream1,stream2).distinct().collect(Collectors.toList());
    //List<String> DistinctList = Stream.concat(stream1,stream2).distinct().limit(4).collect(Collectors.toList());
    System.out.println("去重后  " + DistinctList);

    // limit：限制从流中获得前n个数据
    List<Integer> LimitList = Stream.iterate(1,x->x+2).limit(10).collect(Collectors.toList());
    System.out.println("limit " + LimitList);

    // skip：跳过前n个数据   从第n个开始
    List<Integer> SkipList = Stream.iterate(3, x -> x + 2).skip(1).limit(8).collect(Collectors.toList());
    System.out.println("skip  " + SkipList);


    }
}

class Person{
    private String name;
    private int age;
    private int salary;

    public Person(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}


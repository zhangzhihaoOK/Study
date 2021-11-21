package com.zzh.mybatis.DailyStudy.Text;

import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtilsApi {
    @Test
    public void testIsEmpty(){

        class Person{}
        class Girl extends Person{}

        List<Integer> first = new ArrayList<>();
        List<Integer> second = null;
        List<Person> boy = new ArrayList<>();
        //每个男孩心里都装着一个女孩
        boy.add(new Girl());
        //判断集合是否为空
        System.out.println(CollectionUtils.isEmpty(first));
        System.out.println(CollectionUtils.isEmpty(second));
        System.out.println(CollectionUtils.isEmpty(boy));
        //判断集合是否不为空
        System.out.println(CollectionUtils.isNotEmpty(first));
        System.out.println(CollectionUtils.isNotEmpty(second));
        System.out.println(CollectionUtils.isNotEmpty(boy));
    }

    @Test
    public void testIsEqual(){

        class Person{}
        class Girl extends Person{
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        first.add(1);
        first.add(2);
        second.add(2);
        second.add(1);
        Girl goldGirl = new Girl();
        List<Person> boy1 = new ArrayList<>();
        //每个男孩心里都装着一个女孩
        boy1.add(new Girl());
        List<Person> boy2 = new ArrayList<>();
        //每个男孩心里都装着一个女孩
        boy2.add(new Girl());
        //比较两集合值
        System.out.println(CollectionUtils.isEqualCollection(first,second));
        System.out.println(CollectionUtils.isEqualCollection(first,boy1));
        System.out.println(CollectionUtils.isEqualCollection(boy1,boy2));

        List<Person> boy3 = new ArrayList<>();
        //每个男孩心里都装着一个女孩
        boy3.add(goldGirl);
        List<Person> boy4 = new ArrayList<>();
        boy4.add(goldGirl);
        System.out.println(CollectionUtils.isEqualCollection(boy3,boy4));
    }
    @Test
    //并集
    public void testUnion(){
        String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };
        String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);
        //2个数组取并集
        Collection<String> unionList = CollectionUtils.union(listA, listB);
        System.out.println(unionList);
        //[A, B, C, D, E, F, G, H, K]
    }
    @Test
    //差集
    public void testIntersection(){
        String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };
        String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);
        //2个数组取交集
        Collection<String> testIntersectionList = CollectionUtils.union(listA, listB);
        System.out.println(testIntersectionList);
        //[B, D, F]
    }

    @Test
    //交集的补集
    public void testDisjunction(){
        String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };
        String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);
        //2个数组取交集 的补集
        Collection<String> DisjunctionList = CollectionUtils.union(listA, listB);
        System.out.println(DisjunctionList);
        //[A, C, E, G, H, K]
    }
    @Test
    //差集
    public void testSubtract(){
        String[] arrayA = new String[] { "A", "B", "C", "D", "E", "F" };
        String[] arrayB = new String[] { "B", "D", "F", "G", "H", "K" };
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);
        //arrayA扣除arrayB
        Collection<String> SubtractList = CollectionUtils.union(listA, listB);
        System.out.println(SubtractList);
        //[A, C, E]
    }
}

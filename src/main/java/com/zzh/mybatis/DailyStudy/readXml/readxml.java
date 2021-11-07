package com.zzh.mybatis.DailyStudy.readXml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class readxml {
    public static void main(String[] args) {
        //将xml以字符串的形式输出出来
//        Document document1 = XmlUtil.readXML("E:\\idea工程\\demo\\demo\\src\\main\\java\\test.xml");
//        String s = XmlUtil.toStr(document1);
//        System.out.println(s);

        try {
            //创建SAXReader
            SAXReader reader = new SAXReader();
            //从xml文件中获取数据
            Document document = reader.read(new File("E:\\idea工程\\demo\\demo\\src\\main\\java\\test.xml"));
            //获取根节点  emps
            Element root = document.getRootElement();
            //查找指定节点名称QName的所有子节点elements
            List<Element> list = root.elements("emp");//得到所有emp元素
//          List<Element> list1 = root.elements("cmp"); //得到cmp元素
            for (Element element1: list) {//循环输出emp的所有相关信息
                List<Element> list2 = element1.elements();//得到emp元素下的子元素
                for (Element element2: list2) {//遍历emp下的子元素
                    System.out.print(element2.getName() + ":");//获取子元素名称
                    System.out.print(element2.getText() + " ");//获取子元素的文本值
                }
                System.out.println();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}

package com.forum.controller;

import com.forum.model.Picture;
import com.forum.model.User;
import com.forum.service.PictureService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestController {
//    @Resource
//    static PictureService pictureService;
//
//    public static void main(String[] args) {
//        List<Picture> pictures=pictureService.list();
//        for (Picture p : pictures) {
//            System.out.println(p.getMID());
//        }
//    }



//    public static void main(String[] args) {
//        List<Picture> pictures= Arrays.asList(
//                new Picture(1,1,"001.jpg"),
//                new Picture(2,2,"002.jpg"),
//                new Picture(3,2,"003.jpg"),
//                new Picture(4,3,"004.jpg")
//        );
//        //查询mid为2的所有pic对象，存放到一个新的集合
//        //lambda表达式的本质就是简化方法的声明，可以将简化的方法作为参数值进行传递
////        List<Picture> pictures1=pictures.stream().filter(p->p.getmID()==2).collect(Collectors.toList());
////        pictures1.forEach(p-> System.out.println(p.getpName()));
//        //查询类型为2的所有pic
//        List<Picture> pictures1=find(pictures,p->p.getPID()==2);
//        //查询mid的值大于1的所有pic
//        List<Picture> pictures2=find(pictures,p->p.getPID()>1);
//        //查询pName中包含3的所有pic
//        List<Picture> pictures3=find(pictures,p->p.getPName().indexOf('3')>-1);
//
//    }
//
//
//    // 定义一个方法，实现自定义过滤效果
//    //Predicate<T>表示输入参数式T类型，返回值为bool类型的方法的函数式接口，用于规范传入的方法的参数和返回值的方法类型
//     public static  <T> List<T> find(List<T> list, Predicate<T> func){
//         List<T> newList=new ArrayList<>();
//         for (T t:list) {
//             if (func.test(t)){  //func.test  就是执行func方法
//                 newList.add(t);
//             }
//         }
//         return newList;
//     }

}

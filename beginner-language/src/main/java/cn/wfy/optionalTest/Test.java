package cn.wfy.optionalTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/***
 *
 * @Description Test
 * @Author wfy
 * @Date 2021/5/31 9:53
 */
public class Test {
    public static void main(String[] args) {

       HashSet hashSet =new HashSet();
       hashSet.add(null);
       hashSet.add(null);
       hashSet.add(null);
        System.out.println(hashSet.size());

        ArrayList<Person> list1 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Person person = new Person();
            person.setName(String.valueOf(i));
            person.setBirthday(new Date());
            list1.add(person);
        }
        ArrayList<LLL> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LLL lll = new LLL();
            lll.setId(i);
            lll.setPersonList(list1);
            list.add(lll);
        }


        List<List<Person>> collect = list.stream().map(item -> {
            List<Person> personList = item.getPersonList();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getBirthday());
            }
            return personList;
        }).collect(Collectors.toList());




    }

}

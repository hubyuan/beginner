package cn.wfy.assembly.asmTest;

/***
 *
 * @Description DaoOne
 * @Author wfy
 * @Date 2021/5/24 14:25
 */
public class DaoOne {
    public void select() {
        System.out.println("select 1 from dual");
    }

    public void insert() {
        System.out.println("insert into ...");
    }

    public final void delete() {
        System.out.println("delete from ...");
    }
}

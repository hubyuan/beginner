package cn.wfy.reflect;

/**
 * @Description TODO
 * @auther wfy
 * @since 2022/9/3
 */
public class ReflectCustomer {

    public static void main(String[] args)throws Exception {

//        Class aClass = CustomerService.class;
//        CustomerService customerService = (CustomerService)aClass.newInstance();
//        Method sum = aClass.getMethod("sum",Integer.class);
//        Object invoke = sum.invoke(customerService,9, 10);
//        System.out.println(invoke);


        ReflectCustomer reflectCustomer = new ReflectCustomer();
        reflectCustomer.dofuck();
    }

    public void dofuck() throws Exception{
//
//        System.out.println("-------");
////        Class customerService = Class.forName("cn.wfy.reflect.CustomerService");
//        Class aClass = CustomerService.class;
//        CustomerService customerService = (CustomerService)aClass.newInstance();
//        System.out.println(customerService);
//        CustomerService c = new CustomerService();
//
////        Method sum = aClass.getMethod("sum",Void.class);
////        Object invoke = sum.invoke(customerService,9, 10);
////        System.out.println(invoke);
//
////        Field[] fields = customerService.getClass().getFields();
////        for (Field field : fields) {
////            if (field.getType()==Integer.class){
////                Integer fuckInt = (Integer) field.get(customerService);
////                System.out.println(fuckInt);
////            }
////        }
//



    }
}

package cn.wfy.netty.vo;

public class ProtoTest {

        public static void main(String[] args) throws Exception {
            SubscribeReqProto.SubscribeReq student = SubscribeReqProto.SubscribeReq.newBuilder().setProductName("张三")
                    .setSubReqID(20).setAddress("北京").build();
            byte [] student2ByteArray = student.toByteArray();
            SubscribeReqProto.SubscribeReq student1 = SubscribeReqProto.SubscribeReq.parseFrom(student2ByteArray);
            System.out.println(student1);
            System.out.println("---------华丽分割线---------");
            System.out.println(student1.getProductName());
            System.out.println(student1.getSubReqID());
            System.out.println(student1.getAddress());
        }

}

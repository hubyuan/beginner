package cn.wfy.nikey;

import java.util.Base64;
import java.util.HashSet;

public class MenuUtil {

    //8002对应7038，8003对应7037，8004对应7036
    /***
     *
     * configuration 组态 7038
     * system 子系统 7036
     * distribution 系统 7037
     *
     */

    static final String distribution = "7036";
    static final String configuration = "7038";
    static final String ipaddr = "10.1.1.3";
    static final String companyId = "10000003";

    static final boolean have_company = false;
    static final String table_name = "role_privilege_via_page_path";
/*
    public static void main(String[] args) {
        startdo();
    }*/

    private static void startdo() {


        String url =

                        "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL0J1c2luZXNzT3JnYW5pemF0aW9ucz9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL21lbnU/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL2NvbXBhbnk/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3JvbGU/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3JvbGVQYXJhbT9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3VzZXI/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvcHJvZHVjdC9tZWFzdXJlP2xheW91dD0x\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvcHJvZHVjdC9vYmplY3RSZWdpc3Rlcj9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvZGF0YS9jb2xsZWN0aW9uP2xheW91dD0x\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvbXNnL21zZz9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL0J1c2luZXNzT3JnYW5pemF0aW9ucz9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL21lbnU/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL2NvbXBhbnk/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3JvbGU/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3VzZXI/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvcHJvZHVjdC9tZWFzdXJlP2xheW91dD0x\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvcHJvZHVjdC9vYmplY3RSZWdpc3Rlcj9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvc3ZnU3lzdGVtL2luZGV4U3ZnLyU1QiU3QiUyMmlkJTIyOiUyMmU0Zjk3MDNhLThiNDMtNGNhNy1iOWRkLWFmNTE2ZmZjNDE4NSUyMiU3RCwlN0IlMjJpZCUyMjolMjJmNjBiZDI1Ny01NzY2LTRhOGQtOTE0OS02NjBlMzg3NzJlMWUlMjIlN0QlNUQvMQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvc3ZnU3lzdGVtL2luZGV4U3ZnLyU1QiU3QiUyMmlkJTIyOiUyMmY2MGJkMjU3LTU3NjYtNGE4ZC05MTQ5LTY2MGUzODc3MmUxZSUyMiU3RCwlN0IlMjJpZCUyMjolMjI3NmU4Y2ViNi0yNTlmLTQ1ZDAtYmI2ZC1jNjY3Y2EyMGYzMzQlMjIlN0QsJTdCJTIyaWQlMjI6JTIyZTRmOTcwM2EtOGI0My00Y2E3LWI5ZGQtYWY1MTZmZmM0MTg1JTIyJTdEJTVELzE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvcGFnZVN5c3RlbS9pbmRleFBhZ2UvM2JlMmI3MmIrZGFjZSs0OWY5K2FmMzcrOTNiNzYwN2ZiOGJmLzE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvcGFnZVN5c3RlbS9pbmRleFBhZ2UvM2NkYTAzOGIrOTBiNis0Y2RlK2I4MmMrYzdkNzQ4N2YwZDU0LzE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvcGFnZVN5c3RlbS9pbmRleFBhZ2UvYjVlMDY2ZWIrNWE5OSs0ODQxK2I2ODkrNWY1ODQzZTM1MWJlLzE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvdGhyZWVTeXN0ZW0vaW5kZXhUaHJlZS8lNUIlN0IlMjJpZCUyMjolMjI1Njg0OThhZi1hYjJhLTQ0ODktOGQzYi0xZWRmMTcwZGFkODIlMjIlN0QlNUQvMQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL0J1c2luZXNzT3JnYW5pemF0aW9ucz9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL21lbnU/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL2NvbXBhbnk/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3JvbGU/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3JvbGVQYXJhbT9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3VzZXI/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvcHJvZHVjdC9tZWFzdXJlP2xheW91dD0x\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvcHJvZHVjdC9vYmplY3RSZWdpc3Rlcj9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvZGF0YS9jb2xsZWN0aW9uP2xheW91dD0x\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvbXNnL21zZz9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL0J1c2luZXNzT3JnYW5pemF0aW9ucz9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL21lbnU/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL2NvbXBhbnk/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3JvbGU/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvc3lzdGVtL3VzZXI/bGF5b3V0PTE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvcHJvZHVjdC9tZWFzdXJlP2xheW91dD0x\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDEvcHJvZHVjdC9vYmplY3RSZWdpc3Rlcj9sYXlvdXQ9MQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvc3ZnU3lzdGVtL2luZGV4U3ZnLyU1QiU3QiUyMmlkJTIyOiUyMmU0Zjk3MDNhLThiNDMtNGNhNy1iOWRkLWFmNTE2ZmZjNDE4NSUyMiU3RCwlN0IlMjJpZCUyMjolMjJmNjBiZDI1Ny01NzY2LTRhOGQtOTE0OS02NjBlMzg3NzJlMWUlMjIlN0QlNUQvMQ==\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvc3ZnU3lzdGVtL2luZGV4U3ZnLyU1QiU3QiUyMmlkJTIyOiUyMmY2MGJkMjU3LTU3NjYtNGE4ZC05MTQ5LTY2MGUzODc3MmUxZSUyMiU3RCwlN0IlMjJpZCUyMjolMjI3NmU4Y2ViNi0yNTlmLTQ1ZDAtYmI2ZC1jNjY3Y2EyMGYzMzQlMjIlN0QsJTdCJTIyaWQlMjI6JTIyZTRmOTcwM2EtOGI0My00Y2E3LWI5ZGQtYWY1MTZmZmM0MTg1JTIyJTdEJTVELzE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvcGFnZVN5c3RlbS9pbmRleFBhZ2UvM2JlMmI3MmIrZGFjZSs0OWY5K2FmMzcrOTNiNzYwN2ZiOGJmLzE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvcGFnZVN5c3RlbS9pbmRleFBhZ2UvM2NkYTAzOGIrOTBiNis0Y2RlK2I4MmMrYzdkNzQ4N2YwZDU0LzE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvcGFnZVN5c3RlbS9pbmRleFBhZ2UvYjVlMDY2ZWIrNWE5OSs0ODQxK2I2ODkrNWY1ODQzZTM1MWJlLzE=\n" +
                                "?url=aHR0cDovLzEwNi43NS4xMzUuMjEyOjgyMDIvdGhyZWVTeXN0ZW0vaW5kZXhUaHJlZS8lNUIlN0IlMjJpZCUyMjolMjI1Njg0OThhZi1hYjJhLTQ0ODktOGQzYi0xZWRmMTcwZGFkODIlMjIlN0QlNUQvMQ==";

        String[] urlList = url.replaceAll("\\?url=", "").replaceAll(" ", "").split("\n");

        HashSet<Object> hashSet = new HashSet<>();
        for (String encodeStr : urlList) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!encodeStr.isEmpty() && encodeStr.length() > 4) {

                stringBuilder.append("update " + table_name + " set page_param = '");
                //被处理
                String decodeStr = null;
                try {
                    decodeStr = new String(Base64.getDecoder().decode(encodeStr.getBytes()));
                    System.out.println(decodeStr);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e);
                }
//                System.out.println(decodeStr);
//                System.out.println("?url=" + encodeStr);
                String urlen = "?url=" + encodeStr;
                String strategy = strategy(decodeStr);

                stringBuilder.append(strategy);
                stringBuilder.append("' where ");

                if (have_company) {
                    stringBuilder.append("company_id = '" + companyId + "' and");
                }
                stringBuilder.append(" page_param = '" + urlen + "';");
            }
            //
            hashSet.add(stringBuilder);
        }
        System.out.println();
//        System.out.println(hashSet.size());
        hashSet.forEach(System.out::println);
        System.out.println();
    }

    private static String strategy(String decodeStr) {


        String separator = "/";
        int index = decodeStr.indexOf(separator);
        index = decodeStr.indexOf(separator, index + 1);
        index = decodeStr.indexOf(separator, index + 1);
//        index = decodeStr.indexOf(separator, index + 1);
        String location = "/" + decodeStr.substring(index + 1);

        System.out.println(location);
//        System.out.println(decodeStr.substring(0, index + 1));
//        String https = "";
//        String substring = decodeStr.substring(decodeStr.length() - 2, decodeStr.length());
//        if (substring.equals("=1")) {
//            //distribution 系统
//            https = "http://" + ipaddr + ":" + distribution + "/";
//        } else if (substring.equals("/1")) {
//            //configuration 组态
//            https = "http://" + ipaddr + ":" + configuration + "/";
//        } else {
//            System.out.println("error");
//        }
//        System.out.println(https + location);
//        String encode = new String(Base64.getEncoder().encode((https + location).getBytes()));
        return "?url=" + location;

    }


}

//package com.chat.backcontroll;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
////import org.springframework.security.jwt.Jwt;
////import org.springframework.security.jwt.JwtHelper;
////import org.springframework.security.jwt.crypto.sign.RsaVerifier;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.stream.Collectors;
//
///**
// * @ProjectName: Parent
// * @Package: com.chat.backcontroll
// * @ClassName: TestJwt
// * @Description: java类作用描述
// * @Author: ldy
// * @CreateDate: 2020/7/17 16:47
// * @UpdateUser: 更新者
// * @UpdateDate: 2020/7/17 16:47
// * @UpdateRemark: 更新说明
// * @Version: 1.0
// */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class TestJwt {
//    @Test
//    public void testVerify() throws IOException {
//        Resource resource = new ClassPathResource("publickey.txt");
//        String publickey = "";
//        try {
//            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());
//
//            BufferedReader br = new BufferedReader(inputStreamReader);
//            publickey = br.lines().collect(Collectors.joining("\n"));
//        } catch (IOException ioe) {
//           throw ioe;
//        }
//        //jwt令牌
//        String jwtString = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55SWQiOiIxIiwidXNlcnBpYyI6bnVsbCwidXNlcl9uYW1lIjoiaXRjYXN0Iiwic2NvcGUiOlsiYXBwIl0sIm5hbWUiOiJ0ZXN0MDIiLCJ1dHlwZSI6IjEwMTAwMiIsImlkIjoiNDkiLCJleHAiOjE1OTUwMTk5OTYsImF1dGhvcml0aWVzIjpbInhjX3RlYWNobWFuYWdlcl9jb3Vyc2VfYmFzZSIsInhjX3RlYWNobWFuYWdlcl9jb3Vyc2VfZGVsIiwieGNfdGVhY2htYW5hZ2VyX2NvdXJzZV9saXN0IiwieGNfdGVhY2htYW5hZ2VyX2NvdXJzZV9wbGFuIiwieGNfdGVhY2htYW5hZ2VyX2NvdXJzZSIsImNvdXJzZV9maW5kX2xpc3QiLCJ4Y190ZWFjaG1hbmFnZXIiLCJ4Y190ZWFjaG1hbmFnZXJfY291cnNlX21hcmtldCIsInhjX3RlYWNobWFuYWdlcl9jb3Vyc2VfcHVibGlzaCIsInhjX3RlYWNobWFuYWdlcl9jb3Vyc2VfYWRkIl0sImp0aSI6IjRkOTcyYWMzLTExZWQtNDNjOS04YjZiLWIxYTZmZmFmNzVkNCIsImNsaWVudF9pZCI6IlhjV2ViQXBwIn0.ka96YBP7VAQHA4RFBv33tRX0-oK8D8etmfj-f76cOrQYKyGDe_kHnuVTR8lowx5eU06zSTqBaLgHOoe6kvdQ9P4RkSt-_5vJParZySzyKN5-wciCH56fZ86vYEqKgc8oOEC5lpFAEFEkwKHOv3RQwf1uT9wy4rz-t3I5Gm_sCD1utQw_iNHFsdAW2Ue_c4hfLfEV6PhiK5IbuZFajRyf7GkhF3IGrQa7rQIJh0v9dC-uNgJThzM5XibWrZcbrz3rikDd0I21-aplNwpVgxgKd-183I9J2rI7kRpiOCuXPv1mIfYKFoXrQNkNTl4O59zRz3dVCMHzyRzcr43uOzIxzA";
//        //校验jwt令牌
//        Jwt jwt = JwtHelper.decodeAndVerify(jwtString, new RsaVerifier(publickey));
//        //拿到jwt令牌中自定义的内容
//        String claims = jwt.getClaims();
//        System.out.println(claims);
//    }
//}

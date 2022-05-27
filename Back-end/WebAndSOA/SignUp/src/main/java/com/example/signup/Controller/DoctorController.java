package com.example.signup.controller;

import com.example.signup.entity.Doctor;
import com.example.signup.entity.Patient;
import com.example.signup.service.DoctorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * (Doctor)表控制层
 *
 * @author makejava
 * @since 2022-05-13 17:57:08
 */
@RestController
@RequestMapping("/bSignUp")
public class DoctorController {
    /**
     * 服务对象
     */
    @Resource
    private DoctorService doctorService;

    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/activateAccount")
    @ApiOperation(value = "发送邮箱接口", notes = "返回1发送成功,0已激活")
    @ApiResponses({
            @ApiResponse(code = 438, message = "用户名或邮箱重复")
    })
    public Object sendEmail(@RequestParam String id,
                            @RequestParam String email,
                            HttpServletResponse response,
                            HttpServletRequest request) {
        Doctor user = doctorService.queryById(id);
        Doctor user1 = doctorService.queryByEmail(email);
        if (user != null && user1 != null) {
            response.setStatus(438);
            return "用户名或邮箱重复！";
        }

        StringBuilder sb;
        int[] test = new int[4];
        Random random = new Random();
        sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            test[i] = random.nextInt(9);
            sb.append(test[i]);
        }
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); //发送人
        message.setTo(email);   //收件人
        message.setSubject("济医-用户激活");  //邮件名
        message.setText("欢迎您激活济医医生端，您的验证码为：" + sb + "，10分钟内有效。");   //邮件内容（验证码）
        mailSender.send(message);
//        HttpSession mailSession = request.getSession();
//        mailSession.setAttribute("mailCode", sb.toString());
//        mailSession.setAttribute("userid", id);
        redisTemplate.opsForValue().set("mailCode_" + id, sb.toString(), 10, TimeUnit.MINUTES);
        System.out.println("存入缓存成功");
        return id;
    }

    @PostMapping("/activateAccountCode")
    @ApiOperation(value = "邮箱验证接口", notes = "输入用户名、验证码，返回1验证成功,0验证错误，-2验证码过期")
    @ApiResponses({
//            @ApiResponse(code = 438, message = "未找到用户")
    })
    public int verifyEmailCode(@RequestParam String code,
                               @RequestParam String id,
                               HttpServletResponse response,
                               HttpServletRequest request) {
        String mail = redisTemplate.opsForValue().get("mailCode_" + id);
        System.out.println(mail);
        if (mail != null && !mail.equals("")) {

            if (code.equals(mail)) {
//                user.setUserState(1);
                return 1;
            } else
                return 0;
        }
        return -2;
    }

    @PostMapping("/patientSign")
    @ApiOperation(value = "医生注册接口", notes = "按要求输入，返回userId")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @ApiResponses({
//            @ApiResponse(code = 438, message = "未找到用户")
    })
    public Object patientSign(@RequestParam String userId,
                              @RequestParam String name,
                              @RequestParam String sex,
                              @RequestParam String passwd,
                              @RequestParam String title,
                              @RequestParam Integer department_id,
                              @RequestParam String email,
                              @RequestParam Integer hospital_id,
                              MultipartFile pic,
                              HttpServletResponse response,
                              HttpServletRequest request) {
        Doctor doctor;
        try {
            byte[] data=null;
            if (pic != null) {
                InputStream ins = pic.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while ((len = ins.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.flush();
                data = bos.toByteArray();
            }
            doctor = new Doctor(userId,name,passwd,sex,title,department_id,email,hospital_id,null,data);
            doctorService.insert(doctor);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return doctor.getDoctorId();
    }


    @GetMapping("/resetPasswordEmail/{id}")
    @ApiOperation(value = "重置密码邮箱验证", notes = "返回1发送成功")
    @ApiResponses({
    })
    public int resetPasswordEmail(@PathVariable("id") String id,
                                  HttpServletResponse response,
                                  HttpServletRequest request) {
        Doctor user = doctorService.queryById(id);
        if (user == null) {
            response.setStatus(438);
            return -1;
        }
        StringBuilder sb;
        int[] test = new int[4];
        Random random = new Random();
        sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            test[i] = random.nextInt(9);
            sb.append(test[i]);
        }
        String userEmail = user.getEmail();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); //发送人
        message.setTo(userEmail);   //收件人
        message.setSubject("济医-用户激活");  //邮件名
        message.setText("欢迎您重新激活济医医生端，您的验证码为：" + sb + "，10分钟内有效。");   //邮件内容（验证码）
        mailSender.send(message);
        HttpSession session = request.getSession();
        session.setAttribute("mailCode", sb.toString());
        System.out.println("mailCode:" + sb);
        System.out.println(session.getAttribute("mailCode").toString());
//        session.
        session.setMaxInactiveInterval(60 * 10);//存活10分钟
        return 1;
    }


    @PostMapping("/resetPassword")
    @ApiOperation(value = "重置密码接口", notes = "输入用户名、新密码，返回1验证成功")
    @ApiResponses({
            @ApiResponse(code = 438, message = "未找到用户")
    })
    public Object resetPassword(@RequestParam("id") String id,
                                @RequestParam("password") String password,
                                HttpServletResponse response,
                                HttpServletRequest request) {
        Doctor user = doctorService.queryById(id);
        if (user == null) {
            response.setStatus(438);
            return -1;
        }
        if (password.equals(user.getPassword())) {
            response.setStatus(439);
            return "equal to now password,fail";
        }
        user.setPassword(password);
        doctorService.update(user);
        return 1;
    }

    @PostMapping("/modifyInfoByUser")
    @ApiOperation(value = "账户信息编辑接口(User)", notes = "返回1修改成功，0修改失败")
    @ApiResponses({
            @ApiResponse(code = 438, message = "未找到用户"),
            @ApiResponse(code = 441, message = "邮箱与他人重复")
    })
    public Integer modifyInfoByUser(@RequestParam("id") String id,
                                    String name,
                                    String sex,
                                    String title,
                                    Integer department_id,
                                    String email,
                                    Integer hospital_id,
                                    MultipartFile pic,
                                    HttpServletResponse response) {
//        userId,name,age,sex,passwd,email,idcard,data
        Doctor user = doctorService.queryById(id);
        if (user == null) {
            response.setStatus(438);
            return -1;
        }
        if (name != null && !name.equals("")) {
            user.setName(name);
        }
        if (department_id!= null ) {
            user.setDepartmentId(department_id);
        }
        if (hospital_id!= null ) {
            user.setHospitalId(hospital_id);
        }
        if (sex.equals("M") || sex.equals("F")) {
            user.setSex(sex);
        }
        if (title!= null && title.equals("")) {
            user.setSex(sex);
        }
        if (email != null && !email.equals("")) {
            user.setEmail(email);
        }
        if (pic != null) {
            try {
                InputStream ins = pic.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                while ((len = ins.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.flush();
                byte[] data = bos.toByteArray();
                user.setPic(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Doctor update = doctorService.update(user);
        if (update != null) {
            return 1;
        } else return 0;
    }


}

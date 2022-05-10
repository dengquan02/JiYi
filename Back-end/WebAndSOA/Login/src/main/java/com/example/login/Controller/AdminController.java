package com.example.login.Controller;


import com.example.login.Dto.AdminDto;
import com.example.login.Service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "管理员登录服务")
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ApiOperation("管理员登录")
    @PostMapping("login")
    public ResponseEntity<AdminDto> Login(@RequestBody AdminDto dto) {
        return new ResponseEntity<>( adminService.login ( dto ), HttpStatus.OK );
    }
}

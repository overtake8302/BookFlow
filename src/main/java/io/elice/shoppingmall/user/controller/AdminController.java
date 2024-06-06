package io.elice.shoppingmall.user.controller;

import io.elice.shoppingmall.user.model.User;
import io.elice.shoppingmall.user.model.dto.AdminPostDto;
import io.elice.shoppingmall.user.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/menu/userpage")
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public List<AdminPostDto> userFindAll() {
        return adminService.userFindAll();
    }

    @PutMapping
    public void userRoleUpdate() {

    }
}

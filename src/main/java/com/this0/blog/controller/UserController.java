package com.this0.blog.controller;


import com.this0.blog.pojo.User;
import com.this0.blog.service.UserService;
import com.this0.blog.utils.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Tag(name = "用户模块")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "用户登陆")
    @PostMapping("/login")
    public Result login(@RequestBody User user) {

        //此处返回的是全量的数据
        User loginUser = userService.login(user);

        //前端需要的是uid以及uname

        if (loginUser != null) {
            HashMap<Object, Object> map = new HashMap<>();
            map.put("uid", loginUser.getUid());
            map.put("username", loginUser.getUsername());
            return Result.ok(map);
        }
        return Result.fail();
    }

    @Operation(summary = "用户查询")
    @GetMapping("/{uid}")
    public Result showUser(@PathVariable Integer uid) {


        User user = userService.showUserByUid(uid);

        //用不上判断
        return Result.ok(user);

    }

    @Operation(summary = "用户信息更新")
    @PutMapping
    public Result changeUser(@RequestBody User user) {

        Integer result = userService.changeUser(user);
        if (result > 0) {
            return Result.ok();
        } else {
            return Result.fail();
        }


    }

}

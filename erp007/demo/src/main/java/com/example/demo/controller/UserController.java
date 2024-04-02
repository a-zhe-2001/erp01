package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.QueryPageParam;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kk
 * @since 2024-04-01
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }

//    新增
    @PostMapping ("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
//    修改
     @PostMapping ("/mod")
     public boolean mod(@RequestBody User user){
         return userService.updateById(user);
}
//    新增或修改（根据id判断）
     @PostMapping ("/saveOrMod")
     public boolean saveOrMod(@RequestBody User user){
         return userService.saveOrUpdate(user);
}
//    删除
     @PostMapping ("/delete")
     public boolean delete(Integer id){
        return userService.removeById(id);
}
//    查询(模糊、匹配)
     @PostMapping ("/listP")
     public List<User> listP(@RequestBody User use){
         LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();

         lambdaQueryWrapper.like(User::getName,use.getName());
//         like模糊查询
//         eq匹配查询
         return userService.list(lambdaQueryWrapper);
     }

    //分页查询
    @PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam queryPageParam) {

        Page<User> page = new Page<>();
        page.setCurrent(queryPageParam.getPageNum());
        page.setSize(queryPageParam.getPageSize());

        HashMap param = queryPageParam.getParam();
        String name = (String) param.get("name");
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, name);

        IPage result = userService.page(page, lambdaQueryWrapper);
        System.out.println("total = " + result.getTotal());
        return result.getRecords();
    }


//    listPageC一直报错，无法显示url
@PostMapping("/listPageC")
public List<User> listPageC(@RequestBody QueryPageParam query) {
    HashMap param = query.getParam();
    String name = (String) param.get("name");
    System.out.println("name===" + (String) param.get("name"));

    Page<User> page = new Page();
    page.setCurrent(query.getPageNum());
    page.setSize(query.getPageSize());

    LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
    lambdaQueryWrapper.like(User::getName, name);

    IPage result = userService.pageC(page);
//    IPage result = userService.pageCC(page, lambdaQueryWrapper);
    System.out.println("total==" + result.getTotal());

    return result.getRecords();
}



//


}

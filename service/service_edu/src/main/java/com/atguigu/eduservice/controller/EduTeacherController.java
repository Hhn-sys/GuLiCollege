package com.atguigu.eduservice.controller;


import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author codeGenerator
 * @since 2021-09-05
 */
@RestController
@RequestMapping("/eduservice/teacher")
@Api(description = "讲师管理")
public class EduTeacherController {
    /**
     * 注入service
     */
    @Autowired
    private EduTeacherService teacherService;

    /**
     * 查询讲师列表的所有数据
     */
    @GetMapping("findAll")
    @ApiOperation(value = "所有讲师列表")
    public List<EduTeacher> findAllTeacher() {
        return teacherService.list(null);
    }

    /**
     * 逻辑删除讲师的方法
     * 通过路径中的值进行传递，用@PathVariable
     * 通过传值处理用@RequestBody（一堆数据组成的对象）
     * 或者
     *
     * @RequestParam（单独的数据）
     */
    @DeleteMapping("{id}")
    public boolean removeTeacher(@ApiParam(name = "id", value = "讲师ID", required = true)
                                 @PathVariable String id) {
        return teacherService.removeById(id);
    }


}


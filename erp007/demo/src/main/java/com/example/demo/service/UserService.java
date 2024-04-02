package  com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kk
 * @since 2024-04-01
 */

public interface UserService extends IService<User> {

    IPage pageC(IPage<User> page);

//    IPage pageCC(IPage<User> page, Wrapper wrapper);

}
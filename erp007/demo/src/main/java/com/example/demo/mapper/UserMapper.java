package  com.example.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import  com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kk
 * @since 2024-04-01
 */


@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage pageC(IPage<User> page);

//    IPage pageCC(IPage<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
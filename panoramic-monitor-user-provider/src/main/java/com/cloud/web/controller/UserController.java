package com.cloud.web.controller;

import com.monitor.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunder
 * 测试
 */
@RestController
public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private UserService userService;

    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     *
     * @param id
     * @return user信息
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     */
//    @GetMapping("/{id}")
//    public User findById(@PathVariable Integer id) {
////        User user1 = userService.findById(id); /**报错类型转换错误*/
//        User user = userService.selectByid(id); /**可以*/
//        return user;
//    }

    /**
     * 本地服务实例的信息
     *
     * @return
     */
    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        List<String> serviceIds = this.discoveryClient.getServices();
        ServiceInstance localServiceInstance = discoveryClient.getInstances(serviceIds.get(0)).get(0);
        return localServiceInstance;
    }
}

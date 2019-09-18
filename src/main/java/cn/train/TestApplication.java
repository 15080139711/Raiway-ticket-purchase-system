package cn.train;

//import cn.train.config.Consumer;
import cn.train.config.Redis;
import cn.train.controller.TicketController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("cn.train.mapper")
public class TestApplication {

    public static void main(String[] args)  {
        SpringApplication.run(TestApplication.class, args);
        Redis consumer=new Redis();
        consumer.start();
//        TicketController.receive();
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(TestApplication.class, args);
//        //从 spring中取出已经有的bean
//        CountDownLatch countDownLatch = applicationContext.getBean(CountDownLatch.class);
//        StringRedisTemplate stringRedisTemplate = applicationContext.getBean(StringRedisTemplate.class);
//
//        stringRedisTemplate.convertAndSend(RedisConfig.MSG_TOPIC, "hello from jsbintask.");
//
//        // 一直等待消息被接收，没接收不退出
//        countDownLatch.await();

    }

}

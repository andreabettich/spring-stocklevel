package ch.services.stocklevel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class StocklevelApplication {

    public static void main(String[] args) {
        SpringApplication.run(StocklevelApplication.class, args);
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("pub-redis-17872.eu-central-1-1.1.ec2.redislabs.com");
        config.setPassword(RedisPassword.of("redis-nano-1"));
        config.setPort(17872);
        config.setDatabase(0);

        final JedisConnectionFactory jedisConnFactory = new JedisConnectionFactory(config, JedisClientConfiguration.builder()
                                                                                                                   .build());
        jedisConnFactory.afterPropertiesSet();
        return jedisConnFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
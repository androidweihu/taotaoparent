package RedisTest;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weihu
 * @date 2018/7/28/028 21:50
 * @desc
 */
public class RedisJava {
    @Test
    public void test(){
        //创建一个jedis对象
        Jedis jedis=new Jedis("192.168.25.132",6379);
        jedis.set("name","weihu");
        String str=jedis.get("name");
        System.out.println(str);
        jedis.close();

    }

    @Test
    public void testPool(){
        JedisPool jedisPool=new JedisPool("192.168.25.132",6379);
        Jedis jedis=jedisPool.getResource();
        String name=jedis.get("name");
        System.out.println(name);
        jedis.close();
        jedisPool.close();
    }

    @Test
    public void tesJedisClus(){
        Set<HostAndPort> node=new HashSet<>();
        node.add(new HostAndPort("192.168.25.153",7001));
        node.add(new HostAndPort("192.168.25.153",7001));
        node.add(new HostAndPort("192.168.25.153",7001));
        node.add(new HostAndPort("192.168.25.153",7001));
        JedisCluster jedisCluster=new JedisCluster(node);
        jedisCluster.set("names","王五");
        jedisCluster.set("value","1000");
        System.out.println(jedisCluster.get("names"));
        jedisCluster.close();
    }
}

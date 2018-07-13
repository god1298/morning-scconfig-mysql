package com.morning;

import com.morning.config.SpringContextConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Import;

/**
 * The Class ConfigClientApplication.
 */
@EnableConfigServer
@SpringBootApplication
@Import({SpringContextConfig.class})
public class ConfigServerApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	 	//System.setProperty("DEPLOY_ENV", "test");
		// 上线前请去掉此句，在本机设置好环境变量也可去掉此句
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}

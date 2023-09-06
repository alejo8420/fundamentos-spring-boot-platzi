package com.fundamentos.platzi.springboot.fundamentos;

import com.fundamentos.platzi.springboot.fundamentos.bean.MyBean;
import com.fundamentos.platzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.platzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.platzi.springboot.fundamentos.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		System.out.println("*******************");
		myBean.print();
		System.out.println("*******************");
		myBeanWithDependency.printWithDependency();
		System.out.println("*******************");
		System.out.println(myBeanWithProperties.function());
		System.out.println("*******************");
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		try {
			int value = 10/0;
			LOGGER.info("Mi valor: " + value);
		} catch (Exception e){
			LOGGER.error("Esto es un error al dividir por cero - " + e.getMessage());
		}
	}


}

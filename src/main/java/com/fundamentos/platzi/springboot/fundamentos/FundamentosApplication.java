package com.fundamentos.platzi.springboot.fundamentos;

import com.fundamentos.platzi.springboot.fundamentos.bean.MyBean;
import com.fundamentos.platzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.platzi.springboot.fundamentos.component.ComponentDependency;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
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
	}


}

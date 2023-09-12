package com.fundamentos.platzi.springboot.fundamentos;

import com.fundamentos.platzi.springboot.fundamentos.bean.MyBean;
import com.fundamentos.platzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.platzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.platzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.platzi.springboot.fundamentos.entity.User;
import com.fundamentos.platzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.platzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		LOGGER.info("usuario con el método findByUserEmail " +
				userRepository.findByUserEmail("daniela@mail.com")
				.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));

		//userRepository.findByAndSort("user", Sort.by("id").descending()).forEach(user -> LOGGER.info("Usuario con método SORT " + user));
		userRepository.findByAndSort("user", Sort.by("id").descending()).stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort " + user));
	}

	private void saveUsersInDataBase(){
		User user1 = new User("Jhon", "jhon@mail.com", LocalDate.of(2023,9,07));
		User user2 = new User("Julie", "julie@mail.com", LocalDate.of(2023,10,21));
		User user3 = new User("Daniela", "daniela@mail.com", LocalDate.of(2023,9,21));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2023, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2023, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2023, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2023, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2023, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2023, 4, 10));
		User user10 = new User("user10", "user10@domain.com", LocalDate.of(2023, 4, 11));
		User user11 = new User("user11", "user11@domain.com", LocalDate.of(2023, 4, 12));
		User user12 = new User("user12", "user12@domain.com", LocalDate.of(2023, 4, 13));

		List<User> list = Arrays.asList(user1,user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
		list.forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
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

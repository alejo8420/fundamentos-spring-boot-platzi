package com.fundamentos.platzi.springboot.fundamentos.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void saludar(){
        System.out.println("Hola mundo desde mi componente dos");
    }
}

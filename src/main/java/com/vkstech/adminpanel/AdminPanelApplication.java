package com.vkstech.adminpanel;

import com.vkstech.adminpanel.annotation.EnableAdmin;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

@SpringBootApplication
public class AdminPanelApplication implements CommandLineRunner {

    private static final ClassLoader classLoader = EnableAdmin.class.getClassLoader();

    public static void main(String[] args) {
        SpringApplication.run(AdminPanelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(EnableAdmin.class));


        /** basePackage = blank - searches for all packages, and thus is relatively slow
         *  It is recommended to use your model directory to make this scanning faster
         */
        final Set<BeanDefinition> candidates = provider.findCandidateComponents("");

        candidates.forEach(candidate -> System.out.println(candidate.getBeanClassName()));
    }
}

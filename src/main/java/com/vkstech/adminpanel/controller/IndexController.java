package com.vkstech.adminpanel.controller;

import com.vkstech.adminpanel.annotation.EnableAdmin;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    private static Set<String> classNameSet;

    @GetMapping("index")
    public String index(Model model) {

        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(EnableAdmin.class));

        /** basePackage = blank - searches for all packages, and thus is relatively slow
         *  It is recommended to use your model directory to make this scanning faster
         */
        final Set<BeanDefinition> candidates = provider.findCandidateComponents("");
        classNameSet = candidates.stream().map(BeanDefinition::getBeanClassName).collect(Collectors.toSet());

        model.addAttribute("ClassList", classNameSet);
        return "index";
    }
}


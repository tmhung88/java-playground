package net.tmhung.example.spring.jdbi;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Map;

public class JdbiRepositoryScanRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
  private Environment environment;

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  @Override
  public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
    Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(JdbiRepositoryScan.class.getCanonicalName());

    if (annotationAttributes != null) {
      String[] basePackages = (String[]) annotationAttributes.get("value");

      if (basePackages.length == 0){
        basePackages = new String[]{((StandardAnnotationMetadata) metadata).getIntrospectedClass().getPackage().getName()};
      }

      ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false, environment){
        @Override
        protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
          AnnotationMetadata metadata = beanDefinition.getMetadata();
          return metadata.isIndependent() && metadata.isInterface();
        }
      };
      provider.addIncludeFilter(new AnnotationTypeFilter(JdbiRepository.class));

      for (String basePackage : basePackages) {
        for (BeanDefinition beanDefinition : provider.findCandidateComponents(basePackage)) {
          beanDefinition.setFactoryBeanName("idbi");
          beanDefinition.setFactoryMethodName("onDemand");
          try {
            Class a = Class.forName(beanDefinition.getBeanClassName());
            beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, a);
          } catch (ClassNotFoundException e) {
            e.printStackTrace();
          }
          registry.registerBeanDefinition(getName(beanDefinition) , beanDefinition);

        }
      }
    }
  }

  private String getName(BeanDefinition beanDefinition) {
    String fullQualifiedClassName = beanDefinition.getBeanClassName();
    String className = fullQualifiedClassName.substring(fullQualifiedClassName.lastIndexOf('.') + 1);
    return className.substring(0, 1).toUpperCase() + className.substring(1);
  }
}

package net.tmhung.example.spring.jdbi;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.Map;

import static net.tmhung.example.config.JdbiConfig.JDBI_FACTORY_BEAN_NAME;

public class JdbiRepositoryScanRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
  private static final String JDBI_FACTORY_METHOD_NAME = "onDemand";
  private final AnnotationBeanNameGenerator beanNameGenerator;
  private Environment environment;

  public JdbiRepositoryScanRegistrar() {
    this.beanNameGenerator = new AnnotationBeanNameGenerator();
  }

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  @Override
  public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
    Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(EnableJdbiRepository.class.getCanonicalName());

    if (annotationAttributes != null) {
      String[] basePackages = (String[]) annotationAttributes.get("value");

      if (basePackages.length == 0){
        basePackages = new String[]{((StandardAnnotationMetadata) metadata).getIntrospectedClass().getPackage().getName()};
      }
      ClassPathScanningCandidateComponentProvider provider = createComponentFinder(environment, JdbiRepository.class);

      for (String basePackage : basePackages) {
        for (BeanDefinition beanDefinition : provider.findCandidateComponents(basePackage)) {
          beanDefinition.setFactoryBeanName(JDBI_FACTORY_BEAN_NAME);
          beanDefinition.setFactoryMethodName(JDBI_FACTORY_METHOD_NAME);
          try {
            Class a = Class.forName(beanDefinition.getBeanClassName());
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(a);
          } catch (ClassNotFoundException e) {
            e.printStackTrace();
          }
          String beanName = beanNameGenerator.generateBeanName(beanDefinition, registry);
          registry.registerBeanDefinition(beanName , beanDefinition);

        }
      }
    }
  }

  private ClassPathScanningCandidateComponentProvider createComponentFinder(Environment environment,
                                                                            Class<? extends Annotation> annotationClass) {
    ClassPathScanningCandidateComponentProvider provider =
      new ClassPathScanningCandidateComponentProvider(false, environment){
      @Override
      protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return metadata.isIndependent() && metadata.isInterface();
      }
    };
    provider.addIncludeFilter(new AnnotationTypeFilter(annotationClass));
    return provider;
  }
}

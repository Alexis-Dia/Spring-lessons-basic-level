package ironbank;

import ironbank.annotation.ConditionOnProduction;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alexey Druzik on 5/2/2020
 * Update from 19.08.2020 (from https://habr.com/ru/post/430256/):
 *     1. Самое важное — @ConfigurationProperties это не только про загрузку свойств из application.properties файла.
 *         Возможности Spring Boot Configuration гораздо шире — поддерживается 17 (!) разных источников свойств в строгом
 *         приоритете. Можно определить дефолт в application.properties и перекрыть его через переменную окружения,
 *         JVM properties, профиль, тестовые свойства и т.п. Что дает очень мощные возможности для переконфигурирования приложения
 *         в нужном окружении и сильно упрощает конфигурацию. А в дополнение — список источников еще и можно расширять, например,
 *         добавить Hashicorp Vault как бэкенд.
 *     2. ConfigurationProperties аннотация — это часть Spring Boot, а не Spring Core
 *     3. @SpringBootApplication аннотация включает ComponentScan, так что XML конфигурацию (да и любую конфигурацию) можно убрать и просто аннотировать классы @Component. Хотя некоторые разработчики предпочитают явную конфигурацию над автоматическим поиском компонентов.
 *     4. Конфигурировать можно не только классы properties, а вообще любой бин — если совместить @Bean + @ConfigurationProperties или @Component + @ConfigurationProperties. По сути, все, что делает @EnableConfigurationProperties — это регистрирует бин указанного типа.
 *     5. Field и Property injection это, все же, моветон, хотя и не запрещено.
 */
/* When we are using spring.factories - it's not necessary use @Configuration*/
@Configuration
@EnableConfigurationProperties(RavenProperties.class)
public class IronConfiguration {

    /**
        Update from 19.08.2020: У Spring есть такая фишка, что если в контексте есть бин(не важно как созданный - напрямую
        с помощью аннотации @Bean или завтоваринный @Autowire), то после аннотации @Bean мы юзаем методом, в этом случае есть фишки:
            1. Мы можем юзать в качестве аргументов(принимаемых параметров) этого метода другие бины, которые есть в контексте
            2. Мы можем теле метода изменять эти бины, таким образом делая настройку созданных бинов в Spring-контейнере.
            3. Возвращаемое значение - то тип бина который будет создан в контексте.
     **/

    /**
     * Update from 19.08.2020 - It's Eugene Borisov's way:
     */
    @Bean
    @ConditionOnProduction
    @ConditionalOnProperty("raven.destination")
    public RavenListener ravenListener() {
        return new RavenListener();
    }

    /**
     * Update from 19.08.2020 - It's official Spring way:
     */
    @Bean
    @ConditionOnProduction
    @ConditionalOnProperty("raven.destination")
    public RavenListener ravenListener(RavenProperties ravenProperties) {
        return new RavenListener(ravenProperties);
    }
}

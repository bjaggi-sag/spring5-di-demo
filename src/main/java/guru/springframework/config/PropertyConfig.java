package guru.springframework.config;


import guru.springframework.examplebeans.FakeDataSource;
import guru.springframework.examplebeans.FakeJMSBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
//@PropertySources({
//        @PropertySource("classpath:datasource.properties"),
//        @PropertySource("classpath:jms.properties")
//})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${jaggi.username}")
    String user;

    @Value("${jaggi.password}")
    String password;

    @Value("${jaggi.url}")
    String url;

    @Value("${jaggi.jms.username}")
    String jmsUser;

    @Value("${jaggi.jms.password}")
    String jmsPassword;

    @Value("${jaggi.jms.url}")
    String jmsUrl;


    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);
        return fakeDataSource;

    }

    @Bean
    public FakeJMSBroker fakeJMSBroker(){
        FakeJMSBroker fakeJMSBroker = new FakeJMSBroker();
        fakeJMSBroker.setUser(jmsUser);
        fakeJMSBroker.setPassword(jmsPassword);
        fakeJMSBroker.setUrl(jmsUrl);
        return fakeJMSBroker;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
         PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
         return propertySourcesPlaceholderConfigurer;
    }
}

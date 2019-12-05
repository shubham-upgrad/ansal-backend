package ansaltechblogapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration //- "Means it has a set of methods that provide useful beans"
public class JPAConfig {
    // Creating a bean that would return EntityManagerFactory
    @Bean // Springboot will mark the EntityManagerFactory so obtained as a Bean
    public EntityManagerFactory localContainerEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean emfb=new LocalContainerEntityManagerFactoryBean();
        emfb.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        emfb.afterPropertiesSet();
        return emfb.getObject();
    }
    // Telling spring that this is the DataSource that we want to use
    // H2 - in memory DB
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/ansaltechblogdb");
        ds.setUsername("postgres");
        ds.setPassword("postgres@123");
        return ds;
    }
}

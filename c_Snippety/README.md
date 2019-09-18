<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java Spring Hibernate - Snippety
> Krótkie kawałki kodu, które pokazują zależności, rozwiązują popularne problemy oraz pokazują jak używać niektórych funkcji.

#### przykład pliku persistence.xml
````xml
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
             http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
    version="2.1">
    <persistence-unit name="springMvcJpa" >
        <properties>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/springMvcJpa" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="root" />
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <property name="javax.persistence.schema-generation.database.action" value="none"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>  
    </persistence-unit>
</persistence>
````

#### Ziarna konfiguracyjne fabryki encji oraz transakcji.
````java
@Bean
public LocalEntityManagerFactoryBean entityManagerFactory() {
    LocalEntityManagerFactoryBean emfb =
        new LocalEntityManagerFactoryBean();
    emfb.setPersistenceUnitName("springMvcJpa");
    return emfb;
}
 
@Bean
public JpaTransactionManager transactionManager(
                            EntityManagerFactory emf) {
    JpaTransactionManager tm = new JpaTransactionManager(emf);
    return tm;
}
````
Należy zwrócić szczególną uwagę na nazwę ``entityManagerFactory`` - ponieważ takiej nazwy będzie poszukiwał domyślnie **Spring Data JPA**.

Nazwę to można zmienić z wykorzystaniem atrybutu adnotacji ``entityManagerFactoryRef``.
[*dokumentacja*](https://docs.spring.io/spring-data/jpa/docs/1.6.x/api/org/springframework/data/jpa/repository/config/EnableJpaRepositories.html)
#### Przykład definicji encji
````java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Book {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
}

````

#### Jak określić nazwę tabeli dla encji
````java
@Entity
@Table(name = "books")
public class Book {
}

````

#### Jak określić nazwę kolumny dla encji
````java
@Entity
@Table(name = "books")
public class Book {
 
	@Column(name="myTitle")
	String title;
}

````


#### Jak wstrzyknąć EntityManegera
````java
@PersistenceContext
EntityManager entityManager;
````

#### Jak wykonać zapytanie JPQL
````java
Query queryp = entityManager.
  createQuery("SELECT b FROM Book b where rating >:rating");
queryp.setParameter("rating", 4);
List<Book> booksp = query.getResultList();
````


#### Jak dodać Spring form taglib
````html
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

````

#### Jak zarejestrować konwerter
````java
@Override
public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(getPersonGroupConverter());
}
 
@Bean
public PersonGroupConverter getPersonGroupConverter()
{
    return new PersonGroupConverter();
}

````

#### Jak włączyć skanowanie dla repozytoriów Spring Data
````java
@EnableJpaRepositories(basePackages = "pl.coderslab.repository")
````

#### Jak utworzyć repozytorium
````java
public interface PersonRepository extends JpaRepository<Person, Long> { }
````

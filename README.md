# tartarus-cms-server-spring

## Database Setup

<code>docker run --name postgrescodechill -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -e POSTGRES_DB=codechill -p 5432:5432 postgres
</code>

Once you've got your container up and running you'll have to configure your <code>application.properties</code> with the following structure

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/codechill
spring.datasource.username=username
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
```

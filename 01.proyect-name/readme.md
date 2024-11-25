# Proyect Name
En este repositorio iremos desarrollando incrementalmente nuestro proyecto de ejemplo de spring boot.

## Saludo inicial
- Creamos un controlador `Main`
- Con un end point `hello` que devuelva un saludo en texto plano

Nos podemos basar en el proyecto generado en `/wiki/example.proyect.md`.

## CRUD sobre estudiantes
- Creamos un modelo `Student` con propiedades: `nombre`, `apellido` y `dni`
- Creamos un controlador `Student` en el que realizamos las operaciones CRUD sobre una lista y devolvemos la lista

## Robustecemos el Controller Student
- Controlamos lo que recibimos
- Controlamos errores
- Devolvemos códigos del protocolo HTTP correctos para cada caso

## Limpiamos llamadas de información innecesaria
- Usamos parámetros correctos y mínimamente necesarios en los end points, podemos usar
    - `@PathVariable`: obtenemos el valor desde el path de la URL

```
@GetMapping("/student/{dni}")
public String getByDni(@PathVariable String dni) {
    ...
}
```

Ejemplo, para la url `/student/7000X`m la variable `dni` valdría `7000X`.
    - `@RequestParam`: obtenemos el valor desde un parámetro

```
@GetMapping("/student")
public String getByDni(@PathVariable String dni) {
    ...
}
```

Ejemplo, para la url `/student?dni=7000X`m la variable `dni` valdría `7000X`.
- Podemos reducir la longitud y probabilidad de equivocarnos en los `Mapping` con `@RequestMapping`  

## Extraemos la "capa de negocio" - "controlador" como servicio

- Creamos un servicio (como hacíamos anteriormente)
- Creamos su interfaz y lo relacionamos
- Inyectamos el servicio a través de la interfaz con sprint boot (`@Autowired`) en el controlador
- Indicamos que implementación de la interfaz del servicio se usará con la `@Service`

## Persistencia: JPA e Hibernate

- pom.xml > dependencies

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
</dependency>
```

- application.propierties

```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://[host]:[port]/[schema]
spring.datasource.username=[user]
spring.datasource.password=[password]
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql: true
```

- En los modelos

```
@Entity
@Table(name = "[TableName]")
public class [ClassName] {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    ...
}
```

- Creamos un paquete `repositories`
- Creamos un interfaz repositorio `[Name]Repository`
	- Tiene que extender `CrudRepository` indicando el modelo (paso anterior) y el tipo de `clave primaria`
	- Se le puede añadir definiciones de funciones
- Inyectamos el repositorio a traves de la interfaz con sprint boot (`@Autowired`) en el servicio
- NO hace falta implementar la interfaz del repositorio

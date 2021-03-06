### Required dependencies:

        <dependency>
            <groupId>com.tekingb.tekboolexp</groupId>
            <artifactId>tekingb-tekboolexp</artifactId>
            <version>0.1.0-Alpha</version>
        </dependency>

       <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-jpa</artifactId>
       </dependency>

        <build>
                <plugins>
                    <plugin>
                        <groupId>com.mysema.maven</groupId>
                        <artifactId>apt-maven-plugin</artifactId>
                        <version>1.1.3</version>
                        <executions>
                            <execution>
                                <goals>
                                    <goal>process</goal>
                                </goals>
                                <configuration>
                                    <outputDirectory>target/generated-sources/java</outputDirectory>
                                    <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                                </configuration>
                            </execution>
                        </executions>
                        <dependencies>
                            <dependency>
                                <groupId>com.querydsl</groupId>
                                <artifactId>querydsl-apt</artifactId>
                                <version>${querydsl.version}</version>
                            </dependency>
                        </dependencies>
                    </plugin>
                </plugins>
            </build>

### Class

```sh
@Entity
@Table(name = "tentity")
public class tentity implements Serializable {

// Attributes
private String name;

// Getters and Setters

}
```

## Beans:
```sh
  @Bean
  public tekNumberPath tekNumberPath() {
    return new tekNumberPath();
  }

  @Bean
  public tekDatePath tekDatePath() {
    return new tekDatePath();
  }

  @Bean
  public tekPredicate predicate() {
    return new tekPredicate();
  }

  @Bean
  public tekBuilder builder() {
    return new tekBuilder();
  }

  @Bean
  public tekParamService tekParamService() {
    return new tekParam(0, 50, "name");
  }
```

### Repository.
```sh
@Repository
public interface tEntityRepository
    extends JpaRepository<tentity, UUID>, QuerydslPredicateExecutor<tentity> {}
```

### Service.

```
@Service
public class tentityService{

    public Page<tentity> findAll(BooleanExpression exp, Pageable pageRequest) {
    	return tentityRepository.findAll(exp, pageRequest);
    }

}
```

### Controller

```sh
@RestController
@RequestMapping("/api")
public class cityResource {


    private PathBuilder<tentity> entityPath = new PathBuilder<>(tentity.class, "tentity");
    private findAllParams findAllParams = new findAllParams();

    @Autowired
    private tekParamService tekParamService;

    @Autowired
    private tentityService tentityService;

    @RequestMapping(method = RequestMethod.GET, value = "/tentity/viewAll")

    public Iterable<tentity> findAll(@RequestParam(value = "search", required = true) String search,  @RequestParam(value = "sort", required = true) String sort, @RequestParam(value = "pagination", required = true) String pagination) {

    Page<tentity> pagetentity = buscar(search, sort, pagination);

    return pagetentity;

    }



    Page<tentity> buscar(String search, String sort, String pagination) {

    	findAllParams = tekParamService.find(search, sort, pagination, entityPath);

    	Pageable pageRequest = findAllParams.getPageRequest();

    	BooleanExpression exp = findAllParams.getExp();

    	return tentityService.findAll(exp, pageRequest);
    }

}
```



### Search:
				field1 field2 field3 key operator prefixValue value suffixValue


    field1: Define if a String search "ignore case" -> "*"

    field2: Define the search type:

    String: *
    UUID: ~
    Boolean: _

    Integer: -
    Long: {
    Double:[
    Big Decimal:}

    Localdate:!
    LocalDateTime: .
    ZonedDateTime: |
    OffsetDateTime: @


    field3: Define a "OR" connector -> "*"

    key: Field name.

    Operator:

    Equality: ":"
    Negation: "!"


    value : Value that we are looking for.

    prefixValue and suffixValue


	//String Search
    if (startWithAsterisk.equals(true) && endWithAsterisk.equals(true)) {
      logger.debug("CONTAINS");
      return "CONTAINS";
    } else if (startWithAsterisk.equals(true)) {
      logger.debug("ENDS_WITH");
      return "ENDS_WITH";
    } else if (endWithAsterisk.equals(true)) {
      logger.debug("STARTS_WITH");
      return "STARTS_WITH";
    } else {
      logger.debug("EQUAL");
      return "EQUAL";
    }

	//Numeric Search
    if (startWithAsterisk.equals(true) && endWithAsterisk.equals(true)) {
      logger.debug("BETWEEN");
      return "BETWEEN";
    } else if (startWithAsterisk.equals(true)) {
      logger.debug("GREATER_THAN");
      return "GREATER_THAN";
    } else if (endWithAsterisk.equals(true)) {
      logger.debug("LESS_THAN");
      return "LESS_THAN";
    } else {
      logger.debug("EQUAL");
      return "EQUAL";
    }


	//Date search
    if (criteria.getPrefix().equals("*") && criteria.getSuffix().equals("*")) {
      logger.debug("BETWEEN");
      return "BETWEEN";
    } else if (criteria.getPrefix().equals("") && criteria.getSuffix().equals("")) {
      logger.debug("EQUAL");
      return "EQUAL";
    } else if (criteria.getPrefix().equals("*") && criteria.getSuffix().equals("")) {
      logger.debug("AFTER");
      return "AFTER";
    } else if (criteria.getPrefix().equals("") && criteria.getSuffix().equals("*")) {
      logger.debug("BEFORE");
      return "BEFORE";
    } else if (criteria.getPrefix().equals("/") && criteria.getSuffix().equals("")) {
      logger.debug("GREATER_THAN");
      return "GREATER_THAN";
    } else if (criteria.getPrefix().equals("") && criteria.getSuffix().equals("/")) {
      logger.debug("LESS_THAN");
      return "LESS_THAN";
    } else if (criteria.getPrefix().equals("/") && criteria.getSuffix().equals("/")) {
      logger.debug("DAY OF MONTH");
      return "DAY OF MONTH";
    } else if (criteria.getPrefix().equals("!") && criteria.getSuffix().equals("")) {
      logger.debug("MONTH");
      return "MONTH";
    } else if (criteria.getPrefix().equals("") && criteria.getSuffix().equals("!")) {
      logger.debug("YEAR");
      return "YEAR";
    } else if (criteria.getPrefix().equals("!") && criteria.getSuffix().equals("!")) {
      logger.debug("YEAR_MONTH");
      return "YEAR_MONTH";
    } else if (criteria.getPrefix().equals("*") && criteria.getSuffix().equals("!")) {
      logger.debug("NULL");
      return "IS NULL";
    } else {
      return "EQUAL";
    }



### Sort

					field1 key operator value


    field1: Define if ignore case -> "*"

    key: Field name.

    Operator:

    NNullHandling: LAST: ":"
    NNullHandling: FIRST: "<"
    NullHandling: NATIVE: ">"

    value: "ASC" or "DESC"


### Pagination

Example: "page:0,size:50
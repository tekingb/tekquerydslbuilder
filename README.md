# TekQueryDSL Builder

A flexible and powerful query builder for Spring Boot applications using QueryDSL.

## Overview

TekQueryDSL Builder is a library that simplifies the creation of complex dynamic queries in Spring Boot applications. It provides a string-based query syntax that gets translated into QueryDSL expressions, allowing for flexible and type-safe database queries without writing complex query logic.

### How It Works

1. **Query String Processing**: 
   - The library takes a search string in a specific format (e.g., `**#name:*John*`)
   - Parses it into components (field type, field name, operator, value)
   - Converts these components into QueryDSL predicates

2. **Dynamic Query Building**:
   - Multiple conditions can be combined using AND/OR operators
   - Supports complex date operations (ranges, before/after, specific parts like month/year)
   - Handles null values and case sensitivity

3. **Type Safety**:
   - Each field type (`String`, `Integer`, `Date`, etc.) has specific operators and validations
   - Prevents invalid queries and type mismatches at runtime

### Example Usage

```java
// Search for users named "John" OR created after 2024-01-01
String searchQuery = "**#name:*John*,|#createdDate:*2024-01-01";

// Sort by name descending, nulls last
String sortQuery = "*name:desc";

// Page 0, 20 items per page
String paginationQuery = "page:0,size:20";

// Execute the query
findAllParams params = tekParamService.find(searchQuery, sortQuery, paginationQuery, entityPath);
Page<User> results = userService.findAll(params.getExp(), params.getPageRequest());
```

### Key Benefits

- **Flexibility**: Create complex queries through simple string parameters
- **Type Safety**: Built on QueryDSL's type-safe criteria API
- **Maintainability**: Centralized query processing logic
- **Performance**: Generates optimized database queries
- **Integration**: Seamlessly works with Spring Data JPA
- **Extensibility**: Easy to add new operators and field types

### Common Use Cases

1. **Advanced Search Forms**:
   - Build dynamic filters for data tables
   - Implement complex search functionality in admin panels
   - Create flexible API endpoints for mobile apps

2. **Report Generation**:
   - Filter data based on multiple criteria
   - Sort and paginate large datasets
   - Export filtered data

3. **Data Analysis**:
   - Query data with complex conditions
   - Perform date-based analysis
   - Handle null values and special cases

### Query Examples

1. **Complex User Search**:
```
// Find active users created in 2024 with email containing "example.com"
**#email:*example.com*,_#active:true,|#createdDate:!2024!
```

2. **Product Inventory**:
```
// Find products with stock between 10-50 and price greater than 100
{#stock:*10;50*,-#price:/100
```

3. **Date Range with Multiple Conditions**:
```
// Orders from last month with total amount > 1000
|#orderDate:!202402!,}#total:/1000
```

## Features
- Dynamic query building with complex search criteria
- Support for multiple data types and search operations
- Pagination and sorting
- Case-sensitive and case-insensitive search
- Date range queries
- Null handling

## Installation

Add the following dependencies to your `pom.xml`:

```xml
<!-- TekQueryDSL Builder -->
<dependency>
    <groupId>com.tekingb.tekboolexp</groupId>
    <artifactId>tekingb-tekboolexp</artifactId>
    <version>2.0.0</version>
</dependency>

<!-- QueryDSL Dependencies -->
<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-jpa</artifactId>
    <version>${querydsl.version}</version>
    <classifier>jakarta</classifier>
</dependency>

<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-apt</artifactId>
    <version>${querydsl.version}</version>
    <classifier>jakarta</classifier>
    <scope>provided</scope>
</dependency>
```

Configure the QueryDSL annotation processor:

```xml
<build>
    <plugins>
        <plugin>
            <groupId>com.mysema.maven</groupId>
            <artifactId>apt-maven-plugin</artifactId>
            <version>1.1.3</version>
            <executions>
                <execution>
                    <id>querydsl-process</id>
                    <goals>
                        <goal>process</goal>
                    </goals>
                    <configuration>
                        <outputDirectory>target/generated-sources/java</outputDirectory>
                        <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                        <options>
                            <querydsl.packageSuffix>.querydsl</querydsl.packageSuffix>
                        </options>
                    </configuration>
                </execution>
            </executions>
            <dependencies>
                <dependency>
                    <groupId>com.querydsl</groupId>
                    <artifactId>querydsl-apt</artifactId>
                    <version>${querydsl.version}</version>
                    <classifier>jakarta</classifier>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
```

## Configuration

### Required Beans
Register the following beans in your Spring Boot application:

```java
@Configuration
public class TekQueryDSLConfig {
    
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
        return new tekParam(0, 50, "name"); // Default page size and sort field
    }
}
```

### Entity Setup
Your entity class should implement Serializable:

```java
@Entity
@Table(name = "your_table")
public class YourEntity implements Serializable {
    @Id
    private UUID id;
    private String name;
    // Other fields, getters, and setters
}
```

### Repository
Extend both JpaRepository and QuerydslPredicateExecutor:

```java
@Repository
public interface YourEntityRepository extends 
    JpaRepository<YourEntity, UUID>, 
    QuerydslPredicateExecutor<YourEntity> {
}
```

### Service Layer
Implement the service layer to handle queries:

```java
@Service
public class YourEntityService {
    
    private final YourEntityRepository repository;
    
    public YourEntityService(YourEntityRepository repository) {
        this.repository = repository;
    }

    public Page<YourEntity> findAll(BooleanExpression exp, Pageable pageRequest) {
        return repository.findAll(exp, pageRequest);
    }
}
```

### Controller Implementation
Example REST controller using the query builder:

```java
@RestController
@RequestMapping("/api/entities")
public class YourEntityController {

    private final PathBuilder<YourEntity> entityPath;
    private final tekParamService tekParamService;
    private final YourEntityService service;

    public YourEntityController(
            tekParamService tekParamService,
            YourEntityService service) {
        this.entityPath = new PathBuilder<>(YourEntity.class, "yourEntity");
        this.tekParamService = tekParamService;
        this.service = service;
    }

    @GetMapping
    public Page<YourEntity> findAll(
            @RequestParam(required = true) String search,
            @RequestParam(required = true) String sort,
            @RequestParam(required = true) String pagination) {
        
        findAllParams params = tekParamService.find(search, sort, pagination, entityPath);
        return service.findAll(params.getExp(), params.getPageRequest());
    }
}
```

## Query Syntax

### Search Parameters

The search parameter follows this format:
```
field1 field2 field3 key operator prefixValue value suffixValue
```

#### Field Types (field2)
- `*` : String
- `~` : UUID
- `_` : Boolean
- `-` : Integer
- `{` : Long
- `[` : Double
- `}` : BigDecimal
- `!` : LocalDate
- `.` : LocalDateTime
- `|` : ZonedDateTime
- `@` : OffsetDateTime

#### Operators
- `:` : Equality
- `!` : Negation

#### String Search Examples
- Contains: `**#name:*John*`
- Starts with: `**#name:John*`
- Ends with: `**#name:*John`
- Exact match: `**#name:John`

#### Numeric Search Examples
- Between: `-#age:*18;25*`
- Greater than: `-#age:*18`
- Less than: `-#age:18*`
- Equals: `-#age:18`

#### Date Search Examples
- Between: `|#createdDate:*2024-01-01;2024-12-31*`
- After: `|#createdDate:*2024-01-01`
- Before: `|#createdDate:2024-12-31*`
- Specific date: `|#createdDate:2024-01-01`

### Sort Parameters
Format: `field1 key operator value`

Examples:
- Case-sensitive ascending: `name:asc`
- Case-insensitive descending: `*name:desc`
- Null handling last: `name:desc`
- Null handling first: `name<desc`

### Pagination Parameters
Format: `page:number,size:number`

Example: `page:0,size:20`

## License
MIT License
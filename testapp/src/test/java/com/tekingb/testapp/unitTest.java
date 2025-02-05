package com.tekingb.testapp;

// The error occurs because the Guava library (which contains com.google.common) is not included as a dependency in the project's pom.xml
import com.querydsl.core.types.dsl.PathBuilder;
import com.tekingb.tekboolexp.findAllParams;
import com.tekingb.tekboolexp.tekParamService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import jakarta.persistence.Entity;  // Update imports to use jakarta instead of javax
import com.google.common.collect.Iterables; // Add this import

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class unitTest {

  private final PathBuilder<tentity> entityPath = new PathBuilder<>(tentity.class, "tentity");

  private tekParamService tFind;

  private TestEntityManager entityManager;

  private tEntityRepository tEntityRepository;

  @Autowired
  public void settFind(tekParamService tFind) {
    this.tFind = tFind;
  }

  @Autowired
  public void setEntityManager(TestEntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Autowired
  public void settEntityRepository(tEntityRepository tEntityRepository) {
    this.tEntityRepository = tEntityRepository;
  }

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

  @BeforeAll
  public static void init() {
    System.out.println("BeforeAll init() method called");
  }

  @BeforeEach
  void init2() {
    System.out.println("BeforeEach init() method called");

    tutorial tut1 = new tutorial("Tut1", "Desc1", true);
    entityManager.persist(tut1);


    tentity tentity1 =
        new tentity(
            1,
            "tentity25",
            5,
            OffsetDateTime.parse("2018-05-04T00:00:00+00:00"),
            ZonedDateTime.parse("2018-05-04T00:00:00Z"),

            LocalDateTime.parse("2018-05-04T00:00:00"),
            LocalDate.parse("2018-05-04"),
            true,
            Long.parseLong("545234523"),
            new BigDecimal("55324.634123"),
            35.32344,
            tut1,
            UUID.fromString("38400000-8ff0-11bd-b23e-10b96e4ef00d"));
    entityManager.persist(tentity1);

    tentity tentity2 =
        new tentity(
            2,
            "tekEntity55",
            10,
            OffsetDateTime.parse("2018-10-04T00:00:00+00:00"),
            ZonedDateTime.parse("2018-10-04T00:00:00Z"),
            LocalDateTime.parse("2018-10-04T00:00:00"),
            LocalDate.parse("2018-10-04"),
            false,
            Long.parseLong("1045234523"),
            new BigDecimal("105324.634123"),
            310.32344,
            tut1,
            UUID.fromString("550043d1-aa26-3d0a-be76-1c6a8fe9a1ad"));
    entityManager.persist(tentity2);

    tentity tentity3 =
        new tentity(
            3,
            "tEntity25",
            10,
            OffsetDateTime.parse("2018-10-04T00:00:00+00:00"),
            ZonedDateTime.parse("2018-10-04T00:00:00Z"),
            LocalDateTime.parse("2018-10-04T00:00:00"),
            LocalDate.parse("2018-10-04"),
            true,
            Long.parseLong("1045234521"),
            new BigDecimal("105324.634123"),
            310.32344,
            tut1,
            UUID.fromString("550043d1-aa26-3d0a-be76-1c6a8fe9a1ad"));
    entityManager.persist(tentity3);

    tentity tentity4 =
        new tentity(
            4,
            "tekEntity25",
            8,
            OffsetDateTime.parse("2018-08-04T00:00:00+00:00"),
            ZonedDateTime.parse("2018-08-04T00:00:00Z"),
            LocalDateTime.parse("2018-08-04T00:00:00"),
            LocalDate.parse("2018-08-04"),
            true,
            Long.parseLong("845234523"),
            new BigDecimal("85324.634123"),
            38.32344,
            tut1,
            UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"));
    entityManager.persist(tentity4);

    tentity tentity5 =
        new tentity(
            5,
            "tentity25",
            20,
            OffsetDateTime.parse("2018-12-04T00:00:00+00:00"),
            ZonedDateTime.parse("2018-12-04T00:00:00Z"),
            LocalDateTime.parse("2018-12-04T00:00:00"),
            LocalDate.parse("2018-12-04"),
            true,
            Long.parseLong("2045234523"),
            new BigDecimal("205324.634123"),
            320.32344,
            tut1,
            UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"));
    entityManager.persist(tentity5);

    tentity tentity6 =
        new tentity(
            6,
            "tekEntity55",
            10,
            OffsetDateTime.parse("2018-10-04T00:00:00+00:00"),
            ZonedDateTime.parse("2018-10-04T00:00:00Z"),
            LocalDateTime.parse("2018-10-04T00:00:00"),
            LocalDate.parse("2018-10-04"),
            false,
            Long.parseLong("1045234523"),
            new BigDecimal("105324.634123"),
            310.32344,
            tut1,
            UUID.fromString("550043d1-aa26-3d0a-be76-1c6a8fe9a1ad"));
    entityManager.persist(tentity6);

    tentity tentity7 =
        new tentity(
            7,
            "tEntity25",
            9,
            OffsetDateTime.parse("2018-09-04T00:00:00+00:00"),
            ZonedDateTime.parse("2018-09-04T00:00:00Z"),
            LocalDateTime.parse("2018-09-04T00:00:00"),
            LocalDate.parse("2018-09-04"),
            true,
            Long.parseLong("945234521"),
            new BigDecimal("95324.634123"),
            39.32344,
            tut1,
            UUID.fromString("560043d1-aa26-3d0a-be76-1c6a8fe9a1ad"));
    entityManager.persist(tentity7);

    tentity tentity8 =
        new tentity(
            8,
            "tekEntity25",
            3,
            OffsetDateTime.parse("2008-03-09T12:00:00+00:00"),
            ZonedDateTime.parse("2008-03-09T12:00:00Z"),
            LocalDateTime.parse("2008-03-03T00:00:00"),
            LocalDate.parse("2008-03-03"),
            true,
            Long.parseLong("345234523"),
            new BigDecimal("35324.634123"),
            33.32344,
            tut1,
            UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"));
    entityManager.persist(tentity8);

    tentity tentity9 =
        new tentity(9, null, null, null, null, null, null, null, null, null, null, null, null);
    entityManager.persist(tentity9);
  }

  @Test
  @DisplayName("Query nested AND")
  public void query_nested_AND() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!/9/,#*#name:*Ent*",
            "*localDate:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(5, value, "Query nested AND fail");
  }

  @Test
  @DisplayName("Query nested OR")
  public void query_nested_OR() {
    findAllParams findAllParams =
        tFind.find(
            "#|*createdDatetime:/9/,#~*tid:550043d1-aa26-3d0a-be76-1c6a8fe9a1ad",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query nested OR fail");
  }

  @Test
  @DisplayName("Query page size")
  public void query_page_size() {
    findAllParams findAllParams =
        tFind.find("**#name:*Ent*", "*name:desc", "page:0,size:2", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(2, value, "Query page size fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Page")
  public void query_page() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle!10", "*name:desc", "page:2,size:2", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query Page fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query sort asc")
  public void query_sort_asc() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!/9/,#*#name:*Ent*",
            "lifeCycle:asc, code:asc",
            "page:0,size:3",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();

    tentity tentity0 = Iterables.getFirst(tEntities, null);
    tentity tentity1 = Iterables.get(tEntities, 1, null);
    tentity tentity2 = Iterables.get(tEntities, 2, null);

    long idData = tentity0 != null ? tentity0.getCode() : 0;
    long idData1 = tentity1 != null ? tentity1.getCode() : 0;
    long idData2 = tentity2 != null ? tentity2.getCode() : 0;

    assertAll(
        () ->
            assertEquals(
                3, value, "Query sort asc fail quantity: " + "Expected: 3 " + "Got: " + value),
        () ->
            assertEquals(
                4, idData, "Query sort asc first value: " + "Expected: 4 " + "Got: " + idData),
        () ->
            assertEquals(
                7, idData1, "Query sort asc second value: " + "Expected: 7 " + "Got: " + idData1),
        () ->
            assertEquals(
                2, idData2, "Query sort asc third value: " + "Expected: 2 " + "Got: " + idData2));
  }

  @Test
  @DisplayName("Query sort desc")
  public void query_sort_desc() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!/9/,#*#name:*Ent*",
            "lifeCycle:desc, code:desc",
            "page:0,size:3",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();

    tentity tentity0 = Iterables.getFirst(tEntities, null);
    tentity tentity1 = Iterables.get(tEntities, 1, null);
    tentity tentity2 = Iterables.get(tEntities, 2, null);

    long idData = tentity0 != null ? tentity0.getCode() : 0;
    long idData1 = tentity1 != null ? tentity1.getCode() : 0;
    long idData2 = tentity2 != null ? tentity2.getCode() : 0;

    assertAll(
        () ->
            assertEquals(
                3, value, "Query sort desc fail quantity: " + "Expected: 3 " + "Got: " + value),
        () ->
            assertEquals(
                6, idData, "Query sort desc first value: " + "Expected: 6 " + "Got: " + idData),
        () ->
            assertEquals(
                3, idData1, "Query sort desc second value: " + "Expected: 3 " + "Got: " + idData1),
        () ->
            assertEquals(
                2, idData2, "Query sort desc third value: " + "Expected: 2 " + "Got: " + idData2));
  }

  @Test
  @DisplayName("Query sort asc case ignore case")
  public void query_sort_asc_ignore_case() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime!/9/", "*name:asc, code:asc", "page:0,size:3", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();

    tentity tentity0 = Iterables.getFirst(tEntities, null);
    tentity tentity1 = Iterables.get(tEntities, 1, null);
    tentity tentity2 = Iterables.get(tEntities, 2, null);

    long idData = tentity0 != null ? tentity0.getCode() : 0;
    long idData1 = tentity1 != null ? tentity1.getCode() : 0;
    long idData2 = tentity2 != null ? tentity2.getCode() : 0;

    assertAll(
        () ->
            assertEquals(
                3,
                value,
                "Query sort ignore case asc fail quantity: " + "Expected: 3 " + "Got: " + value),
        () ->
            assertEquals(
                4,
                idData,
                "Query sort ignore case asc first value: " + "Expected: 4 " + "Got: " + idData),
        () ->
            assertEquals(
                2,
                idData1,
                "Query sort ignore case asc second value: " + "Expected: 2 " + "Got: " + idData1),
        () ->
            assertEquals(
                6,
                idData2,
                "Query sort ignore case asc third value: " + "Expected: 6 " + "Got: " + idData2));
  }

  @Test
  @DisplayName("Query sort asc case")
  public void query_sort_asc_case() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime!/9/", "name:asc, code:asc", "page:0,size:3", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();

    tentity tentity0 = Iterables.getFirst(tEntities, null);
    tentity tentity1 = Iterables.get(tEntities, 1, null);
    tentity tentity2 = Iterables.get(tEntities, 2, null);

    long idData = tentity0 != null ? tentity0.getCode() : 0;
    long idData1 = tentity1 != null ? tentity1.getCode() : 0;
    long idData2 = tentity2 != null ? tentity2.getCode() : 0;

    assertAll(
        () ->
            assertEquals(
                3, value, "Query sort case asc fail quantity: " + "Expected: 3 " + "Got: " + value),
        () ->
            assertEquals(
                3, idData, "Query sort case asc first value: " + "Expected: 3 " + "Got: " + idData),
        () ->
            assertEquals(
                7,
                idData1,
                "Query sort case asc second value: " + "Expected: 7 " + "Got: " + idData1),
        () ->
            assertEquals(
                4,
                idData2,
                "Query sort case asc third value: " + "Expected: 4 " + "Got: " + idData2));
  }

  @Test
  @DisplayName("Query sort integer asc null last")
  public void query_sort_integer_asc_null_last() {
    findAllParams findAllParams =
        tFind.find("#-#code!100", "lifeCycle:asc,code:asc", "page:0,size:9", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();

    tentity tentity0 = Iterables.getFirst(tEntities, null);
    tentity tentity1 = Iterables.get(tEntities, 1, null);
    tentity tentity2 = Iterables.get(tEntities, 2, null);

    long idData = tentity0 != null ? tentity0.getCode() : 0;
    long idData1 = tentity1 != null ? tentity1.getCode() : 0;
    long idData2 = tentity2 != null ? tentity2.getCode() : 0;

    assertAll(
        () ->
            assertEquals(
                9,
                value,
                "Query sort ignore case null first asc fail quantity: "
                    + "Expected: 9 "
                    + "Got: "
                    + value),
        () ->
            assertEquals(
                8,
                idData,
                "Query sort ignore case asc null first first value: "
                    + "Expected: 4 "
                    + "Got: "
                    + idData),
        () ->
            assertEquals(
                1,
                idData1,
                "Query sort ignore case asc null first second value: "
                    + "Expected: 2 "
                    + "Got: "
                    + idData1),
        () ->
            assertEquals(
                4,
                idData2,
                "Query sort ignore case asc null first third value: "
                    + "Expected: 6 "
                    + "Got: "
                    + idData2));
  }

  @Test
  @DisplayName("Query sort integer desc null last")
  public void query_sort_integer_desc_null_last() {
    findAllParams findAllParams =
        tFind.find("#-#code!100", "lifeCycle:desc,code:desc", "page:0,size:9", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();

    tentity tentity0 = Iterables.getFirst(tEntities, null);
    tentity tentity1 = Iterables.get(tEntities, 1, null);
    tentity tentity2 = Iterables.get(tEntities, 2, null);

    long idData = tentity0 != null ? tentity0.getCode() : 0;
    long idData1 = tentity1 != null ? tentity1.getCode() : 0;
    long idData2 = tentity2 != null ? tentity2.getCode() : 0;

    assertAll(
        () ->
            assertEquals(
                9,
                value,
                "Query sort ignore case null first asc fail quantity: "
                    + "Expected: 9 "
                    + "Got: "
                    + value),
        () ->
            assertEquals(
                5,
                idData,
                "Query sort ignore case asc null first first value: "
                    + "Expected: 4 "
                    + "Got: "
                    + idData),
        () ->
            assertEquals(
                6,
                idData1,
                "Query sort ignore case asc null first second value: "
                    + "Expected: 2 "
                    + "Got: "
                    + idData1),
        () ->
            assertEquals(
                3,
                idData2,
                "Query sort ignore case asc null first third value: "
                    + "Expected: 6 "
                    + "Got: "
                    + idData2));
  }

  @Test
  @DisplayName("Query sort integer asc null first")
  public void query_sort_integer_asc_null_first() {
    findAllParams findAllParams =
        tFind.find("#-#code!100", "lifeCycle<asc,code<asc", "page:0,size:9", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();

    tentity tentity0 = Iterables.getFirst(tEntities, null);
    tentity tentity1 = Iterables.get(tEntities, 1, null);
    tentity tentity2 = Iterables.get(tEntities, 2, null);

    long idData = tentity0 != null ? tentity0.getCode() : 0;
    long idData1 = tentity1 != null ? tentity1.getCode() : 0;
    long idData2 = tentity2 != null ? tentity2.getCode() : 0;

    assertAll(
        () ->
            assertEquals(
                9,
                value,
                "Query sort ignore case null first asc fail quantity: "
                    + "Expected: 9 "
                    + "Got: "
                    + value),
        () ->
            assertEquals(
                9,
                idData,
                "Query sort ignore case asc null first first value: "
                    + "Expected: 4 "
                    + "Got: "
                    + idData),
        () ->
            assertEquals(
                8,
                idData1,
                "Query sort ignore case asc null first second value: "
                    + "Expected: 2 "
                    + "Got: "
                    + idData1),
        () ->
            assertEquals(
                1,
                idData2,
                "Query sort ignore case asc null first third value: "
                    + "Expected: 6 "
                    + "Got: "
                    + idData2));
  }

  @Test
  @DisplayName("Query sort integer desc null first")
  public void query_sort_integer_desc_null_first() {
    findAllParams findAllParams =
        tFind.find("#-#code!100", "lifeCycle<desc,code<desc", "page:0,size:9", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();

    tentity tentity0 = Iterables.getFirst(tEntities, null);
    tentity tentity1 = Iterables.get(tEntities, 1, null);
    tentity tentity2 = Iterables.get(tEntities, 2, null);

    long idData = tentity0 != null ? tentity0.getCode() : 0;
    long idData1 = tentity1 != null ? tentity1.getCode() : 0;
    long idData2 = tentity2 != null ? tentity2.getCode() : 0;

    assertAll(
        () ->
            assertEquals(
                9,
                value,
                "Query sort ignore case null first asc fail quantity: "
                    + "Expected: 9 "
                    + "Got: "
                    + value),
        () ->
            assertEquals(
                9,
                idData,
                "Query sort ignore case asc null first first value: "
                    + "Expected: 4 "
                    + "Got: "
                    + idData),
        () ->
            assertEquals(
                5,
                idData1,
                "Query sort ignore case asc null first second value: "
                    + "Expected: 2 "
                    + "Got: "
                    + idData1),
        () ->
            assertEquals(
                6,
                idData2,
                "Query sort ignore case asc null first third value: "
                    + "Expected: 6 "
                    + "Got: "
                    + idData2));
  }

  @Test
  @DisplayName("Query string equal ignore case")
  public void query_string_equal_ignore_case() {
    findAllParams findAllParams =
        tFind.find("**#name:tentity25", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query string equal ignore case fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string equal case sensitive")
  public void query_string_equal_case_sensitive() {
    findAllParams findAllParams =
        tFind.find("#*#name:tentity25", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        2, value, "Query string equal case sensitive fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string equal ignore case negation")
  public void query_string_equal_ignore_case_negation() {
    findAllParams findAllParams =
        tFind.find("**#name!tentity25", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4,
        value,
        "Query string equal ignore case negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string contain")
  public void query_string_contain() {
    findAllParams findAllParams =
        tFind.find("**#name:*Ent*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(8, value, "Query string contain fail: " + "Expected: 8 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string contain case sensitive")
  public void query_string_contain_case_sensitive() {
    findAllParams findAllParams =
        tFind.find("#*#name:*Ent*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6, value, "Query string contain case sensitive fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string contain case negation")
  public void query_string_contain_ignore_case_negation() {
    findAllParams findAllParams =
        tFind.find("#*#name!*Ent*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        2, value, "Query string contain case negation fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string begin with ignore case")
  public void query_string_begin_with_ignore_case() {
    findAllParams findAllParams =
        tFind.find("**#name:tekE*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query string begin with ignore case fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string begin with case sensitive")
  public void query_string_begin_with_case_sensitive() {
    findAllParams findAllParams =
        tFind.find("-*#name:*tE*", "*name:desc.lifeCycle:asc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        value,
        2,
        value,
        "Query string begin with case sensitive fail: " + "Expected: 2 " + "Got: ");
  }

  @Test
  @DisplayName("Query string begin with case negation")
  public void query_string_contain_begin_with_case_negation() {
    findAllParams findAllParams =
        tFind.find("-*#name!*tE*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        value,
        6,
        value,
        "Query string begin with case negation_negation fail: " + "Expected: 6 " + "Got: ");
  }

  @Test
  @DisplayName("Query string ends with ignore case")
  public void query_string_ends_with_ignore_case() {
    findAllParams findAllParams =
        tFind.find("**#name:*25", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6, value, "Query string ends with ignore case fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string ends with case sensitive")
  public void query_string_ends_with_case_sensitive() {
    findAllParams findAllParams =
        tFind.find("-*#name:*Entity25", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4,
        value,
        "Query string ends with case sensitive fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query string ends with case negation")
  public void query_string_ends_begin_with_case_negation() {
    findAllParams findAllParams =
        tFind.find("-*#name!*Entity25*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4,
        value,
        "Query string ends with case negation_negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query UUID")
  public void query_uuid() {
    findAllParams findAllParams =
        tFind.find(
            "*~#tid:550043d1-aa26-3d0a-be76-1c6a8fe9a1ad",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query UUID fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query UUID negation")
  public void query_uuid_negation() {
    findAllParams findAllParams =
        tFind.find(
            "*~#tid!550043d1-aa26-3d0a-be76-1c6a8fe9a1ad",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(5, value, "Query UUID negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Boolean True")
  public void query_boolean_true() {
    findAllParams findAllParams =
        tFind.find("*_#published:true", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(6, value, "Query Boolean True fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Boolean False")
  public void query_boolean_false() {
    findAllParams findAllParams =
        tFind.find("*_#published:false", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(2, value, "Query Boolean False fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Integer Equal")
  public void query_integer_equal() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle:10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query Integer Equal fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Integer Equal Negation")
  public void query_integer_equal_negation() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query Integer Equal Negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Integer Between")
  public void query_integer_between() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle:*10;20*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query Integer Between fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Integer Between Negation")
  public void query_integer_between_negation() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle!*10;20*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query Integer Between Negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Integer greater than")
  public void query_integer_greater_than() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle:*9", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(5, value, "Query Integer greater than fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Integer greater than negation")
  public void query_integer_greater_than_negation() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle!*9", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3, value, "Query Integer greater than negation fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Integer less than")
  public void query_integer_less_than() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle:7*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(2, value, "Query Integer less than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query Integer less than negation")
  public void query_integer_less_than_negation() {
    findAllParams findAllParams =
        tFind.find("#-#lifeCycle!7*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6, value, "Query Integer less than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query double equal than")
  public void query_double_equal() {
    findAllParams findAllParams =
        tFind.find("#;#quantityDouble:310.32344", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query Double equal fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query double equal negation")
  public void query_double_equal_negation() {
    findAllParams findAllParams =
        tFind.find("#;#quantityDouble!310.32344", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(5, value, "Query Double equal negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query double Between")
  public void query_double_between() {
    findAllParams findAllParams =
        tFind.find(
            "#;#quantityDouble:*310.32344;320.32344*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query double Between fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query double Between Negation")
  public void query_double_between_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#;#quantityDouble!*310.32344;320.32344*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query double Between Negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query double greater than")
  public void query_double_greater_than() {
    findAllParams findAllParams =
        tFind.find("#;#quantityDouble:*39.32344", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(5, value, "Query double greater than fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query double greater than negation")
  public void query_double_greater_than_negation() {
    findAllParams findAllParams =
        tFind.find("#;#quantityDouble!*39.32344", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3, value, "Query double greater than negation fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query double less than")
  public void query_double_less_than() {
    findAllParams findAllParams =
        tFind.find("#;#quantityDouble:37.32344*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(2, value, "Query Integer less than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query double less than negation")
  public void query_double_less_than_negation() {
    findAllParams findAllParams =
        tFind.find("#;#quantityDouble!37.32344*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6, value, "Query double less than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query long equal than")
  public void query_long_equal() {
    findAllParams findAllParams =
        tFind.find("#(#quantity:945234521", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query long equal fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query long equal negation")
  public void query_long_equal_negation() {
    findAllParams findAllParams =
        tFind.find("#(#quantity!945234521", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(7, value, "Query long equal negation fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query long Between")
  public void query_long_between() {
    findAllParams findAllParams =
        tFind.find(
            "#(#quantity:*545234521;1045234521*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query long Between fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query long Between Negation")
  public void query_long_between_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#(#quantity!*545234521;1045234521*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query long Between Negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query long greater than")
  public void query_long_greater_than() {
    findAllParams findAllParams =
        tFind.find("#(#quantity:*945234521", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(5, value, "Query long greater than fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query long greater than negation")
  public void query_long_greater_than_negation() {
    findAllParams findAllParams =
        tFind.find("#(#quantity!*945234521", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3, value, "Query long greater than negation fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query long less than")
  public void query_long_less_than() {
    findAllParams findAllParams =
        tFind.find("#(#quantity:745234521*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(2, value, "Query Integer less than fail: " + "Expected: 2 " + "Got: " + value);
  }


  @Test
  @DisplayName("Query long less than negation")
  public void query_long_less_than_negation() {
    findAllParams findAllParams =
        tFind.find("#(#quantity!745234521*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6, value, "Query long less than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query big decimal Between")
  public void query_big_decimal_between() {
    findAllParams findAllParams =
        tFind.find("#)#price:*105320.6;205326.6*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query big-decimal Between fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query big decimal Between Negation")
  public void query_big_decimal_between_negation() {
    findAllParams findAllParams =
        tFind.find("#)#price!*105320.6;205326.6*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query big-decimal Between Negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query big decimal greater than")
  public void query_big_decimal_greater_than() {
    findAllParams findAllParams =
        tFind.find("#)#price:*95321", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query big-decimal greater than fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query big decimal greater than negation")
  public void query_big_decimal_greater_than_negation() {
    findAllParams findAllParams =
        tFind.find("#)#price!*95321", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3,
        value,
        "Query big-decimal greater than negation fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query big decimal less than")
  public void query_big_decimal_less_than() {
    findAllParams findAllParams =
        tFind.find("#)#price:75325*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(2, value, "Query big-decimal less than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query big decimal less than negation")
  public void query_big_decimal_less_than_negation() {
    findAllParams findAllParams =
        tFind.find("#)#price!75325*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6, value, "Query big-decimal less than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate between")
  public void query_local_date_between() {
    findAllParams findAllParams =
        tFind.find(
            "#!#localDate:*2018-10-04;2018-12-04*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query LocalDate between fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate between negation")
  public void query_local_date_between_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#!#localDate!*2018-10-04;2018-12-04*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query LocalDate between negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate Equal")
  public void query_localDate_equal() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:2018-10-04", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query localDate Equal fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate Equal Negation")
  public void query_localDate_equal_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!2018-10-04", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query localDate Equal Negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate after than")
  public void query_localDate_after_than() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:*2018-09-04", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query localDate after than fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate after than negation")
  public void query_localDate_after_than_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!*2018-09-04", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query localDate after than negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate before than")
  public void query_localDate_before_than() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:2018-07-04*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(2, value, "Query localDate before than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate before than negation")
  public void query_localDate_before_than_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!2018-07-04*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6, value, "Query localDate before than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate greater than")
  public void query_localDate_greater_than() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:/2018-09-04", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query localDate greater than fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate greater than negation")
  public void query_localDate_greater_than_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!/2018-09-04", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3,
        value,
        "Query localDate greater than negation fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate less than")
  public void query_localDate_less_than() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:2018-07-04/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(2, value, "Query localDate less than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate less than negation")
  public void query_localDate_less_than_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!2018-07-04/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6, value, "Query localDate less than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate dayOfMonth")
  public void query_localDate_dayOfMonth() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:/4/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(7, value, "Query localDate dayOfMonth fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate dayOfMonth negation")
  public void query_localDate_dayOfMonth_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!/4/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        1, value, "Query localDate dayOfMonth negation fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate month")
  public void query_localDate_month() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query localDate month fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate month negation")
  public void query_localDate_month_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query localDate month negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate year")
  public void query_localDate_year() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:2008!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query localDate year fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate year negation")
  public void query_localDate_year_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!2008!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        7, value, "Query localDate year negation fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate yearMonth")
  public void query_localDate_yearMonth() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:!201810!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query localDate yearMonth fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate yearMonth negation")
  public void query_localDate_yearMonth_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!!201810!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query localDate yearMonth negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate null")
  public void query_localDate_null() {
    findAllParams findAllParams =
        tFind.find("#!#localDate:*Null!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query localDate null fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query LocalDate null negation")
  public void query_localDate_null_negation() {
    findAllParams findAllParams =
        tFind.find("#!#localDate!*Null!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        8, value, "Query localDate null negation fail: " + "Expected: 8 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime between")
  public void query_localDateTime_between() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime:*2018-10-04T00:00:00;2018-12-04T00:00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query localDateTime between fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime between negation")
  public void query_localDateTime_between_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime!*2018-10-04T00:00:00;2018-12-04T00:00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query localDateTime between negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime Equal")
  public void query_localDateTime_equal() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime:2018-10-04T00:00:00", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query localDateTime Equal fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime Equal Negation")
  public void query_localDateTime_equal_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime!2018-10-04T00:00:00", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query localDateTime Equal Negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime after than")
  public void query_localDateTime_after_than() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime:*2018-09-04T00:00:00", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query localDateTime after than fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime after than negation")
  public void query_localDateTime_after_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime!*2018-09-04T00:00:00", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4,
        value,
        "Query localDateTime after than negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime before than")
  public void query_localDateTime_before_than() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime:2018-07-04T00:00:00*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        2, value, "Query localDateTime before than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime before than negation")
  public void query_localDateTime_before_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime!2018-07-04T00:00:00*", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6,
        value,
        "Query localDateTime before than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime greater than")
  public void query_localDateTime_greater_than() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime:/2018-09-04T00:00:00", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query localDateTime greater than fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime greater than negation")
  public void query_localDateTime_greater_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime!/2018-09-04T00:00:00", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3,
        value,
        "Query localDateTime greater than negation fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime less than")
  public void query_localDateTime_less_than() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime:2018-07-04T00:00:00/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        2, value, "Query localDateTime less than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime less than negation")
  public void query_localDateTime_less_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#.#localDatetime!2018-07-04T00:00:00/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6,
        value,
        "Query localDateTime less than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime dayOfMonth")
  public void query_localDateTime_dayOfMonth() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime:/4/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        7, value, "Query localDateTime dayOfMonth fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime dayOfMonth negation")
  public void query_localDateTime_dayOfMonth_negation() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime!/4/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        1,
        value,
        "Query localDateTime dayOfMonth negation fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime month")
  public void query_localDateTime_month() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime:!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query localDateTime month fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime month negation")
  public void query_localDateTime_month_negation() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime!!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query localDateTime month negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime year")
  public void query_localDateTime_year() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime:2008!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query localDateTime year fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime year negation")
  public void query_localDateTime_year_negation() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime!2008!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        7, value, "Query localDateTime year negation fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime yearMonth")
  public void query_localDateTime_yearMonth() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime:!201810!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3, value, "Query localDateTime yearMonth fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime yearMonth negation")
  public void query_localDateTime_yearMonth_negation() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime!!201810!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5,
        value,
        "Query localDateTime yearMonth negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime null")
  public void query_localDateTime_null() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime:*Null!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query localDateTime null fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query localDateTime null negation")
  public void query_localDateTime_null_negation() {
    findAllParams findAllParams =
        tFind.find("#.#localDatetime!*Null!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        8, value, "Query localDateTime null negation fail: " + "Expected: 8 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime between")
  public void query_zonedDateTime_between() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime:*2018-10-04T00:00:00.000+00:00;2018-12-04T00:00:00.000+00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(4, value, "Query zonedDateTime between fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime between negation")
  public void query_zonedDateTime_between_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!*2018-10-04T00:00:00.000+00:00;2018-12-04T00:00:00.000+00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query zonedDateTime between negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime Equal")
  public void query_zonedDateTime_equal() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime:2018-10-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query zonedDateTime Equal fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime Equal Negation")
  public void query_zonedDateTime_equal_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!2018-10-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query zonedDateTime Equal Negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime after than")
  public void query_zonedDateTime_after_than() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime:*2018-09-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query zonedDateTime after than fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime after than negation")
  public void query_zonedDateTime_after_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!*2018-09-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4,
        value,
        "Query zonedDateTime after than negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime before than")
  public void query_zonedDateTime_before_than() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime:2018-07-04T00:00:00.000+00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        2, value, "Query zonedDateTime before than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime before than negation")
  public void query_zonedDateTime_before_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!2018-07-04T00:00:00.000+00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6,
        value,
        "Query zonedDateTime before than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime greater than")
  public void query_zonedDateTime_greater_than() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime:/2018-09-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query zonedDateTime greater than fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime greater than negation")
  public void query_zonedDateTime_greater_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!/2018-09-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3,
        value,
        "Query zonedDateTime greater than negation fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime less than")
  public void query_zonedDateTime_less_than() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime:2018-07-04T00:00:00.000+00:00/",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        2, value, "Query zonedDateTime less than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime less than negation")
  public void query_zonedDateTime_less_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#|#createdDatetime!2018-07-04T00:00:00.000+00:00/",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6,
        value,
        "Query zonedDateTime less than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime dayOfMonth")
  public void query_zonedDateTime_dayOfMonth() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime:/9/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        1,
        value,
        "Query zonedDateTime dayOfMonth fail, May fail if your timezone >= +-12"
            + "Expected: 1 "
            + "Got: "
            + value);
  }

  @Test
  @DisplayName("Query zonedDateTime dayOfMonth negation")
  public void query_zonedDateTime_dayOfMonth_negation() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime!/9/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        7,
        value,
        "Query zonedDateTime dayOfMonth negation fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime month")
  public void query_zonedDateTime_month() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime:!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query zonedDateTime month fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime month negation")
  public void query_zonedDateTime_month_negation() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime!!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query zonedDateTime month negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime year")
  public void query_zonedDateTime_year() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime:2008!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query zonedDateTime year fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime year negation")
  public void query_zonedDateTime_year_negation() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime!2008!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        7, value, "Query zonedDateTime year negation fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime yearMonth")
  public void query_zonedDateTime_yearMonth() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime:!201810!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3, value, "Query zonedDateTime yearMonth fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime yearMonth negation")
  public void query_zonedDateTime_yearMonth_negation() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime!!201810!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5,
        value,
        "Query zonedDateTime yearMonth negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime null")
  public void query_zonedDateTime_null() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime:*Null!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query zonedDateTime null fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query zonedDateTime null negation")
  public void query_zonedDateTime_null_negation() {
    findAllParams findAllParams =
        tFind.find("#|#createdDatetime!*Null!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        8, value, "Query zonedDateTime null negation fail: " + "Expected: 8 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime between")
  public void query_offsetDateTime_between() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime:*2018-10-04T00:00:00.000+00:00;2018-12-04T00:00:00.000+00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query offsetDateTime between fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime between negation")
  public void query_offsetDateTime_between_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime!*2018-10-04T00:00:00.000+00:00;2018-12-04T00:00:00.000+00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4,
        value,
        "Query offsetDateTime between negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime Equal")
  public void query_offsetDateTime_equal() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime:2018-10-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query offsetDateTime Equal fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime Equal Negation")
  public void query_offsetDateTime_equal_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime!2018-10-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query offsetDateTime Equal Negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime after than")
  public void query_offsetDateTime_after_than() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime:*2018-09-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4, value, "Query offsetDateTime after than fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime after than negation")
  public void query_offsetDateTime_after_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime!*2018-09-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        4,
        value,
        "Query offsetDateTime after than negation fail: " + "Expected: 4 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime before than")
  public void query_offsetDateTime_before_than() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime:2018-07-04T00:00:00.000+00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        2, value, "Query offsetDateTime before than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime before than negation")
  public void query_offsetDateTime_before_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime!2018-07-04T00:00:00.000+00:00*",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6,
        value,
        "Query offsetDateTime before than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime greater than")
  public void query_offsetDateTime_greater_than() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime:/2018-09-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query offsetDateTime greater than fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime greater than negation")
  public void query_offsetDateTime_greater_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime!/2018-09-04T00:00:00.000+00:00",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3,
        value,
        "Query offsetDateTime greater than negation fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime less than")
  public void query_offsetDateTime_less_than() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime:2018-07-04T00:00:00.000+00:00/",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        2, value, "Query offsetDateTime less than fail: " + "Expected: 2 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime less than negation")
  public void query_offsetDateTime_less_than_negation() {
    findAllParams findAllParams =
        tFind.find(
            "#@#modifiedDatetime!2018-07-04T00:00:00.000+00:00/",
            "*name:desc",
            "page:0,size:50",
            entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        6,
        value,
        "Query offsetDateTime less than negation fail: " + "Expected: 6 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime dayOfMonth")
  public void query_offsetDateTime_dayOfMonth() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime:/9/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        1,
        value,
        "Query offsetDateTime dayOfMonth fail, May fail if your timezone >= +-12"
            + "Expected: 1 "
            + "Got: "
            + value);
  }

  @Test
  @DisplayName("Query offsetDateTime dayOfMonth negation")
  public void query_offsetDateTime_dayOfMonth_negation() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime!/9/", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        7,
        value,
        "Query offsetDateTime dayOfMonth negation fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime month")
  public void query_offsetDateTime_month() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime:!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(3, value, "Query offsetDateTime month fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime month negation")
  public void query_offsetDateTime_month_negation() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime!!10", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5, value, "Query offsetDateTime month negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime year")
  public void query_offsetDateTime_year() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime:2008!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query offsetDateTime year fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime year negation")
  public void query_offsetDateTime_year_negation() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime!2008!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        7, value, "Query offsetDateTime year negation fail: " + "Expected: 7 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime yearMonth")
  public void query_offsetDateTime_yearMonth() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime:!201810!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        3, value, "Query offsetDateTime yearMonth fail: " + "Expected: 3 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime yearMonth negation")
  public void query_offsetDateTime_yearMonth_negation() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime!!201810!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        5,
        value,
        "Query offsetDateTime yearMonth negation fail: " + "Expected: 5 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime null")
  public void query_offsetDateTime_null() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime:*Null!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(1, value, "Query offsetDateTime null fail: " + "Expected: 1 " + "Got: " + value);
  }

  @Test
  @DisplayName("Query offsetDateTime null negation")
  public void query_offsetDateTime_null_negation() {
    findAllParams findAllParams =
        tFind.find("#@#modifiedDatetime!*Null!", "*name:desc", "page:0,size:50", entityPath);
    Iterable<tentity> tEntities =
        tEntityRepository.findAll(findAllParams.getExp(), findAllParams.getPageRequest());
    long value = StreamSupport.stream(tEntities.spliterator(), false).count();
    assertEquals(
        8, value, "Query offsetDateTime null negation fail: " + "Expected: 8 " + "Got: " + value);
  }
}

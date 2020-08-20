package com.tekingb.tekboolexp;

public class SearchCriteria {

  private String key;
  private String keyType;
  private String operation;
  private Object value;
  private boolean orPredicate;
  private boolean ignoreCase;

  private String prefix;
  private String suffix;

  public SearchCriteria(
      final String orPredicate,
      final String key,
      final String operation,
      final Object value,
      final String keyType,
      String prefix,
      String suffix,
      final String ignoreCase) {

    super();

    this.orPredicate = orPredicate.equals("*");

    this.ignoreCase = ignoreCase.equals("*");

    this.key = key;
    this.keyType = keyType;
    this.operation = operation;
    this.value = value;
    this.prefix = prefix;
    this.suffix = suffix;
  }

  public boolean isIgnoreCase() {
    return ignoreCase;
  }

  public void setIgnoreCase(boolean ignoreCase) {
    this.ignoreCase = ignoreCase;
  }

  public String getKey() {
    return key;
  }

  public void setKey(final String key) {
    this.key = key;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(final String operation) {
    this.operation = operation;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(final Object value) {
    this.value = value;
  }

  public boolean isOrPredicate() {
    return orPredicate;
  }

  public void setOrPredicate(boolean orPredicate) {
    this.orPredicate = orPredicate;
  }

  public String getKeyType() {
    return keyType;
  }

  public void setKeyType(String keyType) {
    this.keyType = keyType;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(String suffix) {
    this.suffix = suffix;
  }

  @Override
  public String toString() {
    return "SearchCriteria{"
        + "key='"
        + key
        + '\''
        + ", keyType='"
        + keyType
        + '\''
        + ", operation='"
        + operation
        + '\''
        + ", value="
        + value
        + ", orPredicate="
        + orPredicate
        + ", ignoreCase="
        + ignoreCase
        + ", prefix='"
        + prefix
        + '\''
        + ", suffix='"
        + suffix
        + '\''
        + '}';
  }
}

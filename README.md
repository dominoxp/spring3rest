# spring3rest
Example for spring3 and openapi generation with reactive and non reactive.
Uses MongoDB as data source, can be replaced with any other db + dependencies to test.
Openapi annotations are extended by x-enum-varnames annotation.
Non optional fields (default every field) are annotated/threated as required if not annotated with @Schema(requiredMode = NOT_REQUIRED), @JsonProperty(required = false) or of type Optional<T>


## Branches: 
### master = swagger + openapi + reactive
### non_reactive = swagger + openapi + rest-data ([currently no reactive support](https://github.com/spring-projects/spring-data-rest/issues/1299))

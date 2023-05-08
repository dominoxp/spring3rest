package com.example.rest_demo.config;

import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.swagger.v3.core.jackson.SwaggerAnnotationIntrospector;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;


public class SpringDocRequiredHandler extends SimpleModule {

    @Override
    public void setupModule(SetupContext context) {
        context.insertAnnotationIntrospector(new RespectSchemaRequiredAnnotationIntrospector());
    }

    /**
     * The type Respect schema required annotation introspector.
     */
    private static class RespectSchemaRequiredAnnotationIntrospector extends
        SwaggerAnnotationIntrospector {

        @Override
        public Boolean hasRequiredMarker(AnnotatedMember annotatedMember) {
            Schema schemaAnnotation = annotatedMember.getAnnotation(Schema.class);
            if (schemaAnnotation != null) {
                Schema.RequiredMode requiredMode = schemaAnnotation.requiredMode();
                if (requiredMode != Schema.RequiredMode.NOT_REQUIRED) {
                    return true;
                } else if (StringUtils.isNotEmpty(schemaAnnotation.defaultValue())) {
                    return false;
                }
            }

            Boolean jsonAnnotation = super.hasRequiredMarker(annotatedMember);

            if (jsonAnnotation != null) {
                return jsonAnnotation;
            }

            if (annotatedMember.getMember() instanceof Method method) {
                return !method.getReturnType().isNestmateOf(Optional.class);
            }
            if (annotatedMember.getMember() instanceof Field field) {
                return !field.getType().isNestmateOf(Optional.class);
            }

            return true;
        }
    }
}
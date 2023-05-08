package com.example.rest_demo.config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.media.Schema;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class EnumModelResolver extends ModelResolver {

    public EnumModelResolver(ObjectMapper mapper) {
        super(mapper);
    }

    @Override
    public Schema resolve(
        AnnotatedType annotatedType, ModelConverterContext context, Iterator<ModelConverter> next) {
        Schema schema = super.resolve(annotatedType, context, next);

        final JavaType type;
        if (annotatedType.getType() instanceof JavaType javaType) {
            type = javaType;
        } else {
            type = _mapper.constructType(annotatedType.getType());
        }

        if (type.isEnumType()) {
            List<String> names = Arrays.stream(type.getRawClass().getDeclaredFields())
                .filter(e -> e.getType().equals(type.getRawClass()))
                .map(Field::getName)
                .toList();

            schema.addExtension("x-enum-varnames", names);
        }

        return schema;
    }
}

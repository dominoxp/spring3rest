package com.example.rest_demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import java.util.Optional;
import org.springdoc.core.providers.ActuatorProvider;
import org.springdoc.core.providers.CloudFunctionProvider;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.core.providers.RepositoryRestResourceProvider;
import org.springdoc.core.providers.RouterFunctionProvider;
import org.springdoc.core.providers.SecurityOAuth2Provider;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.providers.SpringWebProvider;
import org.springdoc.core.providers.WebConversionServiceProvider;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.webmvc.core.service.RequestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({RequestService.class, GenericResponseService.class})
@Configuration
public class SpringDocConfig {

    @Bean
    SpringDocProviders springDocProviders(
        Optional<ActuatorProvider> actuatorProvider,
        Optional<CloudFunctionProvider> springCloudFunctionProvider,
        Optional<SecurityOAuth2Provider> springSecurityOAuth2Provider,
        Optional<RepositoryRestResourceProvider> repositoryRestResourceProvider,
        Optional<RouterFunctionProvider> routerFunctionProvider,
        Optional<SpringWebProvider> springWebProvider,
        Optional<WebConversionServiceProvider> webConversionServiceProvider,
        ObjectMapperProvider objectMapperProvider) {
        objectMapperProvider.jsonMapper().registerModule(new SpringDocRequiredHandler());
        return new SpringDocProviders(actuatorProvider, springCloudFunctionProvider,
            springSecurityOAuth2Provider, repositoryRestResourceProvider, routerFunctionProvider,
            springWebProvider, webConversionServiceProvider, objectMapperProvider);
    }

    @Bean
    public ModelResolver modelResolver(ObjectMapper mapper) {
        return new EnumModelResolver(mapper);
    }
}

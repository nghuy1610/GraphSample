package com.huyha.graphsample;

import com.huyha.graphsample.fetcher.BookFetcher;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GraphQlProvider {
    private final BookFetcher bookFetcher;

    private GraphQL graphQL;

    @Bean
    public GraphQL getGraphQL() {
        return this.graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/schema.graphqls")))) {
            String sdl = reader.lines().collect(Collectors.joining());
            GraphQLSchema schema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(schema).queryExecutionStrategy(new AsyncExecutionStrategy(params -> {
            ExceptionWhileDataFetching exception = new ExceptionWhileDataFetching(params.getPath(), new Exception(), params.getSourceLocation());
            return DataFetcherExceptionHandlerResult.newResult().error(exception).build();
        })).build();
        }
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry registry = new SchemaParser().parse(sdl);
        RuntimeWiring wiring = buildRuntimeWiring();
        return new SchemaGenerator().makeExecutableSchema(registry, wiring);
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("getBookByName", bookFetcher))
                .build();
    }

}

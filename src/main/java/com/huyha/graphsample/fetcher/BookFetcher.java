package com.huyha.graphsample.fetcher;

import com.huyha.graphsample.schema.BookDto;
import com.huyha.graphsample.service.FetcherService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Component
public class BookFetcher implements DataFetcher<CompletableFuture<BookDto>> {
    public final FetcherService fetcherService;

    @Override
    public CompletableFuture<BookDto> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return CompletableFuture.supplyAsync(() -> fetcherService.findBookByName(dataFetchingEnvironment.getArgument("name")));
    }
}

package com.udacity.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 先extends RuntimeException, 再 详细的implements GraphQLError,
 * graphQLError 是通过extension field来实现的。
 * 这是一个hashMap 我们把错误信息<key, value> 放进去 从而可以给console返回多余的报错信息。
 * TODO: 三个override:
 *
 */
public class DogNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public DogNotFoundException(String message, Long invalidId) {
        super(message);
        extensions.put("invalidId", invalidId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}

package com.kwabena.schoolmanagementsystem.services.dataservice_write.transformer;

public interface Transformer <T, R> {
    T transform(R request);
}

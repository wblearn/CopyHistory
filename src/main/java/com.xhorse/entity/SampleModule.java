package com.xhorse.entity;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.xhorse.service.ICopyHistoryService;
import com.xhorse.service.impl.CopyHistoryServiceImpl;

public class SampleModule extends AbstractModule {
    @Override
    public void configure() {
        bind(ICopyHistoryService.class).annotatedWith(Names.named("simple")).to(CopyHistoryServiceImpl.class);
    }
}

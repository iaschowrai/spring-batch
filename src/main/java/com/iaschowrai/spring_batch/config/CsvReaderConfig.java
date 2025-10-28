package com.iaschowrai.spring_batch.config;

import com.iaschowrai.spring_batch.entity.Organization;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class CsvReaderConfig {

    @Value("${app.cvs.resource}")
    private String csvResourcePath;


    @Bean
    public FlatFileItemReader<Organization> organizationItemReader(){
        FlatFileItemReader<Organization> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource(csvResourcePath));
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());

        return reader;
    }

    private LineMapper<Organization> lineMapper() {

        DefaultLineMapper<Organization> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(
                "organizationId",
                "name",
                "website",
                "country",
                "description",
                "founded",
                "industry",
                "numberOfEmployees"
        );

        BeanWrapperFieldSetMapper<Organization> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Organization.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }


}

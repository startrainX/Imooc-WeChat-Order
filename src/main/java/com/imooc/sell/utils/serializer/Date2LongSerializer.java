package com.imooc.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


import java.io.IOException;
import java.util.Date;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/8 15:34
 */
public class Date2LongSerializer extends JsonSerializer<Date>{
    @Override
    public void serialize(Date data, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(data.getTime() / 1000);
    }
}

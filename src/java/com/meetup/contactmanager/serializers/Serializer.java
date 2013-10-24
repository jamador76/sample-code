package com.meetup.contactmanager.serializers;

import java.io.InputStream;
import java.util.List;

public interface Serializer<T> {
    //public T deserialize(InputStream inputStream);
    public List<T> deserialize(InputStream inputStream);
    //TODO: add serialize method
}
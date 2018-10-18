package io.alfredux.reactivetest;

import java.util.List;

public interface MyEventListener<String> {

    void onDataChunk(List<String> chunk);

    void processComplete();
    
}

package com.theinhnam.schooldata.services.gpt;

import java.util.List;

public interface IGptService {
    List<String> extractMajors(String text);
}

package com.theinhnam.schooldata.services.gpt;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GptServiceImpl implements IGptService{
    @Override
    public List<String> extractMajors(String text) {
        // FIXME Hard code, use gpt instead
        text = text.toLowerCase();
        List<String> result = new ArrayList<>();
        if (text.contains("ai") || text.contains("trí tuệ")) result.add("AI");
        if (text.contains("thiết kế") || text.contains("design")) result.add("DESIGN");
        if (result.isEmpty()) result.add("IT");
        return result;
    }
}

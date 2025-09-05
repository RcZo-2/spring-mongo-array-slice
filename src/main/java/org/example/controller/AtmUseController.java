package org.example.controller;

import org.example.dto.AtmUseDto;
import org.example.dto.AtmUseResponseDto;
import org.example.dto.TokenPageRequestDto;
import org.example.model.AtmUse;
import org.example.repository.AtmUseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

@RestController
@RequestMapping("/api/atm-use")
public class AtmUseController {

    @Autowired
    private AtmUseRepository atmUseRepository;

    @PostMapping
    public AtmUseResponseDto getAllAtmUse(@RequestBody TokenPageRequestDto pageRequest) {
        final int size = 5;
        int page;

        String inquiryKey = pageRequest.getInquiryKey();

        if ("init".equals(inquiryKey)) {
            page = 0;
        } else {
            try {
                page = Integer.parseInt(inquiryKey);
                if (page <= 0) { // Subsequent pages must be > 0
                    return new AtmUseResponseDto(java.util.Collections.emptyList(), null);
                }
            } catch (NumberFormatException e) {
                // Invalid key format
                return new AtmUseResponseDto(java.util.Collections.emptyList(), null);
            }
        }

        int skip = page * size;
        List<AtmUseDto> results = atmUseRepository.findAtmUseWithPagination(skip, size).stream()
                .flatMap(atmUse -> Arrays.stream(atmUse.getAtmuse())
                        .map(s -> {
                            String[] parts = s.split(",");
                            return new AtmUseDto(parts[0], parts[1]);
                        }))
                .collect(Collectors.toList());

        String nextInquiryKey = null;
        if (!results.isEmpty()) {
            nextInquiryKey = Integer.toString(page + 1);
        }

        return new AtmUseResponseDto(results, nextInquiryKey);
    }
}

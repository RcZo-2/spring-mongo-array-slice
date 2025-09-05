package org.example.dto;

import java.util.List;

public class AtmUseResponseDto {
    private List<AtmUseDto> data;
    private String nextInquiryKey;

    public AtmUseResponseDto(List<AtmUseDto> data, String nextInquiryKey) {
        this.data = data;
        this.nextInquiryKey = nextInquiryKey;
    }

    public List<AtmUseDto> getData() {
        return data;
    }

    public void setData(List<AtmUseDto> data) {
        this.data = data;
    }

    public String getNextInquiryKey() {
        return nextInquiryKey;
    }

    public void setNextInquiryKey(String nextInquiryKey) {
        this.nextInquiryKey = nextInquiryKey;
    }
}

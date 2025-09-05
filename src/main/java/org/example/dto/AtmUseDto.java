package org.example.dto;

public class AtmUseDto {
    private String atmType;
    private String atmNum;

    public AtmUseDto(String atmType, String atmNum) {
        this.atmType = atmType;
        this.atmNum = atmNum;
    }

    public String getAtmType() {
        return atmType;
    }

    public void setAtmType(String atmType) {
        this.atmType = atmType;
    }

    public String getAtmNum() {
        return atmNum;
    }

    public void setAtmNum(String atmNum) {
        this.atmNum = atmNum;
    }
}

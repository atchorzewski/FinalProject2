package pl.gameshop.controllers.commands;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;


public class ProductFilter {

    private String phrase;
    private Long platform;
    private Long category;

    @PositiveOrZero
    private BigDecimal minPrice;

    @PositiveOrZero
    private BigDecimal maxPrice;

    public String getPhrase() {
        return phrase;
    }

    public Long getPlatform() {
        return platform;
    }

    public Long getCategory() {
        return category;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public void setPlatform(Long platform) {
        this.platform = platform;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public boolean isEmpty(){
        return StringUtils.isEmpty(phrase) && platform == null && category == null && minPrice == null && minPrice == null;
    }

    public void clear(){
        this.phrase = "";
        this.category = null;
        this.platform = null;
        this.minPrice = null;
        this.maxPrice = null;
    }

    public String getPhraseLIKE(){
        if(StringUtils.isEmpty(phrase)) {
            return null;
        }else{
            return "%"+phrase+"%";
        }
    }


}

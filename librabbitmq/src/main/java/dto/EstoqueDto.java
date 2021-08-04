package dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EstoqueDto implements Serializable {
    private String codeProduct;
    private String quantidade;
}

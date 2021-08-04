package dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PrecoDto implements Serializable {
    private String codeProduct;
    private double preco;
}

package id.co.bca.funtravel.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO {
    private Integer idCustomer;
    private Integer total;
}

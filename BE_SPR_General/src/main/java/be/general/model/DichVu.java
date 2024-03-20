package be.general.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DichVu {
    
    @Id
    @Pattern(regexp = "^(DV|dv)[0-9]{3}$", message = "Mã KH phải bắt đầu bằng KH và 3 chử số")
    private String maDV;
    
    @NotBlank
    private String tenDV;
    
    @NotBlank
    private String donViTinh;
    
    @PositiveOrZero
    private int donGia;
    
    @OneToMany(mappedBy = "sddvDV", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<SuDungDichVu> sddvList = new HashSet<SuDungDichVu>();

    /**
     * @param maDV
     */
    public DichVu(String maDV) {
        this.maDV = maDV;
    }
    
    
}

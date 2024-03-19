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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class May {
    
    @Id
    @Pattern(regexp = "^(M|m)[0-9]{3}$", message = "Mã may phải bắt đầu bằng M và 3 chử số")
    private String maMay;
    
    @NotBlank
    private String viTri;
    
    @NotBlank
    private String trangThai;
    
    @OneToMany(mappedBy = "sdMay", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<SuDungMay> sdmList = new HashSet<SuDungMay>();

    /**
     * @param maMay
     */
    public May(String maMay) {
        this.maMay = maMay;
    }

}

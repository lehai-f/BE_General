package be.general.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    
    @Id
    @Pattern(regexp = "^(KH|kh)[0-9]{5}$", message = "Mã KH phải bắt đầu bằng KH và 5 chử số")
    private String maKH;
    
    @NotBlank
    private String tenKH;
    
    @NotBlank
    private String diaChi;
    
    @Pattern(regexp = "^(098|097|096|038|037)[0-9]{7,8}$",message = "Số DT không đúng")
    private String soDT;
    
    @NotBlank
    @Email(message = "Email invalid")
    private String email;
    
    @OneToMany(mappedBy = "sddvKH",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<SuDungDichVu> sddvList = new HashSet<SuDungDichVu>();
    
    @OneToMany(mappedBy = "sdmKH",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SuDungMay> sdmList = new HashSet<SuDungMay>();

    /**
     * @param maKH
     */
    public KhachHang(String maKH) {
        this.maKH = maKH;
    }

}

package be.general.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    private String maDV;
    
    private String tenDV;
    
    private String donViTinh;
    
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

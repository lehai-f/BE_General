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
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    
    @Id
    private String maKH;
    
    private String tenKH;
    
    private String diaChi;
    
    private String soDT;
    
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

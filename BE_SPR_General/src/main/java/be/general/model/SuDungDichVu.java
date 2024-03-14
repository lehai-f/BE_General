package be.general.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SuDungDichVu {
    
    @EmbeddedId
    private SuDungDichVuID sddvID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKH")
    @MapsId("maKH")
    private KhachHang sddvKH;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDV")
    @MapsId("maDV")
    private DichVu sddvDV;
    
    private int soLuong;
}

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuDungMay {

    @EmbeddedId
    private SuDungMayID sdmID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maMay")
    @MapsId("maMay")
    private May sdMay;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKH")
    @MapsId("maKH")
    private KhachHang sdmKH;
    
    private int thoiGianSD;
}

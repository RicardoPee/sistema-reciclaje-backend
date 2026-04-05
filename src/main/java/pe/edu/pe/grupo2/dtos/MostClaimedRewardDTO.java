package pe.edu.pe.grupo2.dtos;

public class MostClaimedRewardDTO {
    public String recompensa;
    public int cantidadreclamos;

    public int getCantidadreclamos() {
        return cantidadreclamos;
    }

    public void setCantidadreclamos(int cantidadreclamos) {
        this.cantidadreclamos = cantidadreclamos;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }
}

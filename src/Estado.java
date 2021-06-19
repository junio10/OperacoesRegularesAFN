
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junio
 */
public class Estado {
    public int idEstado;
    public String nomeEstado;
    public boolean Einicial;//SE O ESTADO É INICIAL
    public boolean Efinal;//SE O ESTADO É FINAL
    List<Transicao> transicaoAUT = new ArrayList<>();

    public List<Transicao> getTransicaoAUT() {
        return transicaoAUT;
    }

    public void setTransicaoAUT(List<Transicao> transicaoAUT) {
        this.transicaoAUT = transicaoAUT;
    }

    @Override
    public String toString() {
        return "Estado{" + "idEstado=" + idEstado + ", nomeEstado=" + nomeEstado + ", Einicial=" + Einicial + ", Efinal=" + Efinal + '}';
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public boolean isEinicial() {
        return Einicial;
    }

    public void setEinicial(boolean Einicial) {
        this.Einicial = Einicial;
    }

    public boolean isEfinal() {
        return Efinal;
    }

    public void setEfinal(boolean Efinal) {
        this.Efinal = Efinal;
    }
    
}

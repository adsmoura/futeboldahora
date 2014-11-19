/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.edu.mouralacerda.futeboldahora.bean;

import br.com.edu.mouralacerda.futeboldahora.dao.TimesDao;
import br.com.edu.mouralacerda.futeboldahora.modelo.Times;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;




/**
 *
 * @author Phillipe.Roger
 */
@ManagedBean

public class TimesBean {

   private Times time = new Times();

    private List<Times> timeLista = new ArrayList<Times>();

    public Times getTime() {
        return time;
    }

    public void setTime(Times time) {
        this.time = time;
    }

    public List<Times> getTimeLista() {
        return timeLista;
    }

    public void setTimeLista(List<Times> timeLista) {
        this.timeLista = timeLista;
    }
    
    private final TimesDao timeDao = new TimesDao();

    public void salvarTimes() {
        timeDao.salvar(time);
        time = new Times();
        carregaLista();  
    }
    public TimesBean() {
    }
    
    @PostConstruct
    public void carregaLista(){
        timeLista = timeDao.consultarLista();
    }
    
}

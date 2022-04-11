package cr.fi.migarrotera;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstance;

import javax.inject.Named;


@Named
public class CalcularMonto  implements JavaDelegate{


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String ingresos1 = (String) delegateExecution.getVariable("ingresos");
        String montoSolicitado2 = (String) delegateExecution.getVariable("monto");

        int ingresos = Integer.parseInt(ingresos1);
        int montoSolicitado = Integer.parseInt(montoSolicitado2);

        if(((ingresos *0.80) -montoSolicitado)>0){

            System.out.println("Prestamo Aprobado");
            delegateExecution.setVariable("montoAprobado",montoSolicitado);
            delegateExecution.setVariable("estado",true);




        }else{

            delegateExecution.setVariable("montoAprobado",montoSolicitado);
            delegateExecution.setVariable("estado",false);
        }


    }
}

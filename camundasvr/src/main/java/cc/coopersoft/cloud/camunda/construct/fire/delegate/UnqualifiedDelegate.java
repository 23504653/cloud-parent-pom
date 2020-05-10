package cc.coopersoft.cloud.camunda.construct.fire.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class UnqualifiedDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {

    }
}

package org.springstudy.binding.binder;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
import org.springstudy.common.dto.Level;

/**
 * @author wangeun.lee@sk.com
 */
@Component
public class MyWebBindingInitializer implements WebBindingInitializer {
    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Level.class, new LevelPropertyEditor());
    }
}

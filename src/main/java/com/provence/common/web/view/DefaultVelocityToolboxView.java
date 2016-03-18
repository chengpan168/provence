package com.provence.common.web.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.springframework.web.servlet.view.velocity.VelocityView;

/**
 * Created by panwang.chengpw on 2016/3/3.
 */
public class DefaultVelocityToolboxView extends VelocityView {

    @Override
    protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (getApplicationContext().containsLocalBean("velocityToolboxFactoryBean")) {
            VelocityToolboxFactoryBean velocityToolboxFactoryBean = (VelocityToolboxFactoryBean) getApplicationContext().getBean(
                    "velocityToolboxFactoryBean");
            model.putAll(velocityToolboxFactoryBean.getTools());

        }

        // Create a velocityContext instance.
        VelocityContext context = new VelocityContext(model);
        return context;
    }

}
